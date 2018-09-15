package org.great.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	
	private String fname;
	
	
	public InputStream getDownloadFile()
	{
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/2-27.txt");
	}
	
	@Override
	public String execute() throws Exception

	{
		return SUCCESS;
	}

	public String getFname() {
		return "2-27.txt";
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
}
