package com.mcfish.controller.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcfish.controller.base.BaseController;
import com.mcfish.controller.base.InterfaceResult;
import com.mcfish.entity.common.Admin;
import com.mcfish.entity.common.DocMessage;
import com.mcfish.service.common.IDocumentService;
import com.mcfish.util.PageData;;

/**
 * 文件柜管理Controller
 * @author ZhangYichi
 * @date 2018年4月23日 下午2:26:17 
 * @version 1.0
 */
@Controller
@RequestMapping(value="/shareDocumentController")
public class DocumentController extends BaseController{

	@Resource(name="documentServiceImpl")
	private IDocumentService documentServiceImpl;
	
	/**
	 * 跳转到文件柜页面
	 * @author ZhangYichi 
	 * @date 2018年4月23日 下午2:27:14 
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/DocumentPage.do")
	public ModelAndView tologin() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/document/document");
		mv.addObject("pd", pd);
		
		return mv;
	}
	
	
	/**
	 * 跳转到新建文件页面
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午13:27:14 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toDocbuild.do")
	public ModelAndView toAddAboutPage() throws Exception {
		ModelAndView mv = this.getModelAndView();
		
		mv.setViewName("common/document/docbuild");
		
		return mv;
	}
	
	
	/**
	 * 获取文件列表
	 * @author ZhangYichi 
	 * @date 2018年4月23日 下午3:27:14 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllDocument.do")
	public Object getAllDocument (HttpServletRequest request)throws Exception{
		PageData pd = new PageData(request);
		
		List<DocMessage> docMessages = documentServiceImpl.getDoc(pd);
		Long docTotal = docMessages.size() == 0 ? 0l:docMessages.get(0).getTotal();
		
		return InterfaceResult.returnTableSuccess(docMessages, docTotal, pd.get("draw"));
	}
	
	
	/**
	 * 新增文件
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午3:50:14 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addDocument.do")
	public Object addDocument(HttpSession session) throws Exception {
		PageData pd = this.getPageData();
		String account = (String)session.getAttribute("account");
		Admin admin = documentServiceImpl.getAdmin(account);
		int id = admin.getId();
		
	    pd.put("roleid", id);
	
		documentServiceImpl.addDocument(pd);
		
		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 根据id获取文件
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午5:27:14 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value ="/getDocById.do")
	public Object getDocById(@RequestParam(required = true) int id)throws Exception{
        
        DocMessage docmessage = documentServiceImpl.getDocmessById(id);
        
		return InterfaceResult.returnSuccess(docmessage);
	}
	
	
	/**
	 * 根据id编辑文件
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午6:12:20 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/toUpdatedoc.do")
	public Object updtaDocById(HttpSession session)throws Exception{
		PageData pd = this.getPageData();
		String account = (String)session.getAttribute("account");
		Admin admin = documentServiceImpl.getAdmin(account);
		String name = admin.getName();
		
		pd.put("creator", name);
		
		documentServiceImpl.updateDocById(pd);

		return InterfaceResult.returnSuccess(null);
	}
	
	
	/**
	 * 根据id跳转到文件页面
	 * @author ZhangYichi 
	 * @date 2018年4月24日 下午6:12:20 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/toDocDetail.do")
	public ModelAndView toDocDetail() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		mv.setViewName("common/document/docbuild");
		mv.addObject("pd", pd);
		
		return mv;
	}	
}
