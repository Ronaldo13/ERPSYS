<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>基本信息</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <div>
		<label>用户照片：</label>
		<img src="<%=basePath%>style/photo/${username}.jpg" name="pic" width="100px" hight="200px">
	</div> --%>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th colspan="2">基本信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>用户照片：</td>
					<td><img src="<%=basePath%>style/photo/${username}.jpg" name="pic" width="100px" hight="200px"></td>
				</tr>
				<tr>
					<td width="10%">账号：</td>
					<td>${ebi.accountId }</td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td>${ebi.accountName }</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>${ebi.accountSex }</td>
				</tr>
				<tr>
					<td>岗位编号：</td>
					<td>${ebi.accountJobId }</td>
				</tr>
				<tr>
					<td>入职时间：</td>
					<td><fmt:formatDate value="${ebi.accountEntryTime }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td>学历：</td>
					<td>${ebi.accountEduLevel }</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td>${ebi.accountPhone }</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td>${ebi.accountIdcard }</td>
				</tr>
				<tr>
					<td>住址：</td>
					<td>${ebi.accountAddress }</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td>${ebi.accountEmail }</td>
				</tr>
				
			</tbody>
		</table>
	</div>
</body>
</html>