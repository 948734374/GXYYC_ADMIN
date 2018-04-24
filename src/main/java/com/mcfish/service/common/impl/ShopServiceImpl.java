package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.IShopService;
import com.mcfish.util.PageData;

/**
 * 商家管理serviceImpl
 * @author WangHaibo
 * @date 2018年4月24日 下午4:42:06
 * @version 1.0
 */
@Service("shopServiceImpl")
public class ShopServiceImpl implements IShopService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	//获取所有商家列表数据
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> selectAllShops(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<Shop>) dao.findForList("shopMapper.selectAllShops", pd);
	}


	//获取商家详情
	@Override
	public Shop getShopInfo(PageData pd) throws Exception {
		
		return (Shop) dao.findForObject("shopMapper.getShopInfo", pd);
	}

	
}
