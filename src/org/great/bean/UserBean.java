package org.great.bean;

import java.util.List;

import javax.annotation.Resource;

public class UserBean {
//	    		USERID NUMBER(4,0), 
//				NAME VARCHAR2(20 BYTE), 
//				PWD VARCHAR2(20 BYTE), 
//				SEX VARCHAR2(20 BYTE), 
//				EDUCATION VARCHAR2(32 BYTE), 
//				JOB VARCHAR2(20 BYTE), 
//				PHONE NUMBER(11,0), 
//				EMAIL VARCHAR2(32 BYTE), 
//				STATE VARCHAR2(20 BYTE), 
//				REGTIME VARCHAR2(64 BYTE), 
//				UPNUMBER NUMBER(8,0), 
//				DOWNNUMBER NUMBER(8,0), 
//				INTEGRAL NUMBER(8,0)
	private int userId;
	private String name;
	private String psw;
	private String sex;
	private String education;
	private String job;
	private Long phone;
	private String eMail;
	private String state;
	private String regTime;
	private int upNumber;
	private int downNumber;
	private int integral;
	
	@Resource
	private List<DocBean> docList;
	
	
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserBean(int userId, String name, String psw, String sex, String education, String job, Long phone,
			String eMail, String state, String regTime, int upNumber, int downNumber, int integral) {
		super();
		this.userId = userId;
		this.name = name;
		this.psw = psw;
		this.sex = sex;
		this.education = education;
		this.job = job;
		this.phone = phone;
		this.eMail = eMail;
		this.state = state;
		this.regTime = regTime;
		this.upNumber = upNumber;
		this.downNumber = downNumber;
		this.integral = integral;
	}



	public UserBean(String name) {
		super();
		this.name = name;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPsw() {
		return psw;
	}



	public void setPsw(String psw) {
		this.psw = psw;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public Long getPhone() {
		return phone;
	}



	public void setPhone(Long phone) {
		this.phone = phone;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getRegTime() {
		return regTime;
	}



	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}



	public int getUpNumber() {
		return upNumber;
	}



	public void setUpNumber(int upNumber) {
		this.upNumber = upNumber;
	}



	public int getDownNumber() {
		return downNumber;
	}



	public void setDownNumber(int downNumber) {
		this.downNumber = downNumber;
	}



	public int getIntegral() {
		return integral;
	}



	public void setIntegral(int integral) {
		this.integral = integral;
	}



	public List<DocBean> getDocList() {
		return docList;
	}



	public void setDocList(List<DocBean> docList) {
		this.docList = docList;
	}
	
	
}
