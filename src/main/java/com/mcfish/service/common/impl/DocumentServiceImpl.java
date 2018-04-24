package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Document;
import com.mcfish.service.common.IDocumentService;
import com.mcfish.util.PageData;

/**
 * @author ZhangYichi
 * @date 2018年4月23日 下午3:00:22 
 * @version 1.0
 */

@Service("documentServiceImpl")
public class DocumentServiceImpl implements IDocumentService{

	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@SuppressWarnings("unchecked")
	
	/**
	 * @author ZhangYichi
	 * @date 2018年4月23日 下午3:8:22 
	 * @version 1.0
	 */
	public List<Document> getDocument(PageData pd) throws Exception {
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		pd.put("keyword", pd.get("search[value]").toString());

	    return (List<Document>) dao.findForList("DocumentMapper.getDocumentList", pd);
		
	}

	/**
	 * @author ZhangYichi
	 * @date 2018年4月23日 下午3:8:22 
	 * @version 1.0
	 * @return 
	 * @return 
	 */	
	public void addDocument(PageData pd) throws Exception {
		 dao.save("DocumentMapper.addDocument", pd);
	}

	/**
	 * @author ZhangYichi
	 * @date 2018年4月24日 下午5:14:22 
	 * @version 1.0
	 * @return 
	 * @return 
	 */	
	public Document getDocumentById(int id) throws Exception {
		return (Document)dao.findForObject("DocumentMapper.getDocById", id);
	}

	/**
	 * @author ZhangYichi
	 * @date 2018年4月24日 下午6:18:50
	 * @version 1.0
	 * @return 
	 * @return 
	 */	
	public void updateSystemAbout(PageData pd) throws Exception {
         dao.update("DocumentMapper.upDocById", pd);		
	}

	

}
