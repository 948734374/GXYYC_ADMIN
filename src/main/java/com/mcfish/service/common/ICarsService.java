package com.mcfish.service.common;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.entity.common.Shop;
import com.mcfish.util.PageData;


/**
 * 车辆管理IService
 * @author WangHaibo
 * @date 2018年4月23日 下午2:20:37
 * @version 1.0
 */
public interface ICarsService {

	
	/**
	 * 获取所有的车辆
	 * @author ZhouXiaobing 
	 * @date 2018年3月31日 上午10:58:39 
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	List<Cars> getAllCarsList(PageData pd) throws Exception;

	
	/**
	 * 获取车辆管理-投放申请列表数据
	 * @author WangHaibo
	 * @date 2018年4月23日 下午5:00:56 
	 * @param pd
	 * @return
	 * @return List<CarsApply>
	 */
	List<CarsApply> getAllCarsApplyList(PageData pd) throws Exception;


	/**
	 * 更新车辆管理-车辆列表
	 * @author WangHaibo
	 * @date 2018年4月23日 下午6:08:51 
	 * @param pd
	 * @return void
	 */
	void updateCars(PageData pd) throws Exception;
	
	
	/**
	 * 更新车辆管理-投放申请
	 * @author WangHaibo
	 * @date 2018年4月23日 下午6:08:51 
	 * @param pd
	 * @return void
	 */
	void updateCarsApply(PageData pd) throws Exception;


	/**
	 * 导出投放申请列表数据
	 * @author WangHaibo
	 * @date 2018年4月24日 上午9:36:15 
	 * @param pd
	 * @return
	 * @return HSSFWorkbook
	 */
	HSSFWorkbook getCarsListExport(PageData pd) throws Exception;
	
}