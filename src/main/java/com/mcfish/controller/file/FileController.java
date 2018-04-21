package com.mcfish.controller.file;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcfish.entity.file.File;
import com.mcfish.service.file.impl.FileServiceImpl;;


@Controller
@RequestMapping(value="/filesController")
public class FileController {

	@Resource(name="FileServiceImpl")
	private FileServiceImpl fileServiceImpl;
	
	public List<File> getFile (@RequestParam(value="type" ,required =false ) int type )throws Exception{
		
		List<File> list = fileServiceImpl.getFile(type);
		
		return list;
	}
}
