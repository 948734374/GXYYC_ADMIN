package com.mcfish.service.common.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Cars;
import com.mcfish.entity.common.CarsApply;
import com.mcfish.entity.common.Shop;
import com.mcfish.service.common.ICarsService;
import com.mcfish.util.PageData;


/**
 * 车辆管理serviceImpl
 * @author WangHaibo
 * @date 2018年4月23日 下午2:25:55
 * @version 1.0
 */
@Service("carsServiceImpl")
public class CarsServiceImpl implements ICarsService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	// 获取所有的车辆
	@SuppressWarnings("unchecked")
	@Override
	public List<Cars> getAllCarsList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());
		
		return (List<Cars>) dao.findForList("carsMapper.getAllCarsList", pd);
	}


	//获取车辆管理-投放申请列表数据
	@SuppressWarnings("unchecked")
	@Override
	public List<CarsApply> getAllCarsApplyList(PageData pd) throws Exception {
		
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		
		return (List<CarsApply>) dao.findForList("carsMapper.getAllCarsApplyList", pd);
	}

	
	//更新车辆管理-车辆列表
	@Override
	public void updateCars(PageData pd) throws Exception {
		
		int type = Integer.parseInt(pd.get("type").toString());
		//判断操作类型
		if(type == 1) {
			//撤机
			dao.update("carsMapper.updateCars", pd);
		}
		
	}
	
	
	// 更新车辆管理-投放申请
	@Override
	public void updateCarsApply(PageData pd) throws Exception {

		dao.update("carsMapper.updateCarsApply", pd);
	}
	

	//导出投放申请列表数据
	@SuppressWarnings("unchecked")
	@Override
	public HSSFWorkbook getCarsListExport(PageData pd) throws Exception {
		
		pd.put("start", 0);// dataTable的分页参数
		pd.put("length", 1000000);// dataTable的分页参数
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		String[] title = { "申请人", "商家/代理", "电话", "地点", "台数","备注", "状态"};
		String[] column = { "name", "type", "phone", "address", "count", "comment","status"};
		HSSFWorkbook swb = null;
		
		listMap = (List<Map<String, Object>>) dao.findForList("carsMapper.getCarsListExport", pd);

		
		//获取总数
		int carsCount = (int) dao.findForObject("carsMapper.getCarsCount",null);
		listMap.get(0).put("carsCount", carsCount);
		
		
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
						cell = row.createCell(i);
						
						if ("status".equals(kColumn)) {
							if ("0".equals(value.toString())) {
								value = "未审核";
							} else if("1".equals(value.toString())){
								value = "已拒绝";
							} else if("2".equals(value.toString())){
								value = "已采纳";
							} else if("3".equals(value.toString())){
								value = "铺设中";
							} else if("4".equals(value.toString())){
								value = "已完成";
							}
						}
						
						if("type".equals(kColumn)) {
							if ("0".equals(value.toString())) {
								value = "代理商";
							} else if("1".equals(value.toString())){
								value = "商家";
							}
						}
						
						cell.setCellValue(value == null ? "" : value.toString());
					}
				}
			}
		}

		return swb;
	}


}
