package org.great.bean;

import java.util.ArrayList;
import java.util.List;

public class PageQueryBean {

	
	private int uId;
	private String elsepagequery;
	private ArrayList<String> conditionData;
	private int currentPage;
	private String pageNo;
	private boolean pageQueryFlag;
	private boolean deleteFlag;
	private boolean updateFlag;
	
	private int number;
	private int allPage;
	private ArrayList<UserBean> userList;
	
	public PageQueryBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageQueryBean(int uId, String elsepagequery, ArrayList<String> conditionData, int currentPage,String pageNo,
			boolean pageQueryFlag, boolean deleteFlag, boolean updateFlag) {
		super();
		this.uId = uId;
		this.elsepagequery = elsepagequery;
		this.conditionData = conditionData;
		this.currentPage = currentPage;
		this.pageNo=pageNo;
		this.pageQueryFlag = pageQueryFlag;
		this.deleteFlag = deleteFlag;
		this.updateFlag = updateFlag;
	}

	public PageQueryBean(int currentPage, int number, int allPage, ArrayList<UserBean> userList) {
		super();
		this.currentPage = currentPage;
		this.number = number;
		this.allPage = allPage;
		this.userList = userList;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getElsepagequery() {
		return elsepagequery;
	}

	public void setElsepagequery(String elsepagequery) {
		this.elsepagequery = elsepagequery;
	}

	public ArrayList<String> getConditionData() {
		return conditionData;
	}

	public void setConditionData(ArrayList<String> conditionData) {
		this.conditionData = conditionData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean getPageQueryFlag() {
		return pageQueryFlag;
	}

	public void setPageQueryFlag(boolean pageQueryFlag) {
		this.pageQueryFlag = pageQueryFlag;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public boolean getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	public int getAllPage() {
		return allPage;
	}




	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public ArrayList<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserBean> userList) {
		this.userList = userList;
	}

	
	
}
