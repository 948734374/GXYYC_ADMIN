package com.mcfish.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.common.Admin;
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
	
    //获取所有文件
	@Override
	public List<Document> getDocument(PageData pd) throws Exception {
		pd.put("start", Integer.parseInt(pd.get("start").toString()));
		pd.put("length", Integer.parseInt(pd.get("length").toString()));
		
	    return (List<Document>) dao.findForList("DocumentMapper.getDocumentList", pd);
	}

   //新增文件
	@Override
	public void addDocument(PageData pd) throws Exception {
		 dao.save("DocumentMapper.addDocument", pd);
	}

	//根据id获取文件
	@Override
	public Document getDocumentById(int id) throws Exception {
		return (Document)dao.findForObject("DocumentMapper.getDocById", id);
	}

	//根据id更改文件信息
	@Override
	public void updateDocById(PageData pd) throws Exception {
         dao.update("DocumentMapper.updataDocById", pd);		
	}
    //根据account获取当前账户信息
	@Override
	public Admin getAdmin(String account) throws Exception {
		return (Admin)dao.findForObject("DocumentMapper.getAdmin",account);
	}

	

}
