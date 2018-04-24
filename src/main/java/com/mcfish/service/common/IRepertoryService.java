package com.mcfish.service.common;

import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.util.PageData;

import java.util.List;

/**
 * 车辆库存IService
 * @author zengweihan
 * @version 1.0
 * @date 2018/4/24 10:02
 */
public interface IRepertoryService {


    /**
     *
     * 功能描述:获取车辆库存信息
     * @auther: ZengWeiHan
     * @date:  2018年4月24日16:33:28
     * @param: pd
     * @throws Exception
     */
    List<Cars> getRepertoryList(PageData pd) throws Exception;


    /**
     *
     * 功能描述:获取车辆申请信息
     * @auther: ZengWeiHan
     * @date:  2018年4月24日16:33:28
     * @param: pd
     * @throws Exception
     */
    List<CarsApply> getRepertoryApplyList(PageData pd) throws Exception;


}
