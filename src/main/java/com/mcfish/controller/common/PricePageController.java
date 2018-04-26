package com.mcfish.controller.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.PricePage;
import com.mcfish.service.common.IPricePageService;
import com.mcfish.service.common.impl.PricePageServiceImpl;
import com.mcfish.util.PageData;
@Controller
@RequestMapping(value="/sharePriceController")

/**
 * 套餐配置
 * @author ZhangYichi
 * @date 2018年4月25日 下午5:26:17 
 * @version 1.0
 */
public class PricePageController extends BasicController{
	
	@Resource(name = "PricePageServiceImpl")
	IPricePageService pricepageservice = new PricePageServiceImpl();
	
	/**
	 * 跳转到套餐设置页面
	 * @author ZhangYichi 
	 * @date 2018年4月25日 下午6:27:14 
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "PricePage.co")
	public ModelAndView tologin() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/pricepage/pricepage");
		mv.addObject("pd", pd);
		
		return mv;
	}
	
	/**
	 * 获取套餐列表
	 * @author ZhangYichi 
	 * @date 2018年4月26日 上午9:53:20 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllPricepage.do")
	public Object getAllPricepage (HttpServletRequest request)throws Exception{
		PageData pd = new PageData(request);
		
		List<PricePage> pricepageList = pricepageservice.getPricePage(pd);
		Long pricepageTotal = pricepageList.size() == 0 ? 0l:pricepageList.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(pricepageList, pricepageTotal, pd.get("draw"));
	}

	/**
	 * 根据id获取套餐
	 * @author ZhangYichi 
	 * @date 2018年4月26日 早上10:27:14 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getPricePage.do")
	public Object getPricePage (@RequestParam(required = true) int id)throws Exception{
		PricePage pricepage = pricepageservice.getPricePageById(id);
		return InterfaceResult.returnSuccess(pricepage);
	}
	
	/**
	 * 根据id编辑套餐
	 * @author ZhangYichi 
	 * @date 2018年4月26日 早上10:51:43 
	 * @return
	 * @throws Exception
	 */
     @ResponseBody
     @RequestMapping(value ="updatePricePage.do")
     public Object updatePricePage()throws Exception{
    	 PageData pd = this.getPageData();
    	 pricepageservice.updataPricePage(pd);
    	 return InterfaceResult.returnSuccess(null);
     }
     
     /**
 	 * 新建套餐
 	 * @author ZhangYichi 
 	 * @date 2018年4月26日 下午1:55:23 
 	 * @return
 	 * @throws Exception
 	 */
     @ResponseBody
     @RequestMapping(value ="addPricePage.do")
     public Object addPricePage()throws Exception{
    	 PageData pd = this.getPageData();
    	 pricepageservice.addPricePage(pd);
    	 return InterfaceResult.returnSuccess(null);
     }
     
     /**
  	 * 删除套餐
  	 * @author ZhangYichi 
  	 * @date 2018年4月26日 下午2:49:34 
  	 * @return
  	 * @throws Exception
  	 */
     @ResponseBody
     @RequestMapping(value ="deletePricePage.do")
     public Object deletePricePage(@RequestParam(required = true) int id)throws Exception{
    	 pricepageservice.deletePricePage(id);
    	 return InterfaceResult.returnSuccess(null);
     }
}
