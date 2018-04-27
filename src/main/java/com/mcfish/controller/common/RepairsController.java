package com.mcfish.controller.common;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.Repairs;
import com.mcfish.service.common.IRepairsService;
import com.mcfish.util.PageData;

/**
 * 报修申请
 * @author ZengWeihan
 * @date 2018年4月26日 上午10:10:58 
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/shareRepairsController")
public class RepairsController extends BasicController {

	@Resource(name = "repairsServiceImpl")
	private IRepairsService repairsServiceImpl;
	

	/**
	 * 跳转报修页面
	 * @author ZengWeihan
	 * @date 2018年4月26日 上午10:11:46 
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/RepairsPage.do")
	public ModelAndView toRepairsPage() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();

		mv.setViewName("common/repairs/repairs");
		mv.addObject("pd", pd);

		return mv;
	}
	
	
	/**
	 * 获取报修申请列表
	 * @author ZengWeihan
	 * @date 2018年4月26日 上午11:35:10 
	 * @return
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getRepairsList.do")
	public Object getRepairsList()throws Exception {
		PageData pd = this.getPageData();

		List<Repairs> repairsList = repairsServiceImpl.getRepairsList(pd);
		Long total = repairsList.size() == 0 ? 0l : repairsList.get(0).getTotal();

		return InterfaceResult.returnTableSuccess(repairsList, total, pd.get("draw"));
	}
	

	/**
	 *
	 * 功能描述: 导出报修申请
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月26日15:21:23
	 * @param:
	 * @return:
	 */
	@ResponseBody
	@RequestMapping("exportRepairsInfo.do")
	public Object exportRepairsInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageData pd = new PageData(request);

		String fileName = "报修申请信息表.xls";
		OutputStream output = response.getOutputStream();

		response.reset();
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		response.setContentType("application/x-download");

		HSSFWorkbook swb = repairsServiceImpl.getRepairsExport(pd);
		swb.write(output);

		return InterfaceResult.returnSuccess(null);
	}

	
	/**
	 * 通过ID获取设备信息
	 * @author ZengWeihan
	 * @date 2018年4月26日 下午3:56:17 
	 * @param request
	 * @param id
	 * @return
	 * @return Object
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("getDevById.do")
	public Object getDevById(HttpServletRequest request,  
			@RequestParam(required = true) int id) throws Exception {
		
		if(id==0) {
			return InterfaceResult.returnSuccess(new Cars());
		}
		
		return InterfaceResult.returnSuccess(repairsServiceImpl.getDevById(id));
	}
	

	/**
	 * 更新报修申请状态
	 * @author ZengWeihan
	 * @date 2018年4月27日 上午11:06:39 
	 * @param request
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("updateRepairStatus.do")
	public Object updateRepairStatus(HttpServletRequest request, 
			@RequestParam(required = true) int id,
			@RequestParam(required = true) int status) throws Exception {
		
		Repairs repairs = repairsServiceImpl.getRepairsById(id);
		repairs.setStatus(status);
		
		repairsServiceImpl.updateRepairs(repairs);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	

	/**
	 * 获取故障统计列表
	 * @author ZengWeihan
	 * @date 2018年4月27日11:20:06
	 * @return
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getFaultStatistics.do")
	public Object getFaultStatistics()throws Exception {
		PageData pd = this.getPageData();

		List<Repairs> repairsList = repairsServiceImpl.getFaultStatistics(pd);
		Long total = repairsList.size() == 0 ? 0l : repairsList.get(0).getTotal();

		return InterfaceResult.returnTableSuccess(repairsList, total, pd.get("draw"));
	}

	
	/**
	 * 功能描述: 导出故障统计
	 * @auther: ZengWeiHan
	 * @date: 2018年4月27日15:22:34
	 * @param:
	 * @return:
	 */
	@ResponseBody
	@RequestMapping("exportRepairsStatistics.do")
	public Object exportRepairsStatistics(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageData pd = new PageData(request);

		String fileName = "故障统计信息表.xls";
		OutputStream output = response.getOutputStream();

		response.reset();
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		response.setContentType("application/x-download");

		HSSFWorkbook swb = repairsServiceImpl.getRepairsStatisticsExport(pd);
		swb.write(output);

		return InterfaceResult.returnSuccess(null);
	}

}
