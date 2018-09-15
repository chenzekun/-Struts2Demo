<%@ page language="java" contentType="text/html; charset=utf-8 " import="java.util.*"
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
<link rel="stylesheet" href="<%=path%>css/GoodList.css" type="text/css"/>
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	if(20=='${examBean.aScore}'){
		$('#selectA').find('option:eq(0)').attr('selected', true);
	}else if(15=='${examBean.aScore}'){
		$('#selectA').find('option:eq(1)').attr('selected', true);
	}else if(10=='${examBean.aScore}'){
		$('#selectA').find('option:eq(2)').attr('selected', true);
	}else if(5=='${examBean.aScore}'){
		$('#selectA').find('option:eq(3)').attr('selected', true);
	}
	if(20=='${examBean.bScore}'){
		$('#selectB').find('option:eq(0)').attr('selected', true);
	}else if(15=='${examBean.bScore}'){
		$('#selectB').find('option:eq(1)').attr('selected', true);
	}else if(10=='${examBean.bScore}'){
		$('#selectB').find('option:eq(2)').attr('selected', true);
	}else if(5=='${examBean.bScore}'){
		$('#selectB').find('option:eq(3)').attr('selected', true);
	}
	if(20=='${examBean.cScore}'){
		$('#selectC').find('option:eq(0)').attr('selected', true);
	}else if(15=='${examBean.cScore}'){
		$('#selectC').find('option:eq(1)').attr('selected', true);
	}else if(10=='${examBean.cScore}'){
		$('#selectC').find('option:eq(2)').attr('selected', true);
	}else if(5=='${examBean.cScore}'){
		$('#selectC').find('option:eq(3)').attr('selected', true);
	}
	if(20=='${examBean.dScore}'){
		$('#selectD').find('option:eq(0)').attr('selected', true);
	}else if(15=='${examBean.dScore}'){
		$('#selectD').find('option:eq(1)').attr('selected', true);
	}else if(10=='${examBean.dScore}'){
		$('#selectD').find('option:eq(2)').attr('selected', true);
	}else if(5=='${examBean.dScore}'){
		$('#selectD').find('option:eq(3)').attr('selected', true);
	}

	});


function showOutter(){
// 通过id，获得输入内容
var content = document.getElementById("content").value;
alert(content);
}
//?updateUser.userId=${updateUser.userId}
//<td><input type="hidden" name="updateUser.userId" value="${updateUser.userId}"/></td>
</script>
</head>

<body>
<h1></h1>
<form action="<%=path%>userAction!userConfirmUpdate.action" method="post">

 <table id="tbl_list" width="300" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;text-align:center;margin: 0 auto;">
          <tr>
           <td style=" text-align:center; font-size:16px; font-weight:bold;height:35px;">修改</td>
            </tr> 
            <tr><td style="border:0;">
            <table id="Table1" width="100%" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;">
			  
			  <tr>	
              	<td style=" text-align:center; font-weight:bold; width:60px;height:35px;">id:<input type="text" name="updateUser.userId" value="${updateUser.userId}"/></td>
              </tr>
              <tr>
              	<td style=" text-align:center; font-weight:bold; width:60px;height:35px;">账号:<input type="text" name="updateUser.userName" value="${updateUser.userName }"/></td>
              </tr>	
              <tr>	
              	<td style=" text-align:center; font-weight:bold; width:60px;height:35px;">密码:<input type="text" name="updateUser.userPsw" value="${updateUser.userPsw }"/></td>
              </tr>
              <tr>
              	<td style=" text-align:center; font-weight:bold; width:60px;height:35px;">性别:<input type="text" name="updateUser.uSex" value="${updateUser.uSex }"/></td>
              </tr>
              <tr>
              	<td style=" text-align:center; font-weight:bold; width:60px;height:35px;">学历:<input type="text" name="updateUser.education" value="${updateUser.education }"/></td>
              </tr>
             		
			
			</table>
            </td>
            </tr>
            <tr><td><input class="button" type="submit" value="确认修改" style="width:150px"/></td></tr>
 </table>
</form>
<script src="" type="text/javascript"></script>
</body>
</html>