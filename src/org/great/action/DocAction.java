package org.great.action;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.great.bean.DocBean;
import org.great.biz.DocBiz;
import org.great.util.MybatisTool;
import org.springframework.stereotype.Controller;
import dbDao.DocInterface;


@Controller
public class DocAction {
	
	private List<DocBean> docList;
	
	@Resource
	private DocBiz docBizImpl;
	
	public String GetDocList(){
		
		docList=docBizImpl.QueryDoc();
		System.out.println("docadction////");
		return "success";
	}


	public List<DocBean> getDocList() {
		return docList;
	}


	public void setDocList(List<DocBean> docList) {
		this.docList = docList;
	}
	
	
}
