package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Price;
import com.mcfish.service.common.IPriceService;
import com.mcfish.util.PageData;

/**
 * 套餐设置service
 * @author ZhangYichi
 * @date 2018年4月23日 下午3:00:22 
 * @version 1.0
 */
@Service("PriceServiceImpl")
public class PriceServiceImpl implements IPriceService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;


	//获取所有套餐
	@SuppressWarnings("unchecked")
	@Override
	public List<Price> getPricePage(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		
		return (List<Price>) dao.findForList("PriceMapper.getPricePageList", pd);
	}

	
	//根据ID获取套餐
	@Override
	public Price getPricePageById(int id) throws Exception {
		
		return (Price) dao.findForObject("PriceMapper.getPricePageById", id);
	}
    
	
	//根据ID编辑套餐
	@Override
	public void updataPricePage(PageData pd) throws Exception {
		
		dao.update("PriceMapper.updataPricePage", pd);
	}

	
	//新增套餐
	@Override
	public void addPricePage(PageData pd) throws Exception {
        	
		dao.save("PriceMapper.addPricePage", pd);
	}

	
	//根据id删除套餐
	@Override
	public void deletePricePage(int id) throws Exception {
		
		dao.delete("PriceMapper.deletePricePage", id);
	}


}
