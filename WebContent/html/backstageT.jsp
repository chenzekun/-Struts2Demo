<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,javax.servlet.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>css/jquery-ui.css">
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<style type="text/css">
<!--
.STYLE4 {
	font-size: 50px;
	font-weight: bold;
	padding:0; 
	margin:0 auto;
	height:5px;
}
-->
</style>
<script type="text/javascript">
function getCurDate()
{
 var d = new Date();
 var week;
 switch (d.getDay()){
 case 1: week="星期一"; break;
 case 2: week="星期二"; break;
 case 3: week="星期三"; break;
 case 4: week="星期四"; break;
 case 5: week="星期五"; break;
 case 6: week="星期六"; break;
 default: week="星期天";
 }
 var years = d.getFullYear();
 var month = add_zero(d.getMonth()+1);
 var days = add_zero(d.getDate());
 var hours = add_zero(d.getHours());
 var minutes = add_zero(d.getMinutes());
 var seconds=add_zero(d.getSeconds());
 var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
 var divT=document.getElementById("time");
 divT.innerHTML= ndate;
}
function add_zero(temp)
{
 if(temp<10) return "0"+temp;
 else return temp;
}
setInterval("getCurDate()",100);

</script>
</head>
<body>
<%-- <%  String adminName=(String)request.getSession().getAttribute("adminname");int count= ((Integer)request.getSession().getAttribute("count")).intValue();String role=(String)request.getSession().getAttribute("role");%> --%>
<!-- <div id="div1">
  <div>
    <div align="right" height="5">退出系统</div>
  </div>
</div> -->
<div id="div2" style="height: 0px;"> 
  <h1 class="STYLE4" style="height:5px;">文档管理系统<span></span></h1>
</div>
<div id="div3">
  <table width="350" height="0" border="0" align="right" cellpadding="0" cellspacing="0">
    <tr>
      <td width="50" height="5" >账号：</td>
      <td width="73" height="5" style="color: green;font-weight: bold;"> ${sessionScope.USER.name}</td>
      <td width="70" height="5" >账号级别：</td>
      <td width="70" height="5" style="color: blue;font-weight: bold;">null</td>
    </tr>
  </table>
  <p>&nbsp;</p>
</div>
<div id="div4">
  <table width="355"  height="0" border="0" align="right" cellpadding="0" cellspacing="0">
    <tr>
      <td width="80" height="0" >系统时间：</td>
      <td width="260" id="time"  style="color: red;font-weight: bold;"></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</div>
</body>
</html>