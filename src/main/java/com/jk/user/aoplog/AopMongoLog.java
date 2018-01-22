package com.jk.user.aoplog;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.jk.user.mapper.UserMapper;
import com.jk.user.model.Power;
import com.jk.user.model.User;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;



public class AopMongoLog  implements MethodBeforeAdvice,AfterReturningAdvice  {
	
	@Resource(name="shardedJedisPool")
	private ShardedJedisPool shardedJedisPool;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserMapper userMapper;
	// 后置通知
	public void afterReturning(Object returnVal, Method method, Object[] params, Object implUrl) throws Throwable {

		ShardedJedis resource = shardedJedisPool.getResource();
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("LoginUser");
		if(resource.exists("PowerList_"+user.getUserid())){
			resource.del("PowerList_"+user.getUserid());
			}
		List<User> list=userMapper.getRoles(user.getUserid());
		List<Integer> rolesList=new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			User user2 = list.get(i);
			Integer roles = user2.getUserRoles();
			rolesList.add(roles);
		}
			//根据拥有的角色id 进行条件查询 查询出每个角色所对应的权利
			List<Power> listPower=  userMapper.powerSel(rolesList);
			
			List<String> listUrl=new ArrayList<String>();
			for (int i = 0; i < listPower.size(); i++) {
				Power power = listPower.get(i);
				if(power.getPuri()!=null&&power.getPuri()!=" "){
					resource.sadd("PowerList_"+user.getUserid(), power.getPuri());
				}
			}
		}
		
		
	
	
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
	}
	
	
	

}
