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
<body>
	<div id="background"
		style="width: 99%; height: 98%; position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0;">
		<a href="addEJ" class="btn btn-warning">增加职位信息</a>
		<table class="table table-bordered"
			style="text-align: center; position: relative; margin: auto; top: 10px;">
			<tr>
				<th>职位编号</th>
				<th>职位名字</th>
				<th>所在部门</th>
				<th colspan="2">操作</th>
			</tr>

			<c:forEach items="${erpsysJobs}" var="erpsysJob">
				<tr>
					<td>${erpsysJob.jobId}</td>
					<td>${erpsysJob.jobName}</td>
					<td>
						<c:forEach items="${edList }" var="ed">
							<c:if test="${ed.departmentId==erpsysJob.departmentId }">
								${ed.departmentName }
							</c:if>
						</c:forEach>
					</td>
					<td><a href="modifyEJ?jobId=${erpsysJob.jobId}"><input
							type="button" class="btn btn-info" value="修改" /></a></td>
					<td><a href="deleteEJK?jobId=${erpsysJob.jobId}"><input
							type="button" class="btn btn-info" value="删除" /></a></td>
				</tr>
			</c:forEach>

		</table>
		<div id="kkpager"
			style="text-align: center; position: relative; margin: auto; top: 20px; width: 40%;"></div>
	</div>
</body>
<!-- 引入Kkpager资源 -->
<script type="text/javascript"
	src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/kkpager.min.js"></script>
<script type="text/javascript">
//生成分页控件  
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
		window.location.href = "<%=basePath%>ErpsysJob/main3?pageNo=" + n;
			//处理完后可以手动条用selectPage进行页码选中切换
			// 		this.selectPage(n);
		},
		//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
		getHref : function(n) {
			return '#';
		}

	});
</script>
</html>