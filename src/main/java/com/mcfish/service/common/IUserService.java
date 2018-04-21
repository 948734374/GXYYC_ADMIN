package com.mcfish.service.common;

import java.util.List;

import com.mcfish.entity.common.User;
import com.mcfish.entity.common.UserMoney;
import com.mcfish.entity.common.UserRecord;
import com.mcfish.util.PageData;

/**
 * 用户管理service
 * @author WangHaibo
 * @date 2018年4月19日 下午2:17:25
 * @version 1.0
 */
public interface IUserService {
	
	/**
	 * 根据条件获取所有用户信息
	 * @author WangHaibo
	 * @date 2018年4月19日 下午2:17:35 
	 * @param pageData
	 * @return
	 * @throws Exception
	 * @return List<User>
	 */
	List<User> getAllUserList(PageData pageData) throws Exception;
	
	
	/**
	 * 根据用户ID查找用户
	 * @author WangHaibo
	 * @date 2018年4月19日 下午2:17:55 
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return User
	 */
	User getUserById(int userId) throws Exception;
	
	
	/**
	 * 更新用户基本信息
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:21:13 
	 * @param pageData
	 * @throws Exception
	 * @return void
	 */
	void updateUser(PageData pageData) throws Exception;
	
	
	/**
	 * 更改用户状态
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:21:20 
	 * @param pageData
	 * @throws Exception
	 * @return void
	 */
	void updateUserStatus(PageData pageData) throws Exception;
	

	/**
	 * 根据用户id删除
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:21:27 
	 * @param id
	 * @throws Exception
	 * @return void
	 */
	void deleteUser(int id) throws Exception;


	/**
	 * 查询用户订单列表数据
	 * @author WangHaibo
	 * @date 2018年4月20日 下午2:37:17 
	 * @param pd
	 * @return
	 * @return List<UserRecord>
	 */
	List<UserRecord> getUserOrderList(PageData pd) throws Exception;

	
	/**
	 * 根据id查询用户订单信息
	 * @author WangHaibo
	 * @date 2018年4月20日 下午4:29:03 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return UserRecord
	 */
	UserRecord selectUserOrderInfoById(int orderId) throws Exception;
	
	
	/**
	 * 修改用户订单支付状态
	 * @author WangHaibo
	 * @date 2018年4月20日 下午2:37:54 
	 * @param pd
	 * @throws Exception
	 * @return void
	 */
	void updateUserOrderPayStatus(PageData pd) throws Exception;


	/**
	 * 退款给用户
	 * @author WangHaibo
	 * @date 2018年4月20日 下午5:27:42 
	 * @throws Exception
	 * @return void
	 */
	void updateUserOrderMoney(PageData pd) throws Exception;
	
	
	/**
	 * 根据id查询用户的钱包
	 * @author WangHaibo
	 * @date 2018年4月20日 下午4:25:19 
	 * @param pd
	 * @return
	 * @return List<UserMoney>
	 */
	List<UserMoney> getUserMoneyList(PageData pd) throws Exception;
	
}
