/** 
 * <pre>项目名称:maven-service 
 * 文件名称:UserService.java 
 * 包名:com.jk.user.service 
 * 创建日期:2017年12月15日下午5:24:10 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jk.user.model.Power;
import com.jk.user.model.Roles;
import com.jk.user.model.User;

/** 
 * <pre>项目名称：maven-service    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：张萍萍 cht_java@126.com    
 * 创建时间：2017年12月15日 下午5:24:10    
 * 修改人：张萍萍 cht_java@126.com  
 * 修改时间：2017年12月15日 下午5:24:10    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserService {

	/** <pre>selList(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月15日 下午6:16:21    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月15日 下午6:16:21    
	 * 修改备注： 
	 * @param pageSize
	 * @param start</pre>    
	 */
	public String selList(Integer pageSize, Integer start);
	/** <pre>getRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午7:06:32    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午7:06:32    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public List<User> getRoles(Integer id);

	/** <pre>selRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午7:28:13    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午7:28:13    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public String selRoles(Integer pageSize, Integer start);

	/** <pre>updateRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午8:41:25    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午8:41:25    
	 * 修改备注： 
	 * @param id
	 * @param rolesId</pre>    
	 */
	public void updateRoles(Integer id, int[] rolesId);

	/** <pre>getPower(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午4:45:00    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午4:45:00    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public List<Roles> getPower(Integer id);

	/** <pre>powerSel(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午5:10:15    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午5:10:15    
	 * 修改备注： 
	 * @param ids 
	 * @return</pre>    
	 */
	public List<Power> powerSel(String ids);

	/** <pre>updatePower(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午5:29:26    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午5:29:26    
	 * 修改备注： 
	 * @param id
	 * @param powerIds</pre>    
	 */
	public void updatePower(Integer id, String powerIds);

	/** <pre>selRolesChange(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午2:09:15    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午2:09:15    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Roles> selRolesChange();

	/** <pre>selPowerChange(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午2:28:50    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午2:28:50    
	 * 修改备注： 
	 * @param parseInt
	 * @return</pre>    
	 */
	public List<Power> selPowerChange(int parseInt);

	/** <pre>selUserRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午4:04:54    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午4:04:54    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public List<User> selUserRoles(Integer id);

	/** <pre>selZtree(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午5:05:41    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午5:05:41    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Power> selZtree();

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月28日 上午11:37:08    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月28日 上午11:37:08    
	 * 修改备注： 
	 * @param user
	 * @param request
	 * @return</pre>    
	 */
	public int login(User user, HttpServletRequest request);

	/** <pre>selPowerRedis(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月28日 下午1:48:06    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月28日 下午1:48:06    
	 * 修改备注： 
	 * @param userid
	 * @return</pre>    
	 */
	public List<Power> selPowerRedis(Integer userid);
	/** <pre>selUserOne(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月29日 上午11:38:39    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月29日 上午11:38:39    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	public List<User> selUserOne(Integer id);
	/** <pre>saveUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月29日 下午3:23:32    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月29日 下午3:23:32    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	public void saveUserById(User user);


}
