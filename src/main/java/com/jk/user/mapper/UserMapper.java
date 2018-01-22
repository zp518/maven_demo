package com.jk.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.user.model.Power;
import com.jk.user.model.Roles;
import com.jk.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	/** <pre>selCount(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午3:32:09    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午3:32:09    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	int selCount();

	/** <pre>selList(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午3:32:13    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午3:32:13    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param user
	 * @return</pre>    
	 */
	List<User> selList(@Param("stopPos") Integer stopPos, @Param("startPos") Integer startPos);

	//查询角色
	List<User> getRoles(Integer id);

	/** <pre>selRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午7:28:52    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午7:28:52    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Roles> selRoles(@Param("stopPos") Integer stopPos, @Param("startPos") Integer startPos);

	/** <pre>selRolesCount(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午7:35:33    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午7:35:33    
	 * 修改备注： 
	 * @return</pre>    
	 */
	int selRolesCount();

	/** <pre>delRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午8:42:06    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午8:42:06    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void delRoles(Integer id);

	/** <pre>updateRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月25日 下午8:44:25    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月25日 下午8:44:25    
	 * 修改备注： 
	 * @param id
	 * @param rolesId</pre>    
	 */
	void updateRoles(@Param("id") Integer id, @Param("list") List<Integer> list);

	/** <pre>getPower(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午4:46:50    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午4:46:50    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<Roles> getPower(Integer id);

	/** <pre>powerSel(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午5:10:52    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午5:10:52    
	 * 修改备注： 
	 * @param list 
	 * @return</pre>    
	 */
	List<Power> powerSel(List<Integer> list);

	/** <pre>delPower(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午5:30:08    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午5:30:08    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void delPower(Integer id);

	/** <pre>updatePower(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月26日 下午5:31:00    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月26日 下午5:31:00    
	 * 修改备注： 
	 * @param id
	 * @param list</pre>    
	 */
	void updatePower(@Param("id") Integer id, @Param("list") List<String> list);

	/** <pre>selRolesChange(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午2:10:10    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午2:10:10    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Roles> selRolesChange();

	/** <pre>selPowerChange(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午2:31:36    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午2:31:36    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<Power> selPowerChange(int id);

	/** <pre>selUserRoles(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午4:06:04    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午4:06:04    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<User> selUserRoles(Integer id);

	/** <pre>selZtree(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月27日 下午5:06:27    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月27日 下午5:06:27    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Power> selZtree();

	/** <pre>Login(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月28日 上午11:38:42    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月28日 上午11:38:42    
	 * 修改备注： 
	 * @param userName
	 * @return</pre>    
	 */
	User Login(String userName);

	/** <pre>selUserOne(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月29日 上午11:39:08    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月29日 上午11:39:08    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<User> selUserOne(Integer id);

	/** <pre>selUserOneById(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月29日 下午2:46:44    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月29日 下午2:46:44    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<User> selUserOneById(Integer id);

	/** <pre>saveUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：张萍萍 cht_java@126.com     
	 * 创建时间：2017年12月29日 下午3:24:12    
	 * 修改人：张萍萍 cht_java@126.com      
	 * 修改时间：2017年12月29日 下午3:24:12    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	void saveUserById(User user);
}