/** 
 * <pre>项目名称:UserRoles-maven 
 * 文件名称:ButtonCon.java 
 * 包名:com.jk.user.controller 
 * 创建日期:2017年12月28日下午4:13:41 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jk.user.model.Power;
import com.jk.user.model.Roles;
import com.jk.user.model.User;
import com.jk.user.service.UserService;

/** 
 * <pre>项目名称：UserRoles-maven    
 * 类名称：ButtonCon    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月28日 下午4:13:41    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月28日 下午4:13:41    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("butt")
public class ButtonCon {
	@Autowired
	private UserService userService;
	
	//根据用户查询所拥有的所有的角色
		@RequestMapping("selUserRoles")
		public ModelAndView selUserRoles(Integer id){
			
			ModelAndView md=new ModelAndView();
			List<User> list=userService.selUserRoles(id);
			String rolesIds="";
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				Integer roles = user.getUserRoles();
				rolesIds+=","+roles;
			}
			rolesIds = rolesIds.substring(1);
			md.addObject("userName", (list.get(0)).getUsername());
			md.addObject("userList", list);
			md.addObject("rolesIds", rolesIds);
			md.addObject("userId", id);
			md.setViewName("view/turnPage");
			return md;
		}
		//查询角色
		@RequestMapping("getRoles")
		public ModelAndView getRoles(Integer id){
			
			ModelAndView md=new ModelAndView();
			List<User> list=userService.getRoles(id);
			String list2="";
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				Integer roles = user.getUserRoles();
				list2+=","+roles;
			}
			list2=list2.substring(1);
			md.addObject("rolesList", list2);
			md.addObject("userId", id);
			md.setViewName("view/updateDialog");
			return md;
		}
		//给用户修改角色
		@RequestMapping("updateRoles")
		@ResponseBody
		public void updateRoles(Integer id,int[] rolesId){
			
			userService.updateRoles(id,rolesId);
		}
		//查询权利
		@RequestMapping("getPower")
		public ModelAndView getPower(Integer id){
			
			ModelAndView md=new ModelAndView();
			List<Roles> list=userService.getPower(id);
			String list2="";
			for (int i = 0; i < list.size(); i++) {
				 Roles roles2 = list.get(i);
				 String powerId = roles2.getPowerId();
				list2+=","+powerId;
			}
			list2=list2.substring(1);
			md.addObject("powerList", list2);
			md.addObject("rolesId", id);
			md.setViewName("view/upRolesZtree");
			return md;
		}
		//给角色修改权限
		@RequestMapping("updatePower")
		@ResponseBody
		public void updatePower(Integer id,String powerIds){
			
			userService.updatePower(id,powerIds);
		}
		//根据角色id 进行查询权利 展示树菜单  角色所拥有的树
		@RequestMapping("selPowerChange")
		@ResponseBody
		public List<Power> selPowerChange(Integer id){
			
			List<Power> list=userService.selPowerChange(id);
			
			return list;
		}
		//根据用户id 查询用户的信息
		@RequestMapping("selUserOne")
		@ResponseBody
		public ModelAndView selUserOne(Integer id){
			ModelAndView mv = new ModelAndView();
			List<User> list=userService.selUserOne(id);
			List<Roles> listRows = new ArrayList<Roles>();
			for(int i=0;i<list.size();i++){
				Roles roles = new Roles();
				roles.setRoleid(list.get(i).getUserRoles());
				roles.setDescription(list.get(i).getDepName());
				listRows.add(roles);
			}
			mv.addObject("hy", list.get(0));
			mv.addObject("uroles", listRows);
			mv.setViewName("view/user_up");
			return mv;
		}
		
		//跟新用户信息
		@RequestMapping("saveUserById")
		@ResponseBody
		public String saveUserById(User user,HttpServletRequest request){
			HttpSession session = request.getSession();
			session.setAttribute("LoginUser", user);
			
			userService.saveUserById(user); 
		    return user.getUsername();
		}
		

}
