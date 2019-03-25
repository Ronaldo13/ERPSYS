<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职位信息修改</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
 <form action="ErpsysJob/modifyEJK" method="get">
 <table align="center" class="table" style="width: 50%">
 <tr>
 <td style="width:20%">职位编号</td>
 <td><input style="width:100%" type="number" name="JobId" value="${erpsysJob.jobId}"/></td>
 </tr>
 <tr>
 <td>职位名称</td>
 <td><input style="width:100%" type="text" name="JobName" value="${erpsysJob.jobName}"/></td>
 </tr>
 <tr>
 <td>所在部门</td>
 <td>
 <select name="departmentId" style="width:100%">
	 <c:forEach items="${edList }" var="ed">
	 	<option value="${ed.departmentId }" <c:if test="${ed.departmentId==erpsysJob.departmentId }">selected="selected"</c:if> >${ed.departmentName }</option>
	 </c:forEach>
 </select>
 </td>
 </tr>

 <td colspan="2" align="center"><input class="btn btn-success" type="submit" value="修改"/> <a class="btn btn-warning" href="ErpsysJob/main3">返回</a></td>
 </tr>
 </table>
</form>