package org.great.biz;

import java.util.List;
import javax.annotation.Resource;
import org.great.bean.DocBean;
import org.springframework.stereotype.Service;

import dbDao.DocInterface;


@Service
public class DocBizImpl implements DocBiz{
	
	
	@Resource
	private DocInterface docInterface;
	
	@Override
	public List<DocBean> QueryDoc() {
		// TODO Auto-generated method stub
		return docInterface.QueryDoc();
	}

}
