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
<link rel="stylesheet" href="<%=path %>css/jquery-ui.css">
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
</head>
<frameset rows="10%,*">
<frame name="top" src="<%=path %>html/backstageT.jsp"></frame>
<frameset cols="15%,*">
<frame name="left" src="<%=path %>html/backstageL.jsp"></frame>
<frame name="center" src="<%=path %>html/backstageC.jsp"></frame>
</frameset>

</frameset><noframes></noframes>
</html>