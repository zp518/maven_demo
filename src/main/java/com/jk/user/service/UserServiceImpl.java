/** 
 * <pre>项目名称:maven-service 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.jk.user.service 
 * 创建日期:2017年12月15日下午5:24:23 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jk.user.mapper.UserMapper;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jk.user.model.Power;
import com.jk.user.model.Roles;
import com.jk.user.model.User;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/** 
 * <pre>项目名称：maven-service    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午5:24:23    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午5:24:23    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Resource(name="shardedJedisPool")
	private ShardedJedisPool shardedJedisPool;

	//查询列表user用户展示列表
	public String selList(Integer pageSize, Integer start) {
		//查询总数
		if(pageSize==null){
			pageSize=3;
		}
		if(start==null){
			start=0;
		}
		int count=userMapper.selCount();
		List<User> list=userMapper.selList(pageSize,start);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		String jsonString = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd", SerializerFeature.DisableCircularReferenceDetect);
		return jsonString;
	}
	//查询角色  根据用户id查询对应的角色
	public List<User> getRoles(Integer id) {
		
		return userMapper.getRoles(id);
	}
	//查询角色表  展示列表
	public String selRoles(Integer pageSize, Integer start) {
		int count=userMapper.selRolesCount();
		List<Roles> selRoles = userMapper.selRoles(pageSize,start);
		Map<String, Object> mp=new HashMap<String, Object>();
		mp.put("total", count);
		mp.put("rows", selRoles);
		String jsonString = JSON.toJSONString(mp, SerializerFeature.DisableCircularReferenceDetect);
		
		return jsonString;
	}
	//修改权限  根据用户id 修改用户的角色  修改之前先删除
	public void updateRoles(Integer id, int[] rolesId) {
		
		userMapper.delRoles(id);
		if(rolesId.length>0){
			List<Integer> list=new ArrayList<Integer>();
			for (int i = 0; i < rolesId.length; i++) {
				list.add(rolesId[i]);
				
			}
			userMapper.updateRoles(id,list);
		}
		ShardedJedis resource = shardedJedisPool.getResource();
		resource.del("PowerList_"+id);
	}
	//查询角色拥有的权利   根据角色id 查询角色对应的权利
	public List<Roles> getPower(Integer id) {
		
		return userMapper.getPower(id);
	}
	//查询同步树  权利表  根据角色的id 多个id 进行查询角色对应的权利
	public List<Power> powerSel(String ids) {
		List<Integer> list=new ArrayList<Integer>();
		if(ids.length()>0){
			String[] idArr = ids.split(",");
			for (int i = 0; i < idArr.length; i++) {
				list.add(Integer.parseInt(idArr[i]));
			}
		}
		return userMapper.powerSel(list);
	}

	//修改角色的权限  根据角色的id 修改角色拥有的权限
	public void updatePower(Integer id, String powerIds) {
		userMapper.delPower(id);
		String[] ids=powerIds.split(",");
		if(ids.length>0){
			List<String> list=new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				list.add(ids[i]);
				
			}
			userMapper.updatePower(id,list);
		}
		ShardedJedis resource = shardedJedisPool.getResource();
		resource.del("PowerList_"+id);
		
	}
	//查询角色表    未用
	public List<Roles> selRolesChange() {
		// TODO Auto-generated method stub
		return userMapper.selRolesChange();
	}

	//根据角色id查询 当前角色 所拥有的权利
	public List<Power> selPowerChange(int id) {
		// TODO Auto-generated method stub
		return userMapper.selPowerChange(id);
	}

	//根据用户Id查询用户对应的所有角色
	public List<User> selUserRoles(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selUserRoles(id);
	}
	//查询树菜单 没有条件 页面加载
	public List<Power> selZtree() {
		// TODO Auto-generated method stub
		return userMapper.selZtree();
	}
	//登录
	public int login(User user, HttpServletRequest request) {
		int i=-2;
		User user1=userMapper.Login(user.getUsername());
		if(user1!=null&&user1.getUserid()!=null){
			if(user1.getPassword().equals(user.getPassword())){
				//登录成功
				HttpSession session = request.getSession();
				session.setAttribute("LoginUser", user1);
				request.getServletContext().setAttribute(user1.getUserid()+"", session.getId());
				//如果登录成功返回的i是当前用户的id
				i=user1.getUserid();
			}else{
				//密码错误
				i=-1;
			}
			
		}else{
			//账号不存在
			i=-2;
			
		}
		return i;
	}
	//当前用户的id 所对应的角色和权利  查询之后存储到redis
	public List<Power> selPowerRedis(Integer userid) {
		//查询用户的角色
		List<User> list = userMapper.getRoles(userid);
		List<Integer> rolesList=new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			Integer roles = user.getUserRoles();
			rolesList.add(roles);
		}
		//根据拥有的角色id 进行条件查询 查询出每个角色所对应的权利
		List<Power> listPower=  userMapper.powerSel(rolesList);
		return listPower;
	}
	/* (non-Javadoc)    
	 * @see com.jk.user.service.UserService#selUserOne(java.lang.Integer)    
	 */
	public List<User> selUserOne(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selUserOneById(id);
	}
	/* (non-Javadoc)    
	 * @see com.jk.user.service.UserService#saveUserById(com.jk.user.model.User)    
	 */
	public void saveUserById(User user) {
		// TODO Auto-generated method stub
		 userMapper.saveUserById(user);
	}


}
