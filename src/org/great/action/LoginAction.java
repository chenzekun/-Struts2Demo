package org.great.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.great.bean.UserBean;



public class LoginAction implements SessionAware{
	
	private String userName;
	private String userPsw;
	private String inputName;
	private String msg;
	private UserBean test;
	public Map<String,Object> session;
	
	public String login()  {
		
		// TODO Auto-generated method stub
		
		String flag="success";
		
		if("admin".equals(userName)&&"123".equals(userPsw)) {
			System.out.println("登录成功-------");
			//session1
			//	Map<String,Object> sessionMap = ActionContext.getContext().getSession();
			
			//sessionMap.put("USER", user);
			//N页  
			/*HttpSession session=	ServletActionContext.getRequest().getSession();
			session.setAttribute("USER", user);
			*/
			
			ServletContext  application = ServletActionContext.getRequest().getServletContext();
			application.setAttribute("COUNT", 1);
			
			UserBean user = new UserBean(userName);
			
			session.put("USER", user);
			
			flag = "success";
		}else {
			flag="error";
		}
		
		return flag;
	}
	
	public String checkUName()  {
		
		// TODO Auto-generated method stub
		
		String flag="success";
		
		if("admin".equals(inputName)) {
			System.out.println("检验---存在该账户！×");
			msg="该账户存在！";
			test=new UserBean("admin");
			
		}else {
			System.out.println("检验---不存在该账户！√");
			msg="√";
			
		}
		
		return flag;
	}


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPsw() {
		return userPsw;
	}



	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}



	public String getInputName() {
		return inputName;
	}



	public void setInputName(String inputName) {
		this.inputName = inputName;
	}



	public UserBean getTest() {
		return test;
	}

	public void setTest(UserBean test) {
		this.test = test;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
	
	
	
}
