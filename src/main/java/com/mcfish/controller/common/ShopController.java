package com.mcfish.controller.common;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mcfish.controller.base.BaseController;
import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Coupon;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.ICouponsService;
import com.mcfish.service.common.IShopService;
import com.mcfish.util.PageData;

/**
 * 商家管理
 * @author WangHaibo
 * @date 2018年4月24日 下午6:24:20
 * @version 1.0
 */
@Controller
@RequestMapping(value="/shareShopController")
public class ShopController extends BaseController {
	
	@Resource(name = "shopServiceImpl")
	private IShopService shopServiceImpl;
	

	/**
	 * 跳转到优惠券页面
	 * @author ZhouXiaobing 
	 * @date 2018年3月31日 上午10:43:31 
	 * @return
	 */
	@RequestMapping(value="/CouponPage.do")
	public ModelAndView toCouponPage(){ 
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/coupon/coupon");
		mv.addObject("pd",pd);	  
		
		return mv;		
	}
	
	/*
	
	*//**
	 * 获取所有的优惠券
	 * @author ZhouXiaobing 
	 * @date 2018年3月31日 上午10:49:15 
	 * @return
	 * @throws Exception
	 *//*
	@ResponseBody
	@RequestMapping(value="/getAllCoupon.do")
	public Object getAllCoupon() throws Exception{
		PageData pd = this.getPageData();
		
	    List<Coupon> couponns= couponServiceImpl.getAllCoupons(pd);
	    Long total = couponns.size() == 0 ? 0l: couponns.get(0).getTotal();
	    
		return InterfaceResult.returnTableSuccess(couponns, total, pd.get("draw"));
	}


	*//**
	 * 删除优惠券
	 * @author ZhouXiaobing 
	 * @date 2018年3月31日 上午10:51:52 
	 * @return
	 * @throws Exception 
	 *//*
	@ResponseBody
	@RequestMapping(value="/deletCoupon.do")
	public Object deletCoupon() throws Exception {
		PageData pd = this.getPageData();
		
		couponServiceImpl.deleteCoupon(pd);
		
		return InterfaceResult.returnSuccess(null);
	}*/
	
	
	/**
	 * 获取商家详情
	 * @author WangHaibo
	 * @date 2018年4月24日 下午6:25:37 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getShopInfo.do")
	public Object getShopInfo() throws Exception{
		PageData pd = this.getPageData();
		
		Shop shop = shopServiceImpl.getShopInfo(pd);
		
		return InterfaceResult.returnSuccess(shop);
	}
	
	
	/**
	 * 更新优惠券
	 * @author ZhouXiaobing 
	 * @date 2018年3月31日 上午10:55:31 
	 * @return
	 * @throws Exception 
	 *//*
	@ResponseBody
	@RequestMapping(value="/updateCoupon.do")
	public Object updateCoupon() throws Exception{
		PageData pd=this.getPageData();
		
		couponServiceImpl.updateCoupon(pd);
		
		return InterfaceResult.returnSuccess(null);
	}*/
	
}
