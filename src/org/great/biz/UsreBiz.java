package org.great.biz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.PageQueryBean;
import org.great.bean.UserBean;

public interface UsreBiz {

	//public List getUserAll(int pageNo);
	
	public int QueryUserListAllPage(StringBuffer conditionSql,ArrayList<Object> conditionList,ArrayList<UserBean> userList,int allPage,int currentPage,int dataCount);
	
	public PageQueryBean UserListPageQuery(ArrayList<String>conditionData,StringBuffer conditionSql,ArrayList<Object> conditionList,int uId,boolean pageQueryFlag, boolean deleteFlag, boolean updateFlag, ArrayList<UserBean> userList,
			int allPage, int currentPage, int dataCount, String elsePageQuery,String pageNo);
	
	public PageQueryBean Reflash(ArrayList<String>conditionData,StringBuffer conditionSql,ArrayList<Object> conditionList,int uId,boolean pageQueryFlag, boolean deleteFlag, boolean updateFlag, ArrayList<UserBean> userList,
			int allPage, int currentPage, int dataCount, String elsePageQuery);
}
