<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职位信息增加</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
 <form action="ErpsysJob/addEJK" method="get">
 <table  align="center" class="table" style="width: 50%">
 <tr>
 <td style="width:20%">职位编号</td>
 <td><input style="width:100%" type="text" name="JobId" "/></td>
 </tr>
 <tr>
 <td>职位名称</td>
 <td><input style="width:100%" type="text" name="JobName" /></td>
 </tr>
 <tr>
 <td>所在部门</td>
 <td><input style="width:100%" type="text" name="departmentId" /></td>
 </tr>

 <td colspan="2" align="center"><input class="btn btn-success" type="submit" value="修改"/> <a class="btn btn-warning" href="ErpsysJob/main3">返回</a></td>
 </tr>
 </table>
</form>