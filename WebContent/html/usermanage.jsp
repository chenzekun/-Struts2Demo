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
<link rel="stylesheet" href="<%=path %>css/jHsDate.css">
<link rel="stylesheet" href="<%=path%>css/GoodList.css" type="text/css"/>
<script src="<%=path %>javascript/jquery.min.js"></script>
<script src="<%=path %>javascript/jHsDate.js"></script>
<script src="<%=path %>javascript/jquery-ui.js"></script>
<script type="text/javascript">
	
function PageQuery(handle){
	
	var conditionData = [$('#date').val(),$('#date1').val(),$('#qname').val()]; 
	var currentPage=$('#hiddencurrentpage').val();
	if("delete"==handle){
		var uId=0;
		var elsepagequery="firstpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=true;
		var updateFlag=false;
	}else if("update"==handle){
		var uId=0;
		var elsepagequery="firstpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=true;
		var updateFlag=false;
	}else if("firstpagequery"==handle){
		var uId=0;
		var elsepagequery="firstpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=false;
		var updateFlag=false;
	}else if("lastpagequery"==handle){
		var uId=0;
		var elsepagequery="lastpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=false;
		var updateFlag=false;
	}else if("nextpagequery"==handle){
		var uId=0;
		var elsepagequery="nextpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=false;
		var updateFlag=false;
	}else if("endpagequery"==handle){
		var uId=0;
		var elsepagequery="endpagequery";
		var pageNo="";
		var pageQueryFlag=true;
		var deleteFlag=false;
		var updateFlag=false;
	}else{
		var uId=0;
		var elsepagequery="";
		var pageNo=$('#pageNo').val();
		var pageQueryFlag=false;
		var deleteFlag=false;
		var updateFlag=false;
	}
	

	var data={
			uId: uId,
			elsepagequery:elsepagequery,
			pageNo:pageNo,
			pageQueryFlag:pageQueryFlag,
			deleteFlag:deleteFlag,
			updateFlag:updateFlag,
			conditionData:conditionData,
			currentPage:currentPage
	};
	
	console.log(data);
	console.log(JSON.stringify(data));
	
    $.ajax({
        type:"POST",
        url:"<%=path%>userAction!PageQuery.action",
        data: "JSONMSG="+JSON.stringify(data),//必要
        dataType:"json",
        async: false,
        success:function(data){
        	
        	$("#Table1").empty();
        	$("#currentPage").empty();
        	$("#hidden").empty();
        	 console.log("---"+data.currentPage);
        	 var tempHtml = "";
        	 var userList=data.userList;
        	 tempHtml +="<tr>";
        	 tempHtml +="<th>序号</th><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th><th>操作</th>";
        	 tempHtml +="</tr>";
             for(var i = 0; i< userList.length; i++)
             {		
                  tempHtml += "<tr><td>"+(data.number+i)+"</td><td>"+userList[i].name+"</td><td>"+userList[i].regTime+"</td><td>"+userList[i].integral+"</td><td>"+userList[i].upNumber+"</td><td>"+userList[i].downNumber+"</td><td>"+userList[i].state+"</td><td><a href='<%=path%>userAction!userDelete.action?uid='"+userList[i].userId+">删除</a><span></span>|<a href='<%=path%>userAction!userUpdate.action?uid='"+userList[i].userId+">修改</a></td></tr>";
             }
             
             $("#Table1").append(tempHtml);//currentPage //添加你拼接好的html到table里
             var html2="";
             html2+="当前页数：["+data.currentPage+"/"+data.allPage+"]";//
             $("#currentPage").append(html2);
             var html3="";
             html3+="<input id='hiddencurrentpage' type='hidden' name='_viewstate' value='"+data.currentPage+"' /> ";
             $("#hidden").append(html3);
/*              $("#graduated").html("教育背景:&nbsp;&nbsp;&nbsp;&nbsp;"+c.graduatedFrom);
             $("#position").html("职称:&nbsp;&nbsp;&nbsp;&nbsp;"+c.position);
             $("#class").html("擅长领域:&nbsp;&nbsp;&nbsp;&nbsp;"+c.classTxt);
             $("#price").html("服务价格:&nbsp;&nbsp;&nbsp;&nbsp;"+c.price); */
<%--            //<%=path%>userAction!userDelete.action?uid=${user.userId }
                //<%=path%>userAction!userUpdate.action?uid=${user.userId } --%>
        }
    });
    
}

</script>
</head>

<body>
<h1></h1>


 <table id="tbl_list" width="1000" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;text-align:center;margin: 0 auto;">
          <tr>
           <td style=" text-align:center; font-size:16px; font-weight:bold;height:35px;">用户列表信息</td>
            </tr> 
            <tr><td style="border:0;">
            <table id="Table1" width="100%" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;">
					<tr>
						<th>序号</th><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th><th>操作</th>
					</tr>
				 
					<c:forEach items="${pageQueryBean.userList}"  var="user" varStatus="vs" >
				
					<tr style="background-color:white;">
						<td>${vs.index+pageQueryBean.number}</td>
						<td>${user.name }</td>
						<td>${user.regTime }</td>
						<td>${user.integral }</td>
						<td>${user.upNumber }</td>
						<td>${user.downNumber }</td>
						<td>${user.state }</td>
						<td>
						<a onclick="PageQuery('delete')">删除</a><span></span>
						
						|<a onclick="PageQuery('update')">修改</a></td>
					</tr>

					</c:forEach>
						
					</table>
            </td>
            </tr>
        </table>
  
  <table id="tbl_page" align="center" style="width:700px">
    <tr>
      <td>共3条</td>
      <td id="currentPage">当前页数：[${pageQueryBean.currentPage} / ${pageQueryBean.allPage}]</td>
      <td id="hidden" ><input id="hiddencurrentpage" type="hidden" name="_viewstate" value="${pageQueryBean.currentPage}" /></td>
      <td><a onclick="PageQuery('firstpagequery')">第一页</a></td>
      <td><a onclick="PageQuery('lastpagequery')">上一页</a>&nbsp;&nbsp;&nbsp;
      <a onclick="PageQuery('nextpagequery')">下一页</a></td>
      <td><a onclick="PageQuery('endpagequery')">末页</a></td>
     
    </tr>
    <tr>
      <td style="width:500px;text-align:center;">预约时间：<input id="date" type="text" name="conStartDate" style="width:100px"/>至<input id="date1" type="text" name="conEndDate" style="width:100px"/></td>
      <td>用户名：<input id="qname" type="text" name="qname" style="width:50px"/></td>
	  <td>跳转页数:<input id="pageNo" type="text" name="pageno" style="width:40px"/></td>
      <td><input onclick="PageQuery('else')" class="button" type="button" value="查询" style="width:120px"/></td>
    </tr>
  </table>
  
  
  

<script type="text/javascript">
$('#date').jHsDate();
$('#date1').jHsDate();
</script>
</body>
</html>