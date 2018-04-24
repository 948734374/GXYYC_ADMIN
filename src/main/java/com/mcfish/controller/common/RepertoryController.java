package com.mcfish.controller.common;

import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.service.common.IRepertoryService;
import com.mcfish.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * 车辆库存
 * @author ZengWeihan
 * @date 2018年4月24日 上午10:00:23
 * @version 1.0
 */
@Controller
@RequestMapping(value="/shareRepertoryController")
public class RepertoryController extends BasicController{

    @Resource(name = "repertoryServiceImpl")
    private IRepertoryService repertoryServiceImpl;


    /**
     * 功能描述: 跳转到仓库管理页面
     * @author ZengWeihan
     * @date 2018年4月24 上午10:05:57
     * @return ModelAndView
     * @throws Exception
     */
    @RequestMapping(value="/RepertoryPage.do")
    public ModelAndView toRepertoryPage(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();

        mv.setViewName("common/repertory/repertory");
        mv.addObject("pd",pd);

        return mv;
    }


    /**
     *
     * 功能描述: 获取车辆库存列表
     * @auther: ZengWeiHan
     * @date: 2018年4月24日10:31:32
     * @param: 
     * @return:
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getRepertoryList.do")
    public Object getRepertoryList() throws Exception {
        PageData pd = this.getPageData();

        if(pd.get("status").toString().equals("101")){
            //获取商户投放信息
            pd.put("status",4);//status为4即为商户完成投放标志
            List<CarsApply> carsApplyList = repertoryServiceImpl.getRepertoryApplyList(pd);
            Long total = carsApplyList.size() == 0 ? 01 : carsApplyList.get(0).getTotal();
            return InterfaceResult.returnTableSuccess(carsApplyList, total, pd.get("draw"));
        }else{
            List<Cars> carsList = repertoryServiceImpl.getRepertoryList(pd);
            Long total = carsList.size() == 0 ? 01 : carsList.get(0).getTotal();
            return InterfaceResult.returnTableSuccess(carsList, total, pd.get("draw"));
        }

    }

}
