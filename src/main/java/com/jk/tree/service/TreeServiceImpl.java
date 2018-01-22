/** 
 * <pre>项目名称:maven_demo 
 * 文件名称:TreeServiceImpl.java 
 * 包名:com.jk.tree.service.Impl 
 * 创建日期:2017年12月15日下午12:16:24 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.tree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.tree.mapper.TreeMapper;
import com.jk.tree.model.Tree;
import com.jk.tree.service.TreeService;


/** 
 * <pre>项目名称：maven_demo    
 * 类名称：TreeServiceImpl    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午12:16:24    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午12:16:24    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class TreeServiceImpl implements TreeService{

	@Autowired
	private TreeMapper treeMapper;
	
	
	public List<Tree> selTreeList(Integer id) {
		// TODO Auto-generated method stub
		return treeMapper.selectByPrimaryKey(id);
	}
	
	

	
}
