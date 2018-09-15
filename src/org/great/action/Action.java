package org.great.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	
	public static final String SUCCESS="success";
	
	public static final String LOGIN="login";
	
	public static final String ERROR="error";
	
	public String execute(HttpServletRequest req,HttpServletResponse resp) throws Exception;
	
	
}
