package com.mcfish.service.common;

import java.util.List;

import com.mcfish.entity.common.Document;
import com.mcfish.util.PageData;

public interface IDocumentService {

	/**
	 * 获取所有文件
	 * @author ZhangYichi 
	 * @date 2018年4月23日 下午2:15:00 
	 * @param pageData
	 * @return
	 * @throws Exception
	 */
	public List<Document> getDocument(PageData pd) throws Exception;
	
	/**
	 * 新增文件
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午3:01:00 
	 * @param pageData
	 * @return
	 * @throws Exception
	 */
	public void addDocument(PageData pd)throws Exception;
	
	/**
	 * 根据id获取文件
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午5:12:00 
	 * @param pageData
	 * @return
	 * @throws Exception
	 */
	public Document getDocumentById(int id) throws Exception;
	
	/**
	 * 根据id更改文件信息
	 * @author ZhouXiaobing 
	 * @date 2018年4月24日 上午6:17:37 
	 * @param pd
	 * @throws Exception
	 */
	void updateSystemAbout(PageData pd) throws Exception;
}
