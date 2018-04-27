package com.mcfish.controller.common;

import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.IRepertoryService;
import com.mcfish.util.PageData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * 车辆库存
 * 
 * @author ZengWeihan
 * @date 2018年4月24日 上午10:00:23
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/shareRepertoryController")
public class RepertoryController extends BasicController {

	@Resource(name = "repertoryServiceImpl")
	private IRepertoryService repertoryServiceImpl;

	
	/**
	 * 功能描述: 跳转到仓库管理页面
	 * 
	 * @author ZengWeihan
	 * @date 2018年4月24 上午10:05:57
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/RepertoryPage.do")
	public ModelAndView toRepertoryPage() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();

		mv.setViewName("common/repertory/repertory");
		mv.addObject("pd", pd);

		return mv;
	}

	
	/**
	 *
	 * 功能描述: 获取车辆库存列表
	 * 
	 * @auther: ZengWeiHan
	 * @date:2018年4月25日09:33:56
	 * @param:
	 * @return:
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getRepertoryList.do")
	public Object getRepertoryList() throws Exception {
		PageData pd = this.getPageData();

		List<Cars> carsList = repertoryServiceImpl.getRepertoryList(pd);
		Long total = carsList.size() == 0 ? 0l : carsList.get(0).getTotal();

		return InterfaceResult.returnTableSuccess(carsList, total, pd.get("draw"));
	}

	
	/**
	 * 添加库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午2:57:05 
	 * @param cars
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/addRepertory.do")
	public Object addRepertory(Cars cars) throws Exception {
		
		repertoryServiceImpl.addRepertory(cars);
		
		return InterfaceResult.returnSuccess(null);
	}

	
	/**
	 * 编辑库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午3:57:05 
	 * @param cars
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/editRepertory.do")
	public Object editRepertory(Cars cars) throws Exception {
		
		repertoryServiceImpl.updateRepertory(cars);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	/**
	 *
	 * 功能描述: 删除车辆库存信息by id
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月25日13:37:16
	 * @param:
	 * @return:
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteRepertory.do")
	public Object deleteRepertory(HttpServletRequest request, @RequestParam(required = true) int carId)
			throws Exception {

		repertoryServiceImpl.deleteRepertoryById(carId);

		return InterfaceResult.returnSuccess(null);
	}


	/**
	 * 通过id获取库存车辆
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午3:40:31 
	 * @param request
	 * @param devId
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getRepertoryById.do")
	public Object getRepertoryById (HttpServletRequest request, 
	@RequestParam(required = true) int devId) throws Exception {
		return InterfaceResult.returnSuccess(repertoryServiceImpl.getRepertoryById(devId));
	}
	
	
	/**
	 *
	 * 功能描述: 获取车辆报废列表
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月24日10:31:32
	 * @param:
	 * @return:
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getScrapRepertoryList.do")
	public Object getScrapRepertoryList() throws Exception {
		PageData pd = this.getPageData();

		List<Cars> carsList = repertoryServiceImpl.getRepertoryList(pd);
		Long total = carsList.size() == 0 ? 0l : carsList.get(0).getTotal();

		return InterfaceResult.returnTableSuccess(carsList, total, pd.get("draw"));

	}

	
	/**
	 *
	 * 功能描述: 导出报废车辆信息
	 * 
	 * @auther: ZengWeiHan
	 * @date: 2018年4月25日10:05:25
	 * @param:
	 * @return:
	 */
	@ResponseBody
	@RequestMapping("exportScrapRepertoryInfo.do")
	public Object exportScrapRepertoryInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageData pd = new PageData(request);

		String fileName = "报废库存信息表.xls";
		OutputStream output = response.getOutputStream();

		response.reset();
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		response.setContentType("application/x-download");

		HSSFWorkbook swb = repertoryServiceImpl.getScrapRepertoryExport(pd);
		swb.write(output);

		return InterfaceResult.returnSuccess(null);
	}

	
	/**
	 * 获取所有商家
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午5:27:43 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getAllShops.do")
	public Object getAllShops() throws Exception {
		PageData pd = this.getPageData();
		
		List<Shop> shopList = repertoryServiceImpl.getAllShops(pd);
		Long total = shopList.size() == 0 ? 0l : shopList.get(0).getTotalSize();
		
		return InterfaceResult.returnTableSuccess(shopList, total, pd.get("draw"));
	}
	
	
	/**
	 * 获取所有价格策略
	 * @author ZengWeihan
	 * @date 2018年4月25日 下午5:55:30 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getAllDevPrice.do")
	public Object getAllDevPrice() throws Exception {
		return InterfaceResult.returnSuccess(repertoryServiceImpl.getAllDevPrice());
	}
	
	
	/**
	 * 修改车辆库存状态（投放）
	 * @author ZengWeihan
	 * @date 2018年4月26日 上午9:29:00 
	 * @param request
	 * @param devId
	 * @param shopId
	 * @param priceId
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/updateImplementDev.do")
	public Object updateImplementDev(HttpServletRequest request, 
			@RequestParam(required = true) int devId,
			@RequestParam(required = true) int shopId,
			@RequestParam(required = true) int priceId
			) throws Exception{
		
		Cars cars = new Cars();
		cars = repertoryServiceImpl.getRepertoryById(devId);
		cars.setPrice_id(priceId);
		cars.setShop_id(shopId);
		cars.setStatus(1);
		
		repertoryServiceImpl.updateRepertory(cars);
		
		return InterfaceResult.returnSuccess(null);
	}
}
