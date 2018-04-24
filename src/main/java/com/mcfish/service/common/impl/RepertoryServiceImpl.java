package com.mcfish.service.common.impl;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.service.common.IRepertoryService;
import com.mcfish.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 车辆库存serviceImpl
 * @author zengweihan
 * @version 1.0
 * @date 2018/4/24 10:04
 */
@Service("repertoryServiceImpl")
public class RepertoryServiceImpl implements IRepertoryService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;


    // 获取车辆库存
    @SuppressWarnings("unchecked")
    @Override
    public List<Cars> getRepertoryList(PageData pd) throws Exception {

        pd.put("start", Integer.parseInt(pd.get("start").toString()));
        pd.put("length", Integer.parseInt(pd.get("length").toString()));

        return (List<Cars>) dao.findForList("repertoryMapper.getRepertoryList", pd);
    }


    // 获取投放信息
    @SuppressWarnings("unchecked")
    @Override
    public List<CarsApply> getRepertoryApplyList(PageData pd) throws Exception {

        pd.put("start", Integer.parseInt(pd.get("start").toString()));
        pd.put("length", Integer.parseInt(pd.get("length").toString()));

        List<CarsApply> carsApplies = (List<CarsApply>) dao.findForList("repertoryMapper.getRepertoryApplyList", pd);
        //拼接详细地址信息
        for(int i = 0;i<carsApplies.size();i++){
            CarsApply ca =  carsApplies.get(0);
            ca.setAddress(""+ca.getProv()+ca.getCity()+ca.getZone()+ca.getAddress());
            carsApplies.set(i,ca);
        }

        return carsApplies;
    }

}
