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
import com.mcfish.entity.common.Repairs;
import com.mcfish.service.common.IRepairsService;
import com.mcfish.util.PageData;

/**
 * 报修申请serviceImpl
 * 
 * @author ZengWeihan
 * @date 2018年4月26日 上午10:15:34
 * @version 1.0
 */
@Service("repairsServiceImpl")
public class RepairsServiceImpl implements IRepairsService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	// 得到报修信息列表
	@SuppressWarnings("unchecked")
	public List<Repairs> getRepairsList(PageData pd) throws Exception {

		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

		return (List<Repairs>) dao.findForList("repairsMapper.getRepairsList", pd);
	}

	// 导出投放申请列表数据
	@Override
	@SuppressWarnings("unchecked")
	public HSSFWorkbook getRepairsExport(PageData pd) throws Exception {

		pd.put("start", 0);// dataTable的分页参数
		pd.put("length", 1000000);// dataTable的分页参数

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		String[] title = { "车牌号", "车型", "商家名称", "故障原因", "图片", "申请人", "状态", "维修人", "审核人" };
		String[] column = { "dno", "dev_name", "shop_name", "content", "image", "creator", "status",
				"admin_name_repair", "admin_name_leader" };
		HSSFWorkbook swb = null;

		listMap = (List<Map<String, Object>>) dao.findForList("repairsMapper.getExportRepairs", pd);

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
						if ("status".equals(kColumn)) {
							switch (Integer.parseInt(value.toString())) {
								case 0:
									value = "待审批";
									break;
								case 1:
									value = "已挂起";
									break;
								case 2:
									value = "待处理";
									break;
								case 3:
									value = "已修复";
									break;
								case 4:
									value = "已报废";
									break;
								case 5:
									value = "审核未通过";
									break;
							}
						}
						cell = row.createCell(i);
						cell.setCellValue(value == null ? "" : value.toString());
					}
				}
			}
		}

		return swb;
	}

	
	//通过ID获取设备信息
	public Cars getDevById(int id) throws Exception {
		return (Cars) dao.findForObject("repairsMapper.getDevById", id);
	}

	
	//修改报修信息
	public void updateRepairs(Repairs repairs) throws Exception {
		dao.update("repairsMapper.updateRepairs", repairs);
	}

	
	//通过ID获取报修信息
	public Repairs getRepairsById(int id) throws Exception {
		return (Repairs) dao.findForObject("repairsMapper.getRepairsById", id);
	}

	// 得到故障统计列表
	@SuppressWarnings("unchecked")
	public List<Repairs> getFaultStatistics(PageData pd) throws Exception {

		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

		return (List<Repairs>) dao.findForList("repairsMapper.getFaultStatistics", pd);
	}

	
	//导出故障统计
	@SuppressWarnings("unchecked")
	public HSSFWorkbook getRepairsStatisticsExport(PageData pd) throws Exception {

		pd.put("start", 0);// dataTable的分页参数
		pd.put("length", 1000000);// dataTable的分页参数

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		String[] title = { "省份", "市区", "地区", "开始时间", "截止时间", "故障设备数量"};
		String[] column = { "province", "city", "zone", "min_time", "max_time", "repairs_total" };
		HSSFWorkbook swb = null;

		listMap = (List<Map<String, Object>>) dao.findForList("repairsMapper.getExportRepairsStatistics", pd);

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
						if ("min_time".equals(kColumn)) {
							value = value.toString().substring(0, value.toString().length() - 2);
						}
						if ("max_time".equals(kColumn)) {
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

}
