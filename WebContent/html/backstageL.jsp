<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>css2/jquery-ui.css">
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<script type="text/javascript" >
function showmenu(id) {
 var list = document.getElementById("list"+id);
 var menu = document.getElementById("menu"+id)
 if (list.style.display=="none") {
  document.getElementById("list"+id).style.display="block";
  menu.className = "title1";
 }else {
  document.getElementById("list"+id).style.display="none";
  menu.className = "title";
 }
}
function tologinpage(){
	window.parent.location.href="<%=path%>LogOutServlet";
	
}
</script>
<style type="text/css">
<!--
*{margin:0;padding:0;list-style:none;font-size:14px}
#nav{margin:10px;text-align:center;line-height:40px;width:300px;}
.title{background:#2e3b4e;color:#fff;border-bottom:1px solid #fff;cursor:pointer;}
.title1{background:#888;color:#000;border-bottom:1px solid #666;cursor:pointer;}
.content li{color:#336699;background:#ddd;border-bottom:1px solid #fff;}
-->
</style>
</head>
<body>

<div id="accordion">
<div id="nav">  
<div id="menu1" class="title" onclick="showmenu('1')" style="background-color: blue;"><A href="<%=path%>userAction!userManager.action" style="color: white;" target="center">用户管理</A></div>
<div id="menu1" class="title" onclick="showmenu('2')" style="background-color: blue;"><A href="<%=path%>html/index.jsp" style="color: white;" target="center">上传</A></div>
<div id="menu1" class="title" onclick="showmenu('3')" style="background-color: blue;"><A href="<%=path%>docAction!GetDocList.action" style="color: white;" target="center">下载</A></div>
<div id="menu7" class="title" onclick="showmenu('7')" style="background-color: red;"><A href="javascript: onClick=tologinpage() " style="color: white;">注销</A></div>
</div>
</div>

<script>
$("accordion").accordion();
</script>

</body>
</html>