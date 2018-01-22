/** 
 * <pre>项目名称:maven_demo 
 * 文件名称:TreeService.java 
 * 包名:com.jk.tree.service 
 * 创建日期:2017年12月15日下午12:15:59 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.tree.service;

import java.util.List;

import com.jk.tree.model.Tree;

/** 
 * <pre>项目名称：maven_demo    
 * 类名称：TreeService    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午12:15:59    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午12:15:59    
 * 修改备注：       
 * @version </pre>    
 */
public interface TreeService {

	/** <pre>selTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月15日 下午1:01:03    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月15日 下午1:01:03    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<Tree> selTreeList(Integer id);

}
