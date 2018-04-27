package com.mcfish.controller.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Agent;
import com.mcfish.entity.common.Cars;
import com.mcfish.service.common.IAgentService;
import com.mcfish.util.PageData;

@Controller
@RequestMapping(value = "/shareAgentController")
public class AgentController extends BasicController {

	@Resource(name = "agentServiceImpl")
	private IAgentService agentServiceImpl;
	
	/**
	 * 功能描述: 跳转到代理管理
	 * 
	 * @author ZengWeihan
	 * @date 2018年4月27日15:47:27
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/AgentPage.do")
	public ModelAndView toAgentPage() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();

		mv.setViewName("common/agent/agent");
		mv.addObject("pd", pd);

		return mv;
	}
	
	

	/**
	 * 获取代理商列表
	 * @author ZengWeihan
	 * @date 2018年4月27日16:22:04
	 * @return
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/getAgentList.do")
	public Object getAgentList()throws Exception {
		PageData pd = this.getPageData();

		List<Agent> agentList = agentServiceImpl.getAgentList(pd);
		Long total_page = agentList.size() == 0 ? 0l : agentList.get(0).getTotal_page();

		return InterfaceResult.returnTableSuccess(agentList, total_page, pd.get("draw"));
	}
	
	
	/**
	 * 添加代理商
	 * @author ZengWeihan
	 * @date 2018年4月27日17:59:44
	 * @param cars
	 * @return
	 * @throws Exception
	 * @return Object
	 */
	@ResponseBody
	@RequestMapping("/addAgent.do")
	public Object addAgent(Agent agent) throws Exception {
		
		agentServiceImpl.addAgent(agent);
		
		return InterfaceResult.returnSuccess(null);
	}

}
