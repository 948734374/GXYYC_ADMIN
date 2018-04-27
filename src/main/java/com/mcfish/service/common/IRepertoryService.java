package com.mcfish.service.common;

import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.entity.common.DevPrice;
import com.mcfish.entity.common.Shop;
import com.mcfish.util.PageData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * 车辆库存IService
 * 
 * @author zengweihan
 * @version 1.0
 * @date 2018/4/24 10:02
 */
public interface IRepertoryService {

	/**
	 *
	 * 功能描述:获取车辆库存信息
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月24日16:33:28
	 * @throws Exception
	 */
	List<Cars> getRepertoryList(PageData pd) throws Exception;

	
	/**
	 *
	 * 功能描述:获取车辆申请信息
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月24日16:33:28
	 * @param: pd
	 * @throws Exception
	 */
	List<CarsApply> getRepertoryApplyList(PageData pd) throws Exception;

	
	/**
	 * 导出报废库存列表数据
	 * 
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午12:14:57
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return HSSFWorkbook
	 */
	HSSFWorkbook getScrapRepertoryExport(PageData pd) throws Exception;

	
	/**
	 * 删除库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午1:41:17
	 * @param id
	 * @throws Exception
	 * @return void
	 */
	void deleteRepertoryById(int id) throws Exception;


	/**
	 * 增加库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午2:52:25 
	 * @param cars
	 * @throws Exception
	 * @return void
	 */
	void addRepertory(Cars cars) throws Exception;

	
	/**
	 * 编辑库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午3:52:25 
	 * @param cars
	 * @throws Exception
	 * @return void
	 */
	void updateRepertory(Cars cars) throws Exception;
	
	
	/**
	 * 通过ID获取库存信息
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午3:35:23 
	 * @param id
	 * @return
	 * @throws Exception
	 * @return Cars
	 */
	Cars getRepertoryById(int id) throws Exception;

	/**
	 * 获取所有商家
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午5:30:04 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Shop>
	 */
	List<Shop> getAllShops(PageData pd) throws Exception;
	
	/**
	 * 获取所有价格策略
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午6:13:08 
	 * @return
	 * @throws Exception
	 * @return List<DevPrice>
	 */
	List<DevPrice> getAllDevPrice() throws Exception;
	
	
}
