package org.great.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.tracing.dtrace.ProviderAttributes;

@Component
public class DocBean {
//    DOCID NUMBER(20,0) NOT NULL ENABLE, 
//	USERID NUMBER(20,0) NOT NULL ENABLE, 
//	DOCTITLE VARCHAR2(200 BYTE), 
//	DOCINFO VARCHAR2(200 BYTE), 
//	DOCCLASS VARCHAR2(20 BYTE), 
//	UPLOADTIME VARCHAR2(20 BYTE), 
//	DOWNLOADCOUNT NUMBER(20,0), 
//	DOCINTEGRAL NUMBER(20,0), 
//	DOCURL VARCHAR2(20 BYTE)
	private int docId;
	private int userId;
	private String docTitle;
	private String docInfo;
	private String docClass;
	private String uploadTime;
	private int downloadCount;
	private int docIntegral;
	@Value("/2/2/2")
	private String docUrl;
	
	
	public DocBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DocBean( int userId, String docTitle, String docInfo, String docClass, String uploadTime,
			int downloadCount, int docIntegral, String docUrl) {
		super();
		
		this.userId = userId;
		this.docTitle = docTitle;
		this.docInfo = docInfo;
		this.docClass = docClass;
		this.uploadTime = uploadTime;
		this.downloadCount = downloadCount;
		this.docIntegral = docIntegral;
		this.docUrl = docUrl;
	}


	public int getDocId() {
		return docId;
	}


	public void setDocId(int docId) {
		this.docId = docId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDocTitle() {
		return docTitle;
	}


	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}


	public String getDocInfo() {
		return docInfo;
	}


	public void setDocInfo(String docInfo) {
		this.docInfo = docInfo;
	}


	public String getDocClass() {
		return docClass;
	}


	public void setDocClass(String docClass) {
		this.docClass = docClass;
	}


	public String getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}


	public int getDownloadCount() {
		return downloadCount;
	}


	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}


	public int getDocIntegral() {
		return docIntegral;
	}


	public void setDocIntegral(int docIntegral) {
		this.docIntegral = docIntegral;
	}


	public String getDocUrl() {
		return docUrl;
	}


	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	
	
	
	
	
	
	
}
