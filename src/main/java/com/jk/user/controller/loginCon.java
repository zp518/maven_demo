/** 
 * <pre>项目名称:UserRoles-maven 
 * 文件名称:loginCon.java 
 * 包名:com.jk.user.controller 
 * 创建日期:2017年12月28日上午11:21:18 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.user.model.User;
import com.jk.user.service.UserService;

/** 
 * <pre>项目名称：UserRoles-maven    
 * 类名称：loginCon    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月28日 上午11:21:18    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月28日 上午11:21:18    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("login")
public class loginCon {
	@Autowired
	private UserService userService;
	
		//登录
		@RequestMapping("login")
		@ResponseBody
		public int login(User user,HttpServletRequest request){
			
			int i=userService.login(user,request);
			return i;
		}
	

}
