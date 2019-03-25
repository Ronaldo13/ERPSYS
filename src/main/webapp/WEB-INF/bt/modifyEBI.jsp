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
<title>人员信息修改</title>
</head>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>


	<form action="ErpsysBasicInformation/modifyEBIk" method="get">
		<table align="center" class="table" style="width: 50%">
			<tr>
				<td style="width: 20%">员工编号</td>
				<td><input style="width: 100%" type="text" name="accountId"
					value="${erpsysBasicInformation.accountId}" /></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input style="width: 100%" type="text" name="accountName"
					value="${erpsysBasicInformation.accountName}" /></td>
			</tr>
			<tr>
				<td>员工性别</td>
				<td><input style="width: 100%" type="text" name="accountSex"
					value="${erpsysBasicInformation.accountSex}" /></td>
			</tr>
			<tr>
				<td>入职时间</td>
				<td><input style="width: 100%" type="text"
					name="accountEntryTimeString"
					placeholder="时间格式例如  :2018-09-11 13:55:55"
					value="${erpsysBasicInformation.accountEntryTimeString}" /></td>
			</tr>
			<tr>
				<td>学历</td>
				<td><input style="width: 100%" type="text"
					name="accountEduLevel"
					value="${erpsysBasicInformation.accountEduLevel }" /></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input style="width: 100%" type="text" name="accountPhone"
					value="${erpsysBasicInformation.accountPhone}" /></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input style="width: 100%" type="text" name="accountIdcard"
					value="${erpsysBasicInformation.accountIdcard}" /></td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td><input style="width: 100%" type="text"
					name="accountAddress"
					value="${erpsysBasicInformation.accountAddress}" /></td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td><input style="width: 100%" type="text" name="accountEmail"
					value="${erpsysBasicInformation.accountEmail}" /></td>
			</tr>
			<tr>
				<td>职位名称</td>
				<td><select name="accountJobId"
					style="width: 100%; height: 30px;">
						<c:forEach items="${jobList }" var="job">
							<option value="${job.jobId }"
								<c:if test="${erpsysBasicInformation.accountJobId==job.jobId }">selected="selected"</c:if>>${job.jobName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>帐号状态</td>
				<td><select name="accountStatus"
					style="width: 100%; height: 30px;">
						<option value="1"
							<c:if test="${erpsysBasicInformation.accountStatus==1 }">selected="selected"</c:if>>正常</option>
						<option value="0"
							<c:if test="${erpsysBasicInformation.accountStatus==0 }">selected="selected"</c:if>>封禁</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input class="btn btn-success"
					type="submit" value="修改" /> <a class="btn btn-warning"
					href="ErpsysBasicInformation/main1">返回</a></td>
			</tr>
		</table>
	</form>


</body>
</html>