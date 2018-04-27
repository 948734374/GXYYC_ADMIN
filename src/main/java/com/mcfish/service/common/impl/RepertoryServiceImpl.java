package com.mcfish.service.common.impl;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.entity.common.DevPrice;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.IRepertoryService;
import com.mcfish.util.PageData;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 车辆库存serviceImpl
 *
 * @author zengweihan
 * @version 1.0
 * @date 2018/4/24 10:04
 */
@Service("repertoryServiceImpl")
public class RepertoryServiceImpl implements IRepertoryService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	/**
	 * 功能描述:获取车辆库存信息
	 *
	 * @throws Exception
	 * @auther: ZengWeiHan
	 * @date: 2018年4月24日16:33:28
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cars> getRepertoryList(PageData pd) throws Exception {

		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

		return (List<Cars>) dao.findForList("repertoryMapper.getRepertoryList", pd);
	}

	
	/**
	 * 功能描述:获取投放信息
	 *
	 * @throws Exception
	 * @auther: ZengWeiHan
	 * @date: 2018年4月24日15:33:28
	 * @param: pd
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CarsApply> getRepertoryApplyList(PageData pd) throws Exception {

		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

		return (List<CarsApply>) dao.findForList("repertoryMapper.getRepertoryApplyList", pd);
	}

	
	// 导出投放申请列表数据
	@Override
	@SuppressWarnings("unchecked")
	public HSSFWorkbook getScrapRepertoryExport(PageData pd) throws Exception {

		pd.put("start", 0);// dataTable的分页参数
		pd.put("length", 1000000);// dataTable的分页参数

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		String[] title = { "车辆ID", "车牌号", "名称", "颜色", "终端ID", "终端密码", "车辆保险号", "硬件版本", "报废时间" };
		String[] column = { "id", "dno", "name", "color", "factory", "pwd", "secure", "version", "create_time" };
		HSSFWorkbook swb = null;

		listMap = (List<Map<String, Object>>) dao.findForList("repertoryMapper.getExportScrapRepertory", pd);

		int end = listMap.size();
		swb = new HSSFWorkbook();
		HSSFSheet sheet = swb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		Object value = null;

		for (int cellnum = 0; cellnum < title.length; cellnum++) {
			cell = row.createCell(cellnum);
			cell.setCellValue(String.valueOf(title[cellnum]));
		}

		for (int rownum = 1; rownum <= end; rownum++) {
			row = sheet.createRow(rownum);
			Map<String, Object> map = listMap.get(rownum - 1);
			for (String key : map.keySet()) {
				value = map.get(key);
				if (value == null) {
					value = "";
				}
				for (int i = 0; i < column.length; i++) {
					String kColumn = column[i];
					if (kColumn.equals(key)) {
						if ("create_time".equals(kColumn)) {
							value = value.toString().substring(0, value.toString().length() - 2);
						}
						cell = row.createCell(i);
						cell.setCellValue(value == null ? "" : value.toString());
					}
				}
			}
		}

		return swb;
	}
	

	//根据id查询车辆库存信息
	public Cars getRepertoryById(int id) throws Exception{
		return (Cars) dao.findForObject("repertoryMapper.getRepertoryById", id);
	}
	
	
	//根据id删除车辆库存信息
	public void deleteRepertoryById(int id) throws Exception {
		dao.delete("repertoryMapper.deleteRepertoryById", id);
	}
	

	//增加库存车辆
	public void addRepertory(Cars cars) throws Exception{
		cars.setCreate_time(new Date());
		cars.setOnline(0);
		cars.setId(0);
		dao.save("repertoryMapper.addRepertory", cars);
	}
	
	
	//编辑库存车辆
	public void updateRepertory(Cars cars) throws Exception{
		dao.save("repertoryMapper.updateRepertory", cars);
	}

	//获取所有商家列表数据
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShops(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<Shop>) dao.findForList("repertoryMapper.getAllShops", pd);
	}
	
	//获取所有价格策略数据
	@SuppressWarnings("unchecked")
	@Override
	public List<DevPrice> getAllDevPrice() throws Exception {
		return (List<DevPrice>) dao.findForList("repertoryMapper.getAllDevPrice", null);
	}
	

}
