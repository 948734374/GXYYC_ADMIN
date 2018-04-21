package com.mcfish.service.common;

import java.util.List;
import java.util.Map;

import com.mcfish.entity.common.Home;
import com.mcfish.util.PageData;


/**
 * 平台首页IService
 * @author WangHaibo
 * @date 2018年4月19日 上午10:08:10
 * @version 1.0
 */
public interface IHomeService {
	

	/**
	 * 获取平台头部数据信息 
	 * @author WangHaibo
	 * @date 2018年4月19日 上午10:08:39 
	 * @return
	 * @throws Exception
	 * @return Home
	 */
	Home getHomeData() throws Exception;
	
	
	/**
	 * 本周每日用户数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:12:33 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Map<String,Object>>
	 */
	List<Map<String, Object>> getEverydayUser(PageData pd) throws Exception;
	

	/**
	 * 本周每日订单数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:17:53 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Map<String,Object>>
	 */
	List<Map<String, Object>> getEverydayOrder(PageData pd) throws Exception;


	/**
	 * 本周每日投放设备数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:28:31 
	 * @param pd
	 * @return
	 * @return List<Map<String,Object>>
	 */
	List<Map<String, Object>> getEverydayEquipment(PageData pd) throws Exception;
	
}
