package com.mcfish.controller.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.BaseController;
import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Home;
import com.mcfish.service.common.IHomeService;
import com.mcfish.util.PageData;


/**
 * 平台首页管理控制层
 * @author WangHaibo
 * @date 2018年4月19日 上午10:05:43
 * @version 1.0
 */
@Controller
@RequestMapping(value="/shareHomeController")
public class HomeController extends BaseController{
	
	@Resource(name = "homeServiceImpl")
	private IHomeService homeServiceImpl;
	
	
	/**
	 * 跳转到平台首页
	 * @author WangHaibo
	 * @date 2018年4月19日 上午10:05:53 
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 */
	@RequestMapping(value="/HomePage.do")
	public ModelAndView toHomePage()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		
		mv.setViewName("common/home/home");
		mv.addObject("pd",pd);
		
		return mv;
	}
	
	
	/**
	 * 获取平台头部数据信息 
	 * @author WangHaibo
	 * @date 2018年4月19日 上午10:07:04 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getHomeData.do")
	public Object getHomeData() throws Exception {
		
		Home home = homeServiceImpl.getHomeData();
		
		return InterfaceResult.returnSuccess(home);
	}
	
	
	/**
	 * 本周每日用户数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:12:12 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getEverydayUser.do")
	public Object getEverydayUser() throws Exception {
		PageData pd = new PageData();
		
		List<Map<String,Object>> userEverydayCount = homeServiceImpl.getEverydayUser(pd);
	
		return InterfaceResult.returnSuccess(userEverydayCount);
	}
	
	
	/**
	 * 本周每日订单数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:17:36 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getEverydayOrder.do")
	public Object getEverydayOrder() throws Exception {
		PageData pd = new PageData();
		
		List<Map<String,Object>> orderEverydayCount = homeServiceImpl.getEverydayOrder(pd);
	
		return InterfaceResult.returnSuccess(orderEverydayCount);
	}
	
	
	/**
	 * 本周每日投放设备数量
	 * @author WangHaibo
	 * @date 2018年4月19日 上午11:27:56 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getEverydayEquipment.do")
	public Object getEverydayEquipment() throws Exception{
		PageData pd = new PageData();
		
		List<Map<String, Object>> equipmentEveryDayCount = homeServiceImpl.getEverydayEquipment(pd);
		
		return InterfaceResult.returnSuccess(equipmentEveryDayCount);
	}
}


