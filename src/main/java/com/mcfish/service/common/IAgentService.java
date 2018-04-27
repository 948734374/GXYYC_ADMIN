package com.mcfish.service.common;

import java.util.List;

import com.mcfish.entity.common.Agent;
import com.mcfish.util.PageData;

/**
 * 代理管理service
 * @author ZengWeihan
 * @date 2018年4月27日16:03:30
 * @version 1.0
 */
public interface IAgentService {


	/**
	 * 获取代理商列表
	 * @author ZengWeihan
	 * @date 2018年4月27日16:23:22
	 * @param pd
	 * @return
	 * @throws Exception
	 * @return List<Agent>
	 */
	List<Agent> getAgentList(PageData pd) throws Exception;

	
	/**
	 * 添加代理商
	 * @author ZengWeihan
	 * @date 2018年4月27日 下午6:00:24 
	 * @param agent
	 * @return void
	 */
	void addAgent(Agent agent) throws Exception;

}
