package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.PricePage;
import com.mcfish.service.common.IPricePageService;
import com.mcfish.util.PageData;

@Service("PricePageServiceImpl")
public class PricePageServiceImpl implements IPricePageService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")

	//获取所有套餐
	@Override
	public List<PricePage> getPricePage(PageData pd) throws Exception {
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		return (List<PricePage>) dao.findForList("PricePageMapper.getPricePageList", pd);
	}

	//根据ID获取套餐
	@Override
	public PricePage getPricePageById(int id) throws Exception {
		return (PricePage) dao.findForObject("PricePageMapper.getPricePageById", id);
	}
    
	//根据ID编辑套餐
	@Override
	public void updataPricePage(PageData pd) throws Exception {
		dao.update("PricePageMapper.updataPricePage", pd);
	}

	//新增套餐
	@Override
	public void addPricePage(PageData pd) throws Exception {
		dao.save("PricePageMapper.addPricePage", pd);
	}

	//根据id删除套餐
	@Override
	public void deletePricePage(int id) throws Exception {
		dao.delete("PricePageMapper.deletePricePage", id);
	}


}
