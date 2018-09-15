package org.great.action;

import java.nio.file.attribute.UserPrincipalLookupService;

import org.great.bean.UserBean;


public class RegisteAction {
	
	private UserBean user;
	
	public String execute()  {
		// TODO Auto-generated method stub
		
//		System.out.println("1111111111111---"+user.getUserName());
		
		return "success";
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
}
