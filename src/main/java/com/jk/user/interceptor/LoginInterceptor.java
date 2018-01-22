package com.jk.user.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jk.user.model.Power;
import com.jk.user.model.User;
import com.jk.user.service.UserService;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class LoginInterceptor implements HandlerInterceptor {

	@Resource(name="shardedJedisPool")
	private ShardedJedisPool shardedJedisPool;
	
	@Autowired
	private UserService userService;
    /**
     * 执行完成之后调用该方法 在执行该方法时，相应的controller方法已经完成了页面跳转工作 成功跳转到对应页面
     * 此方法主要用来关闭一些常用资源使用 例如 IO流 记录日志
     * 此方法在登录拦截器中一般不会被使用到
     */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
    /**
     * 请求处理方法
     * 在执行完毕controller方法之后，页面还没有完成跳转时 执行此方法 能够为controller方法设置重新跳转页面
     * 在实际使用拦截器时 一般也用不到此方法
     */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
    /**
     * 在controller方法被调用之前调用该方法
     * 此方法返回true 则后续方法继续执行放过拦截
     * 返回false时，后续的所有方法不再继续执行,拦截到请求
     */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		response.setHeader("Content-type", "text/json;charset=UTF-8");
		//获取到当前正在访问的请求路径 getRequestURI能够获取到当前发送过来的请求信息
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		HttpSession session = request.getSession();
		 String contextPath = request.getContextPath();
		
		 String ipAddress = request.getHeader("x-forwarded-for");  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
             ipAddress = request.getHeader("Proxy-Client-IP");  
         }  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
             ipAddress = request.getHeader("WL-Proxy-Client-IP");  
         }  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
             ipAddress = request.getRemoteAddr();  
             if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                 //根据网卡取本机配置的IP  
                 InetAddress inet=null;  
                 try {  
                     inet = InetAddress.getLocalHost();  
                 } catch (UnknownHostException e) {  
                     e.printStackTrace();  
                 }  
                 ipAddress= inet.getHostAddress();  
             }  
         }  
         //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
         if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
             if(ipAddress.indexOf(",")>0){  
                 ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
             }  
         }  
         System.out.println("IP地址:"+ipAddress);
         
		//获得本机IP
		String remoteHost = request.getRemoteHost();
		System.out.println("访问的IP地址:"+remoteHost);
		
		User user= (User) session.getAttribute("LoginUser");
		if(user!=null){
			//  获取reids  对象   
			ShardedJedis resource = shardedJedisPool.getResource();
			//判断redis数据库中 是否存在此权限的key  返回true 或者false
			if(!resource.exists("PowerList_"+user.getUserid())){
				//等于false 不存在  如果不存在 进行查询 存入redis 
				List<Power> list=userService.selPowerRedis(user.getUserid());
				List<String> listUrl=new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					Power power = list.get(i);
				if(power.getPuri()!=null&&power.getPuri()!=" "){
					resource.sadd("PowerList_"+user.getUserid(), power.getPuri());
					}
				}
				
			}
			String replace = requestURI.replace(contextPath+"/", "");
			Boolean sismember = resource.sismember("PowerList_"+user.getUserid(),replace);
			if(!sismember){  //  判端  url  是否  存在 
				response.sendRedirect(contextPath+"/loginTow.jsp");
				return false;	
			}
			//单点登录的判断
			Object attribute = session.getServletContext().getAttribute(user.getUserid()+"");
			if(!session.getId().equals(attribute)){
				response.sendRedirect(contextPath+"/login.jsp");
				return false;	
			}
			return true;
		}
		else{
			System.out.println("头信息 :"+request.getHeader("X-Requested-With"));
			if(StringUtils.equals("XMLHttpRequest", request.getHeader("X-Requested-With"))){
				
			
				/*
				 * 
				 * request.getSchema()可以返回当前页面使用的协议，http 或是 https;
				request.getServerName()可以返回当前页面所在的服务器的名字;
				request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是80;
				request.getContextPath()可以返回当前页面所在的应用的名字;
				Cookie[] cookies = request.getCookies();  //  获得Cookies
				 * */
				String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ contextPath+ "/";
				//   http:127.0.0.1:80/product/login.jsp
				
				
				response.setHeader("SESSIONSTATUS", "TIMEOUT");  //  设置相应头信息   
				response.setHeader("CONTEXTPATH", basePath+"login.jsp");

				response.setStatus(HttpServletResponse.SC_FORBIDDEN);

				return false;
			}
			
			
			response.sendRedirect("../login.jsp");
			return false;
		}
		
		//根据请求路径判断是否需要放过 拦截 判断是登录方法则放过拦截
		 //if(requestURI.contains("loging/long.do")){
					//判断当前请求是否为登录或注册请求 若为登录或注册请求则放过拦截 不做任何操作		
			//	}
	}
	
}
