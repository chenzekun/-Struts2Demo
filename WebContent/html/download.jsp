<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<a href="<%=path%>download.action">download</a>

 <table id="tbl_list" width="1000" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;text-align:center;margin: 0 auto;">
          <tr>
           <td style=" text-align:center; font-size:16px; font-weight:bold;height:35px;">用户列表信息</td>
            </tr> 
            <tr><td style="border:0;">
            <table id="Table1" width="100%" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;">
					<tr>
						<th>序号</th><th>文档标题</th><th>上传人</th><th>上传时间</th><th>下载积分</th><th>文档类型</th><th>下载次数</th><th>操作</th>
					</tr>
				 
					<c:forEach items="${docList}"  var="doc" varStatus="vs" >
				
					<tr style="background-color:white;">
					<!-- //docId, userId, docTitle, docInfo, docClass, uploadTime, downloadCount, downIntegral, docUrl  -->
						<td>${vs.index+1}</td>
						<td>${doc.docTitle }</td>
						<td>${doc.userId }</td>
						<td>${doc.uploadTime }</td>
						<td>${doc.docIntegral }</td>
						<td>${doc.docClass }</td>
						<td>${doc.downloadCount }</td>
						<td><a onclick="PageQuery('update')">下载</a></td>
					</tr>

					</c:forEach>
						
					</table>
            </td>
            </tr>
        </table>
  
  <%-- <table id="tbl_page" align="center" style="width:700px">
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
  </table> --%>

</body>
</html>