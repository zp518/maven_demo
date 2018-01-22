/** 
 * <pre>项目名称:maven_demo 
 * 文件名称:TreeController.java 
 * 包名:com.jk.tree.controller 
 * 创建日期:2017年12月15日下午12:14:40 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.tree.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.tree.model.Tree;
import com.jk.tree.service.TreeService;

/** 
 * <pre>项目名称：maven_demo    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午12:14:40    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午12:14:40    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("tree")
public class TreeController {

	 @Autowired
	 private TreeService treeService;
	 
	 @RequestMapping("selTreeList")
		@ResponseBody
		public List<Tree>  selTreeList(){
			//查询父节点
			List<Tree> list=treeService.selTreeList(0);
			//将查询出来的父节点 当作条件 再查询子节点
			List<Tree> listSel =selChild(list);
			return listSel;
		
		}


		//查询子节点
		public List<Tree> selChild(List<Tree> list) {
			//定义一个新的集合 用来装查询出来的数据
			List<Tree> childList=new ArrayList<Tree>();
			for (int i = 0; i < list.size(); i++) {
				Tree trees = list.get(i);
				
				//将父节点的id当作条件查询 因为子节点的pid等于父节点的id
				List<Tree> listQ=treeService.selTreeList(trees.getId());
				//判断子节点下是否还有子节点
				if(listQ.size()>0){
					List<Tree> selChild = selChild(listQ);
					trees.setNodes(selChild);
					childList.add(trees);
				}else{
					childList.add(trees);
				}
			}
			return childList;
		}
}
