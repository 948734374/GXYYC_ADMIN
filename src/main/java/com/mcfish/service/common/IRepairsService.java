package com.mcfish.service.common;


import com.mcfish.util.PageData;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.Repairs;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 报修申请service
 * @author ZengWeihan
 * @date 2018年4月26日 上午10:14:38 
 * @version 1.0
 */
public interface IRepairsService {

	/**
	 * 获取报修申请列表
	 * @author ZengWeihan
	 * @date 2018年4月26日 上午11:40:30 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Repairs>
	 */
	List<Repairs> getRepairsList(PageData pd) throws Exception;

	/**
	 * 导出报修信息列表数据
	 * 
	 * @author ZengWeihan
	 * @date 2018年4月26日15:22:15
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return HSSFWorkbook
	 */
	HSSFWorkbook getRepairsExport(PageData pd) throws Exception;
	
	/**
	 * 通过ID获取设备信息
	 * @author ZengWeihan
	 * @date 2018年4月26日 下午3:56:51 
	 * @param id
	 * @return
	 * @throws Exception
	 * @return Cars
	 */
	Cars getDevById(int id) throws Exception;
	
	
	/**
	 * 修改设备报修信息
	 * @author ZengWeihan
	 * @date 2018年4月26日 下午5:47:29 
	 * @param repairs
	 * @throws Exception
	 * @return void
	 */
	void updateRepairs(Repairs repairs) throws Exception;
	
	
	/**
	 * 通过ID获取报修信息
	 * @author ZengWeihan
	 * @date 2018年4月26日 下午5:50:52 
	 * @param id
	 * @return
	 * @throws Exception
	 * @return Repairs
	 */
	Repairs getRepairsById(int id) throws Exception;
	

	/**
	 * 获取故障统计列表
	 * @author ZengWeihan
	 * @date 2018年4月27日11:19:09
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Repairs>
	 */
	List<Repairs> getFaultStatistics(PageData pd) throws Exception;


	/**
	 * 导出故障统计
	 * 
	 * @author ZengWeihan
	 * @date 2018年4月27日15:23:47
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return HSSFWorkbook
	 */
	HSSFWorkbook getRepairsStatisticsExport(PageData pd) throws Exception ;

}
