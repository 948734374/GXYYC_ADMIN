package com.mcfish.service.common;

import java.util.List;

import com.mcfish.entity.common.Coupon;
import com.mcfish.entity.common.Shop;
import com.mcfish.util.PageData;


/**
 * 商家管理IService
 * @author WangHaibo
 * @date 2018年4月24日 下午4:39:35
 * @version 1.0
 */
public interface IShopService {

	
	/**
	 * 获取所有商家列表数据
	 * @author WangHaibo
	 * @date 2018年4月24日 下午4:43:40 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Shop>
	 */
	List<Shop> selectAllShops(PageData pd) throws Exception;

	
	/**
	 * 获取商家详情
	 * @author WangHaibo
	 * @date 2018年4月24日 下午6:28:00 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return Shop
	 */
	Shop getShopInfo(PageData pd) throws Exception;
	
}