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
<title>部门信息修改</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
 <form action="ErpsysDepartment/modifyEDK" method="get">
 <table  align="center" class="table" style="width: 50%">
 <tr>
 <td style="width:20%">部门编号</td>
 <td><input style="width:100%" type="number" name="departmentId" value="${erpsysDepartment.departmentId}"/></td>
 </tr>
 <tr>
 <td>部门名字</td>
 <td><input style="width:100%" type="text" name="departmentName" value="${erpsysDepartment.departmentName}"/></td>
 </tr>
 <tr>
 <td>部门所需权限</td>
 <td><input style="width:100%" type="number" name="departmentAuthorityId" value="${erpsysDepartment.departmentAuthorityId}"/></td>
 </tr>

 <td colspan="2" align="center"><input class="btn btn-success" type="submit" value="修改"/> <a class="btn btn-warning" href="ErpsysDepartment/main2">返回</a></td>
 </tr>
 </table>
</form>

</body>
</html>