<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>style/css/kkpager_orange.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<style>
th {
	text-align: center;
}
</style>
<body>
	<div id="background"
		style="width: 99%; height: 98%; position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0;">
		<a href="addEBI" class="btn btn-warning">增加人员信息</a> <span
			style="color: red;">${warning }</span>
			
		<table class="table table-bordered" style="text-align: center;position:relative; margin: auto;top: 10px;">

			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>

				<th>入职时间</th>
				<th>学历</th>
				<th>电话号码</th>
				<th>身份证号码</th>
				<th>家庭住址</th>
				<th>电子邮箱</th>
				<th>部门名称</th>
				<th>职位名称</th>
				<th>帐号状态</th>
				<th colspan="2">操作</th>
			</tr>

			<c:forEach items="${erpsysBasicInformationsList}"
				var="erpsysBasicInformations">
				<tr>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountId }</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountName}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountSex}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountEntryTimeString}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountEduLevel}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountPhone}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountIdcard }
					</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountAddress}</td>
					<td>${erpsysBasicInformations.erpsysBasicInformation.accountEmail }</td>
					<td>${erpsysBasicInformations.erpsysDepartment.departmentName }</td>
					<td>${erpsysBasicInformations.erpsysJob.jobName}</td>
					<td><c:if
							test="${erpsysBasicInformations.erpsysBasicInformation.accountStatus==1 }">正常</c:if>
						<c:if
							test="${erpsysBasicInformations.erpsysBasicInformation.accountStatus==0 }">封禁</c:if></td>
					<td><a
						href="modifyEBI?accountId=${erpsysBasicInformations.erpsysBasicInformation.accountId }"><input
							type="button" class="btn btn-info" value="修改" /></a>
						<button class="btn btn-danger" type="button"
							onclick="deleteAccount('${erpsysBasicInformations.erpsysBasicInformation.accountId }')">删除</button></td>
				</tr>
			</c:forEach>
		</table>
		<div id="kkpager" style="text-align: center;position:relative; margin: auto;top: 20px;width:40%;" ></div>

	</div>

</body>
<!-- 引入Kkpager资源 -->
<script type="text/javascript"
	src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/kkpager.min.js"></script>
<script>
	
	$(function() {
		kkpager.generPageHtml({
			//当前页码
			pno : '${pageNo}',
			mode : 'click', //设置为click模式
			//总页码  
			total : '${totalPage}',  
			//总数据条数  
			totalRecords : '${totalRecords}',
			//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
			//适用于不刷新页面，比如ajax
			click : function(n){
				//这里可以做自已的处理
				window.location.href = "<%=basePath%>ErpsysBasicInformation/main1?pageNo="+ n;
						//处理完后可以手动条用selectPage进行页码选中切换
						// 		this.selectPage(n);
					},
					//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
					getHref : function(n) {
						return '#';
					}

				});
	})
	function deleteAccount(id) {
		if (confirm("要删除id为" + id + "的员工信息吗？"))
			window.location.href = "deleteEBIk?accountId=" + id;
	}
</script>
</html>