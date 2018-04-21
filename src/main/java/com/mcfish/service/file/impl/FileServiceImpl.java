package com.mcfish.service.file.impl;

import java.util.List;

import javax.annotation.Resource;

import com.mcfish.dao.DaoSupport;
import com.mcfish.entity.file.File;
import com.mcfish.service.file.IFileService;

public class FileServiceImpl implements IFileService{

	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<File> getFile(int type) throws Exception {
		
			return (List<File>) dao.findForList("FileMapper.getFileList", type);
		
	}

}
