<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getScheme() +"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=path%>css/backlogin.css" type="text/css"/>

<title>登录</title>

<style type="text/css">
<!--
.STYLE1 {font-family: "新宋体"}
.STYLE8 {font-family: "新宋体", Times, serif}
.STYLE10 {font-family: "新宋体", Times, serif; font-size: 18px; font-weight: bold; }
.STYLE11 {font-family: "新宋体"; font-size: 18px; font-weight: bold; }
-->
</style>
<script type="text/javascript" src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<script type="text/javascript" charset="utf-8">

var httpRequest;
if(window.XMLHttpRequest){
	
	httpRequest=new XMLHttpRequest();
}else{
	httpRequest=new ActiveXObject('Microsoft.XMLHTTP');
}

function check(handele){

//	var loginForm = document.getElementById('form_login');
//	var uname = document.getElementById("uname").value;
//	var upsw = document.getElementById("upsw").value;
	
	if("name"==handele){
		var loginName=document.getElementById("backname").value;
		console.log("111");
		if(loginName==""){
			$("#suname").html("用户名不能为空!");
    		return false;
		}
		else{
			
<%-- 			var url="<%=path%>checkInput/loginAction!checkUName.action?inputName="+loginName;
			httpRequest.onreadystatechange=cfun;
			httpRequest.open("POST", url, true);
			httpRequest.send(); --%>
		    $.ajax({
		        type: "post",
		        data:  "inputName=" + loginName,
		        dataType: "json",
		        url: "<%=path%>checkInput/loginAction!checkUName.action",
		        async:false,
		        success: function (data) {
		        	$("#suname").html(data);
		        },
		        error: function(json){  
		            alert("error");  
		        }  
		    });
		}
	}
	if("psw"==handele){
		var regUPsw = document.getElementById("backpsw").value;
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
}

function registe(){
	console.log("11111");
	window.location.href="<%=path%>html/userregiste.jsp";
}

function cfun(){
	if((httpRequest.readyState==4)&&(httpRequest.status==200)){
		var unamespan = httpRequest.responseText;
		console.log("999");
		console.log(unamespan);
		$("#suname").html(unamespan);
	}else{
		console.log("888");
	}
}

function changeCodeImg(){
	
	var codeImage = document.getElementById("codeImage");
	codeImage.src = "<%=path%>imageAction!changeImage.action?"+Math.random();

}
</script>
</head>

<body>

<h1 align="center">登录</h1>

<div id="div_Main">
<form  id="form_login"  action="loginAction!login.action" method="post">
  <br>
  <table border="0" >
  <tr>
    <td style="width:100px"><span class="STYLE11">账户名</span><span class="STYLE1">：</span></td>
    <td class="STYLE1"><input id ="backname" type="text" name="userName" onblur="check('name');"></input><span id ="suname" style="color: red;"></span></td>
  </tr>
  <tr>
    <td class="STYLE11">密码：</td>
    <td class="STYLE1"><input id ="backpsw" type="password" name="userPsw" onblur="check('psw');"></input><span id ="supsw" style="color: red;"></span></td>
    <td class="STYLE1"><img src="../image/suo.png"> </td>
  </tr>
  <tr>
    <td class="STYLE10">验证码：</td>
    <td>
      <span class="STYLE8">
      <input type="text" name="verificationcode"></input>
    </span></td>
    <td><img src="<%=path%>imageAction!changeImage.action" id="codeImage"></td>
    <td style="width:100px;"><a onclick ="changeCodeImg()" >看不清？</a></td>
  </tr>
  <tr>
  	<td  class="STYLE10">登录角色：</td>
  	<td><select id="select" name="loginrole" style="width:150px">
     			<option type="chekbox"name="twoClassId" >用户</option>
				<option type="chekbox"name="twoClassId" >咨询师</option>
				<option type="chekbox"name="twoClassId" >管理员 </option>
			    </select>
    </td>
  </tr>
  </table>
  <br>
  <div id="div_btn_login">
	<input type="submit" id="btn_login" name="login"  value="登录"/>
  </div>
  <div id="div_btn_reg">
  <input type="button" id="btn_reg" name="reg"  value="注册" onclick="registe()" style="margin-left: 100px;float: right;"/>
  </div>
</form>
</div>

</body>
</html>