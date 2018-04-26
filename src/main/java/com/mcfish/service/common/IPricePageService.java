package com.mcfish.service.common;

import java.util.List;

import com.mcfish.entity.common.PricePage;
import com.mcfish.util.PageData;

public interface IPricePageService {

	/**
	 * 获取所有套餐
	 * @author ZhangYichi 
	 * @date 2018年4月25日 下午3:18:43 
	 * @param pageData
	 * @return
	 * @throws Exception
	 */
	public List<PricePage> getPricePage(PageData pd) throws Exception;
		
	/**
	 * 根据ID获取套餐
	 * @author ZhangYichi
	 * @date 2018年4月26日 早上 9:57:30
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PricePage getPricePageById(int id)throws Exception;
	
	/**
	 * 根据ID编辑套餐
	 * @author ZhangYichi
	 * @date 2018年4月26日 早上 10:56:22
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void updataPricePage(PageData pd)throws Exception;
	
	/**
	 * 新增套餐
	 * @author ZhangYichi
	 * @date 2018年4月26日 下午 2:02:31
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void addPricePage(PageData pd)throws Exception;
	
	/**
	 * 删除套餐
	 * @author ZhangYichi
	 * @date 2018年4月26日 下午 2:54:49
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deletePricePage(int id)throws Exception;
}
