package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Agent;
import com.mcfish.service.common.IAgentService;
import com.mcfish.util.PageData;

/**
 * 代理管理serviceImpl
 * 
 * @author ZengWeihan
 * @date 2018年4月27日16:04:23
 * @version 1.0
 */
@Service("agentServiceImpl")
public class AgentServiceImpl implements IAgentService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;


	// 得到代理商列表
	@SuppressWarnings("unchecked")
	public List<Agent> getAgentList(PageData pd) throws Exception {

		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

		return (List<Agent>) dao.findForList("agentMapper.getAgentList", pd);
	}


	//添加代理商
	public void addAgent(Agent agent) throws Exception {
		agent.setHead("");
		agent.setMoney(0);
		agent.setTotal(0);
		agent.setReward(0);
		dao.save("agentMapper.addAgent", agent);
		
	}



}
