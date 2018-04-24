package com.mcfish.controller.common;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.BaseController;
import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.entity.common.Coupon;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.ICarsService;
import com.mcfish.service.common.IShopService;
import com.mcfish.util.PageData;

/**
 * 车辆管理
 * @author WangHaibo
 * @date 2018年4月23日 上午11:31:23
 * @version 1.0
 */
@Controller
@RequestMapping(value="/shareCarsController")
public class CarsController extends BaseController {
	
	@Resource(name = "carsServiceImpl")
	private ICarsService carsServiceImpl;
	
	@Resource(name = "shopServiceImpl")
	private IShopService shopServiceImpl;

	/**
	 * 跳转到车辆管理页面
	 * @author WangHaibo
	 * @date 2018年4月23日 上午11:31:57 
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value="/CarsPage.do")
	public ModelAndView toCouponPage(){ 
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/cars/cars");
		mv.addObject("pd",pd);	  
		
		return mv;		
	}
	
	
	/**
	 * 获取车辆管理列表数据
	 * @author WangHaibo
	 * @date 2018年4月23日 下午2:17:43 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getAllCarsList.do")
	public Object getAllCarsList() throws Exception{
		PageData pd = this.getPageData();
		
	    List<Cars> carsList= carsServiceImpl.getAllCarsList(pd);
	    Long total = carsList.size() == 0 ? 0l: carsList.get(0).getTotal();
	    
		return InterfaceResult.returnTableSuccess(carsList, total, pd.get("draw"));
	}

	
	/**
	 * 更新车辆管理-车辆列表
	 * @author WangHaibo
	 * @date 2018年4月23日 下午6:07:51 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/updateCars.do")
	public Object updateCars() throws Exception{
		PageData pd = this.getPageData();
		
		carsServiceImpl.updateCars(pd);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 获取车辆管理-投放申请列表数据
	 * @author WangHaibo
	 * @date 2018年4月23日 下午5:00:04 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getAllCarsApplyList.do")
	public Object getAllCarsApplyList() throws Exception{
		PageData pd = this.getPageData();
		
		List<CarsApply> carsApplyList = carsServiceImpl.getAllCarsApplyList(pd);
		Long total = carsApplyList.size() == 0 ? 01 : carsApplyList.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(carsApplyList, total, pd.get("draw"));
	}
	
	
	/**
	 * 更新车辆管理-投放申请
	 * @author WangHaibo
	 * @date 2018年4月23日 下午6:07:51 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/updateCarsApply.do")
	public Object updateCarsApply() throws Exception{
		PageData pd = this.getPageData();
		
		carsServiceImpl.updateCarsApply(pd);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 导出投放申请列表数据
	 * @author WangHaibo
	 * @date 2018年4月24日 上午9:29:55 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/exportCarsInfo.do")
	public Object exportCarsInfo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PageData pd = new PageData(request);
		
		String fileName = "投放申请信息表.xls";
		OutputStream output = response.getOutputStream();
		
		response.reset();
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		response.setContentType("application/x-download");
		
		HSSFWorkbook swb = carsServiceImpl.getCarsListExport(pd);
		swb.write(output);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 获取所有商家
	 * @author WangHaibo
	 * @date 2018年4月24日 下午4:36:14 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/selectAllShops.do")
	public Object selectAllShops() throws Exception {
		PageData pd = this.getPageData();
		
		List<Shop> shopList = shopServiceImpl.selectAllShops(pd);
		Long total = shopList.size() == 0 ? 01 : shopList.get(0).getTotalSize();
		
		return InterfaceResult.returnTableSuccess(shopList, total, pd.get("draw"));
	}
	
	
}
