<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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

<script type="text/javascript">

function addMore()
{
	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "myfile";
	
	button.type = "button";
	button.value = "Remove";
	
	button.onclick = function()
	{
		td.removeChild(br);
		td.removeChild(input);
		td.removeChild(button);
	}
	
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
	
}

</script>

</head>

<body>

	<table align="center" width="50%">
			<tr>
				<td>

					<%-- <s:fielderror cssStyle="color:red" />  --%>

				</td>
			</tr>
		</table>


		<form action="<%=path%>upload.action"  enctype="multipart/form-data" method="post">

			<table align="center" width="50%" border="1">
				<tr>
					<td>
						username
					</td>
					<td>
						<input type="text" name="username"/>
					</td>
				</tr>

				<tr>
					<td>
						password
					</td>
					<td>
						<input type="password" name="password"/>
					</td>
				</tr>


				<tr>
					<td>
						file
					</td>

					<td id="more">
						<input type="file" name="myfile"/><input type="button" value="Add More.." onclick="addMore()"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value=" submit "/>
					</td>

					<td>
						<input type="reset" value=" reset "/>
					</td>
				</tr>
			</table>

		</form>

</body>

</html>