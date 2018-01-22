/** 
 * <pre>项目名称:maven-vi 
 * 文件名称:UserCon.java 
 * 包名:com.jk.user.controller 
 * 创建日期:2017年12月15日下午5:09:53 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.controller;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jk.user.model.Power;
import com.jk.user.model.Roles;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import com.jk.util.BaseAction;

/** 
 * <pre>项目名称：maven-vi    
 * 类名称：UserCon    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午5:09:53    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午5:09:53    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("user")
public class UserCon {
	
	@Autowired
	private UserService userService;
	
	//跳转List页面
	@RequestMapping("toList")
	public String toList(){
		
		return "view/List";
	}
	//跳转角色List页面
	@RequestMapping("toRolesList")
	public String toRolesList(){
		
		return "view/ListRoles";
	}
	
	//跳转改变事件的页面
	@RequestMapping("toChangePage")
	public String toChangePage(){
		
		return "view/turnPage";
	}
	
	//查询列表
		@RequestMapping("selList")
		public void selList(Integer pageSize,Integer start,HttpServletResponse response){
			
			String list = userService.selList(pageSize,start);
			BaseAction.responseWrite(response, list);
		}
	
	
	
	//查询角色  展示列表
	@RequestMapping("selRoles")
	@ResponseBody
	public String selRoles(Integer pageSize, Integer start){
		
		String roles = userService.selRoles(pageSize,start);
		return roles;
		
	}
	
	
	//树菜单 查询权利就行回显
	@RequestMapping("powerSel")
	@ResponseBody
	public List<Power> powerSel(String ids){
		
		 List<Power> list=userService.powerSel(ids);
		return list;
	}
	//查询角色 下拉列表
	@RequestMapping("selRolesChange")
	@ResponseBody
	public List<Roles> selRolesChange(){
		
		List<Roles> list=userService.selRolesChange();
		return list;
	}
	
	//查树菜单
	@RequestMapping("selZtree")
	@ResponseBody
	public List<Power> selZtree(){
		
		List<Power> list=userService.selZtree();
		return list;
	}
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
	
	
	
	
	

}
