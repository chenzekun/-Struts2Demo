package org.great.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.interceptor.SessionAware;
import org.great.bean.PageQueryBean;
import org.great.bean.UserBean;
import org.great.biz.UserBizImpl;
import org.great.biz.UsreBiz;
import org.great.util.GsonUtil;


public class UserAction implements SessionAware{
	
	public Map<String,Object> session;
	private List ulist;
	private UsreBiz userBiz = new UserBizImpl();
	//private String uid;
	private String flag="success";
	private UserBean updateUser;
	private UserBean finishUser;
	
	private PageQueryBean pageQueryBean;
	
	private ArrayList<UserBean> userList;
	private StringBuffer conditionSql;
	private ArrayList<Object> conditionList;
	private int dataCount;
	private int allPage;
	//uId pageQueryFlag deleteFlag updateFlag elsePageQuery
	private ArrayList<String> conditionData;
	private int currentPage;
	private int number;
	private int uId;
	private boolean pageQueryFlag;
	private boolean deleteFlag;
	private boolean updateFlag;
	String elsePageQuery;
	String pageNo;
	
	private String JSONMSG;
	private PageQueryBean pageQueryData;
	
	public String userManager() {
		
		userList=new ArrayList<UserBean>();
		//conditionData=new ArrayList<String>();
		conditionSql=new StringBuffer("SELECT * FROM tblUser WHERE 1=1 ");
		conditionList=new ArrayList<Object>();
		
		if(null!=conditionData){
			conditionData=pageQueryBean.getConditionData();
		}else{
			conditionData=new ArrayList<String>();
		}
		
		dataCount = 3;
		allPage = 1;
		
		if(0!=currentPage){
			currentPage=pageQueryBean.getCurrentPage();
		}else{
			currentPage=1;
		}
		
		for(int i=0;i<conditionData.size();i++){
			if (null != conditionData.get(0) && !"".equals(conditionData.get(0))) {

				StringBuffer condition = new StringBuffer(" AND NAME like '%" + conditionData.get(0) + "%'");
				conditionSql.append(condition);
				//conditionList.add("'%" + conditionData.get(0) + "%'");
			}
		}

		// 查询总页数
		allPage = userBiz.QueryUserListAllPage(conditionSql, conditionList, userList, allPage, currentPage, dataCount);
		//DAo ulist
		//UserBean u1 = new UserBean("001","张三","123");		
		pageQueryBean =userBiz.Reflash(conditionData, conditionSql, conditionList, uId, pageQueryFlag, deleteFlag, updateFlag, userList, allPage, currentPage, dataCount, elsePageQuery);
		
//		ulist=pageQueryBean.getUserList();
//		currentPage=pageQueryBean.getCunrrentPage();
//		number=pageQueryBean.
		
		return flag;
	}
	
	public String userDelete() {
//		System.out.println("删除的id"+uid);
//		
//		List ulistX =userBiz.getUserAll(1);
//		
//        Iterator it= ulistX.iterator();
//        while(it.hasNext()){
//
//            Object e=it.next();
//            System.out.println(uid+"/"+((UserBean)e).getUserId());
//            if(uid.equals(""+((UserBean)e).getUserId())){
//
//                it.remove();
//                System.out.println("---");
//            }
//
//        }
//        
//        ulist=ulistX;
        
		return flag;
	}
	
	public String userUpdate() {
//		System.out.println("要修改的id"+uid);
//		flag="toupdate";
//		
//		ulist =userBiz.getUserAll(1);
//		
//		for(int i=0;i<ulist.size();i++){
//			if(uid.equals(""+((UserBean)ulist.get(i)).getUserId())){
//				updateUser=(UserBean)ulist.get(i);
//			}
//		}
		
		return flag;
	}//
	
	public String userConfirmUpdate() {
		System.out.println("&&&&&&&&&&&&&&");
		System.out.println("修改的id"+updateUser.getUserId());
		System.out.println("修改后的学历"+updateUser.getEducation());
		
		return flag;
	}
	
	public String PageQuery() {
		
		System.out.println("json字符串---"+JSONMSG);
		
		PageQueryBean pageQueryBean =GsonUtil.getInstance().getGson().fromJson(JSONMSG,PageQueryBean.class);
		
		userList=new ArrayList<UserBean>();
		//conditionData=new ArrayList<String>();
		conditionSql=new StringBuffer("SELECT * FROM tblUser WHERE 1=1 ");
		conditionList=new ArrayList<Object>();
		conditionData=pageQueryBean.getConditionData();
		dataCount = 3;
		allPage = 1;
		currentPage=pageQueryBean.getCurrentPage();
		elsePageQuery=pageQueryBean.getElsepagequery();
		pageQueryFlag=pageQueryBean.getPageQueryFlag();
		deleteFlag=pageQueryBean.getDeleteFlag();
		updateFlag=pageQueryBean.getUpdateFlag();
		pageNo=pageQueryBean.getPageNo();
		
		for(int i=0;i<conditionData.size();i++){
			
			if (i==0) {
				System.out.println("条件---"+conditionData.get(i));
//				StringBuffer condition = new StringBuffer(" AND NAME like ?");
//				conditionSql.append(condition);
//				conditionList.add("%" + conditionData.get(0) + "%");
			}
			if (i==1) {
				System.out.println("条件---"+conditionData.get(i));
//				StringBuffer condition = new StringBuffer(" AND NAME like ?");
//				conditionSql.append(condition);
//				conditionList.add("%" + conditionData.get(0) + "%");
			}
			if (i==2) {
				System.out.println("条件---"+conditionData.get(i));
				if(!"".equals(conditionData.get(i))){
					StringBuffer condition = new StringBuffer(" AND NAME like ?");
					conditionSql.append(condition);
					conditionList.add("%" + conditionData.get(i) + "%");
				}
			}
		}

		// 查询总页数
		allPage = userBiz.QueryUserListAllPage(conditionSql, conditionList, userList, allPage, currentPage, dataCount);
		
		pageQueryBean=userBiz.UserListPageQuery(conditionData, conditionSql, conditionList, uId, pageQueryFlag, deleteFlag, updateFlag, userList, allPage, currentPage, dataCount, elsePageQuery,pageNo);
		
		flag="pagequerysuccess";
		
		pageQueryData=pageQueryBean;
		
		System.out.println("传给前台页数---"+pageQueryData.getCurrentPage());
		for(int i=0;i<pageQueryData.getUserList().size();i++){
			System.out.println(pageQueryData.getUserList().get(i).getName());
			System.out.println("序号---"+pageQueryData.getNumber());
		}
		return flag;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
		
	}

	public List getUlist() {
		return ulist;
	}

	public void setUlist(List ulist) {
		this.ulist = ulist;
	}

	public UserBean getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserBean updateUser) {
		this.updateUser = updateUser;
	}

	public UserBean getFinishUser() {
		return finishUser;
	}

	public void setFinishUser(UserBean finishUser) {
		this.finishUser = finishUser;
	}

	public PageQueryBean getPageQueryBean() {
		return pageQueryBean;
	}

	public void setPageQueryBean(PageQueryBean pageQueryBean) {
		this.pageQueryBean = pageQueryBean;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PageQueryBean getPageQueryData() {
		return pageQueryData;
	}

	public void setPageQueryData(PageQueryBean pageQueryData) {
		this.pageQueryData = pageQueryData;
	}

	public String getJSONMSG() {
		return JSONMSG;
	}

	public void setJSONMSG(String jSONMSG) {
		JSONMSG = jSONMSG;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}


}
