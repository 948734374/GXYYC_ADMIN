package com.mcfish.controller.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.BaseController;
import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.User;
import com.mcfish.entity.common.UserMoney;
import com.mcfish.entity.common.UserRecord;
import com.mcfish.service.common.IUserService;
import com.mcfish.util.PageData;

/**
 * 用户管理控制层
 * @author WangHaibo
 * @date 2018年4月19日 下午2:13:58
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/shareUserController")
public class UserController extends BaseController {

	@Resource(name = "userServiceImpl")
	private IUserService userServiceImpl;

	
	/**
	 * 跳转到用户管理页面
	 * @author WangHaibo
	 * @date 2018年4月19日 下午2:14:09 
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/UserPage.do")
	public ModelAndView toUserPage() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/user/user");
		mv.addObject("pd", pd);
		
		return mv;
	}

	
	/**
	 * 跳转到用户详情页面
	 * @author WangHaibo
	 * @date 2018年4月19日 下午2:14:49 
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/toUserDetail.do")
	public ModelAndView toUserDetail() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/user/detail");
		mv.addObject("pd", pd);
		
		return mv;
	}
	

	/**
	 * 根据条件获取所有用户信息列表
	 * @author WangHaibo
	 * @date 2018年4月19日 下午2:17:09 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getAllUserList.do")
	public Object getAllUserList() throws Exception {
		PageData pd = this.getPageData();
		
		List<User> userList = userServiceImpl.getAllUserList(pd);
		Long userTotal = userList.size() == 0 ? 0l:userList.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(userList, userTotal, pd.get("draw"));
	}
	
	
	/**
	 * 更新用户状态
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:19:22 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUserStatus.do", method = RequestMethod.POST)
	public Object updateUserStatus() throws Exception {
		PageData pd = this.getPageData();
		
		userServiceImpl.updateUserStatus(pd);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 根据用户id删除
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:19:31 
	 * @param request
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/deleteUser.do")
	public Object deleteUser(HttpServletRequest request, 
								@RequestParam(required = true) int userId) throws Exception {
		
		userServiceImpl.deleteUser(userId);
		
		return InterfaceResult.returnSuccess(null);
	}
	

	/**
	 * 根据用户ID查找用户详细资料
	 * @author WangHaibo
	 * @date 2018年4月19日 下午5:19:42 
	 * @param request
	 * @param uid
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserById.do", method = RequestMethod.GET)
	public Object getUserById(HttpServletRequest request, 
								@RequestParam(required = true) int uid) throws Exception {
		
		User user = userServiceImpl.getUserById(uid);
		
		return InterfaceResult.returnSuccess(user);
	}


	/**
	 * 更新用户基本信息
	 * @author WangHaibo
	 * @date 2018年4月20日 上午11:38:21 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUserInfo.do", method = RequestMethod.POST)
	public Object updateUserInfo() throws Exception {
		PageData pd = this.getPageData();

		userServiceImpl.updateUser(pd);

		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 获取用户订单列表数据
	 * @author WangHaibo
	 * @date 2018年4月20日 下午2:33:10 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getUserOrderList.do")
	public Object getUserOrderList() throws Exception{
		PageData pd = this.getPageData();
		
		List<UserRecord> userOrderList = userServiceImpl.getUserOrderList(pd);
		Long total = userOrderList.size() == 0 ? 01 : userOrderList.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(userOrderList, total, pd.get("draw"));
	}
	
	
	/**
	 * 修改订单支付状态
	 * @author WangHaibo
	 * @date 2018年4月20日 下午2:36:51 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/updateUserOrderPayStatus.do")
	public Object updateUserOrderPayStatus() throws Exception{
		PageData pd = this.getPageData();
		
		userServiceImpl.updateUserOrderPayStatus(pd);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 根据id查询用户的钱包
	 * @author WangHaibo
	 * @date 2018年4月20日 下午4:10:52 
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping(value="/getUserMoneyList.do")
	public Object getUserMoneyList() throws Exception{
		PageData pd = this.getPageData();
		
		List<UserMoney> userMoneyList = userServiceImpl.getUserMoneyList(pd);
		Long total = userMoneyList.size() == 0 ? 01 : userMoneyList.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(userMoneyList, total, pd.get("draw"));
	}
	
}
