<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8"%>
<%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=path %>css2/home.css" type="text/css"/>
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<script src="<%=path%>javascript/home.js" type="text/javascript"></script>
<script type="text/javascript" >
var httpRequest;
if(window.XMLHttpRequest){
	
	httpRequest=new XMLHttpRequest();
}else{
	httpRequest=new ActiveXObject('Microsoft.XMLHTTP');
}

function check(handele){
	//supsw suaffpsw suphone suemail
	if("name"==handele){
		var regUName=document.getElementById("reg_uname").value;
		if(regUName==""){
			$("#suname").html("用户名不能为空!");
    		return false;
		}else{
			var url="<%=path%>BackLoginServlet?action=userregistecheck&adminname="+regUName;
			httpRequest.onreadystatechange=cfun;
			httpRequest.open("POST", url, true);
			httpRequest.send();
		}
	}
	if("psw"==handele){
		var regUPsw = document.getElementById("reg_upsw").value;
		if(regUPsw==""){
			$("#supsw").html("密码不能为空!");
		    return false;
		}else if(regUPsw.length>6){
			$("#supsw").html("密码不能大于6位!");
		    return false;
		}else{
			$("#supsw").html("√");
			return false;
		}
	}
	if("affpsw"==handele){
		var regUPsw = document.getElementById("reg_upsw").value;
		var regAffirmPsw = document.getElementById("reg_affirm_psw").value;
		if(regAffirmPsw==""){
			$("#suaffpsw").html("确认密码不能为空!");
	    	return false;
		}else if(regAffirmPsw!=regUPsw){
			$("#suaffpsw").html("两次密码不符合!");
	    	return false;
		}else if(regUPsw==regUPsw){
			$("#suaffpsw").html("√");
			return false;
		}
	}
	if("age"==handele){
		var regUage = document.getElementById("reg_age").value;
		var age=/^\+?[1-9][0-9]*$/;
		if(regUage==""){
			$("#suage").html("年龄不能为空!");
	    	return false;
		}else if(!age.test(regUage)){
			$("#suage").html("年龄格式不对!");
		}else{
			$("#suage").html("√");
			return false;
		}
	}
	if("phone"==handele){
		var regPhone = document.getElementById("reg_phone").value;
		var phone=/^1[3|5|7|8][0-9]{9}$/;
		if(!phone.test(regPhone)){
			$("#suphone").html("请输入正确的手机号!");
	    		return false;
		}else{
			$("#suphone").html("√");
			return false;
		}
	}
	if("address"==handele){
		var regAddress = document.getElementById("reg_address").value;
		if(regAddress==""){
			$("#suaddress").html("请输入正确的地址!");
			return false;
		}else{
			$("#suaddress").html("√");
			return false;
		}
	}
	if("email"==handele){
		var regEmail = document.getElementById("reg_email").value;
		var mail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/;
		if(!mail.test(regEmail)){
			$("#suemail").html("请输入正确的邮箱地址!");
			return false;
		}else{
			$("#suemail").html("√");
			return false;
		}
	}
	console.log("111");
	
	
//	var regUName = document.getElementById("reg_uname").value;
//	var regUPsw = document.getElementById("reg_upsw").value;
//	var regAffirmPsw = document.getElementById("reg_affirm_psw").value;
//	var regPhone = document.getElementById("reg_phone").value;
//	var regEmail = document.getElementById("reg_email").value;
//	var phone=/^1[3|5|7|8][0-9]{9}$/;
//	var mail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/;
//	supsw suaffpsw suphone suemail
}

function cfun(){
	if((httpRequest.readyState==4)&&(httpRequest.status==200)){
		var unamespan = httpRequest.responseText;

		$("#suname").html(unamespan);
	}
}
function returnlogin(){
	window.location.href="<%=path%>html/login.jsp";
}

function beforeRegistSubmit(){
	
	console.log("------");
	console.log($("#supsw").text());
	alert("111");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body onload="time();">





<div class="layout" id="center">
	<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</h1>
	<div id="div_regist_main">
	<form id="form_regist" onSubmit="return beforeRegistSubmit();" action="<%=path %>registeAction.action" method="post">
		<table id="table_regist">
		<tr>
			<td>请输入用户名：</td>
			<td><input id="reg_uname" type="text" name="user.userName" onblur="check('name');"></input><span id="suname" style="color: red;"></span></td>
			
		</tr>

		<tr>
			<td>密码：</td>
			<td><input id="reg_upsw" type="password" name="user.userPsw" onblur="check('psw');"></input><span id="supsw" style="color: red;"></span></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input id="reg_affirm_psw" type="password" name="uconfirmpsw" onblur="check('affpsw');"></input><span id="suaffpsw" style="color: red;"></span></td>
			
		</tr>
		<tr>
			<td>性别：</td>
			<td><input type="radio" name="radio" value="1">男
			<input type="radio" name="radio" value="2">女<span id="susex" style="color: red;"></span></td>
			
		</tr>
		<tr>
			<td>学历：</td>
			<td><select id="reg_education" name="usex" >
			<option>---请选择---</option>
			<option>高中</option>
			<option>大专</option>
			<option>本科</option>
			<option>硕士</option>
			<option>博士</option>
			</select><span id="suage" style="color: red;"></span></td>
			
		</tr>
		<tr>
			<td>职业：</td>
			<td><select id="reg_occupation" name="usex" >
			<option>---请选择---</option>
			<option>教育工作者</option>
			<option>个体</option>
			<option>政府工作者</option>
			</select><span id="suage" style="color: red;"></span></td>
			
		</tr>
		<tr>
			<td>E-mail：</td>
			<td><input id="reg_email" type="text" name="uemail" onblur="check('email');"></input><span id="suemail" style="color: red;"></span></td>
			
		</tr>
		<tr>
			<td>手机：</td>
			<td><input id="reg_phone" type="text" name="uphone" onblur="check('phone');"></input><span id="suphone" style="color: red;"></span></td>
			
		</tr>
		
		</table>
		<br>
 		<div id="div_btn_regist">
		<input type="submit" class="button" name="registe" value="注册"/>
  		</div>
		<div id="div_btn_reset">
		<input type="button" class="button" onclick="returnlogin()" name="reset" value="返回"/>
  		</div>
		</form>
	</div>
</div>

		
</body>
</html>