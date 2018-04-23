package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.User;
import com.mcfish.entity.common.UserCoupon;
import com.mcfish.entity.common.UserMoney;
import com.mcfish.entity.common.UserRecord;
import com.mcfish.service.common.IUserService;
import com.mcfish.util.PageData;

/**
 * 用户管理serviceImpl
 * @author WangHaibo
 * @date 2018年4月19日 下午2:18:14
 * @version 1.0
 */
@Service ("userServiceImpl")
public class UserServiceImpl implements IUserService{
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	//根据条件获取所有用户信息
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<User>) dao.findForList("UserMapper.getAllUserList", pd);
	}


	//根据用户ID查找用户
	@Override
	public User getUserById(int userId) throws Exception {
		return  (User) dao.findForObject("UserMapper.getUserById",userId);
	}

	
	//更新用户基本信息
	@Override
	public void updateUser(PageData pageData) throws Exception {
		dao.update("UserMapper.updateUser", pageData);
		
	}

	
	//更改用户状态
	@Override
	public void updateUserStatus(PageData pageData) throws Exception {
		dao.update("UserMapper.updateUserStatus", pageData);
	}

	
	//根据用户id删除
	@Override
	public void deleteUser(int id) throws Exception {
		dao.delete("UserMapper.deleteUser", id);
	}


	
	
	//查询用户订单列表数据
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRecord> getUserOrderList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<UserRecord>) dao.findForList("UserMapper.getUserOrderList", pd);
	}
	
	
	//根据id查询用户订单信息
	@Override
	public UserRecord selectUserOrderInfoById(int orderId) throws Exception {
		return (UserRecord) dao.findForObject("UserMapper.selectUserOrderInfoById", orderId);
	}
	
	
	//更新消费记录表里的用户余额
	@Transactional
	@Override
	public void updateUserOrderMoney(PageData pd) throws Exception {
		dao.update("UserMapper.updateUserOrderMoney", pd);
		
	}
	
	
	//修改用户订单支付状态（将已支付的订单修改为退款）
	@SuppressWarnings("unused")
	@Transactional
	@Override
	public void updateUserOrderPayStatus(PageData pd) throws Exception {
		//判断当前订单是否允许退款
		UserRecord userOrderInfo = this.selectUserOrderInfoById(Integer.parseInt(pd.get("orderId").toString()));
		if (userOrderInfo.getPay_status() == 1) {
			//已支付才可以退款
			pd.put("order_no", userOrderInfo.getOrder_no());
			dao.update("UserMapper.updateUserOrderPayStatus", pd);
			
			//退款(用户余额 + 订单价格)
			//1.更新用户消费记录表里面的用户余额
			int toBackMoney = userOrderInfo.getAmount() + userOrderInfo.getMoney();
			pd.put("money", toBackMoney);
			this.updateUserOrderMoney(pd);
			
			//2.更新用户表里面的用户余额
			pd.remove("status");
			pd.put("id", userOrderInfo.getUser_id());
			this.updateUser(pd);
		}
		
	}


	//根据id查询用户的钱包
	@SuppressWarnings("unchecked")
	@Override
	public List<UserMoney> getUserMoneyList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<UserMoney>) dao.findForList("UserMapper.getUserMoneyList", pd);
	}


	//用户优惠券列表数据
	@SuppressWarnings("unchecked")
	@Override
	public List<UserCoupon> getUserCouponList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<UserCoupon>) dao.findForList("UserMapper.getUserCouponList", pd);
	}


	//充值/减扣
	@Transactional
	@Override
	public void updateUserAddOrReduce(PageData pd) throws Exception {
		
		int type = Integer.parseInt(pd.get("type").toString());
		
		if(type == 1) {
			//充值
			//1.平台余额减少
			dao.update("updateSystemMoney.updateSystemMoney", pd);
			//2.平台记录
			
			//3.用户的余额增加
			
			//4.用户消费记录表记录
			
		}
		if(type == 2) {
			//减扣
			//1.平台余额增加
			
			//2.平台记录
			
			//3.用户余额减少
			
			//4.用户消费记录表记录
			
		}
	}

	
}
