<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>" />
<script src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>style/lib/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>style/css/kkpager_orange.css">
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="<%=basePath%>style/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/kkpager.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<button type="button" class="btn btn-info" id="checkll"
		onclick="checkall()">全选</button>
	<table class="table table-bordered table-hover">
		<tr>

			<td>选择项</td>
			<td>日志编号</td>
			<td>产品库存编号</td>
			<td>出库时间</td>
			<td>出库原因</td>
			<td>出库数量</td>
			<td>订单编号</td>
			<td>出库状态</td>
		</tr>

		<c:forEach items="${inWareHouseModels}" var="inWareHouseModels">
			<tr id="warelist${inWareHouseModels.outWarehouseLogId}">
				<td><input class="ckc" type="checkbox"
					id="${inWareHouseModels.outWarehouseLogId}" name="check"
					value="${inWareHouseModels.outWarehouseLogId }"></td>
				<td>${inWareHouseModels.outWarehouseLogId }</td>
				<td>${inWareHouseModels.productionWarehouseId }</td>
				<td>${inWareHouseModels.outWarehouseTime }</td>
				<td>${inWareHouseModels.outWarehouseReason }</td>
				<td>${inWareHouseModels.outWarehouseNumber }</td>
				<td>${inWareHouseModels.orderId }</td>
				<td>${inWareHouseModels.outWarehouseStatus }</td>
			</tr>
		</c:forEach>

	</table>
	<div align="center" style="width: 100%;" id="kkpager"></div>
</body>

<script>
	var c = false;
	function checkall() {
		if (c) {
			$(".ckc").prop("checked", false);
			c = false;
		} else {
			$(".ckc").prop("checked", true);
			c = true;
		}
	}
	//var a=1;
	//reallydelete(a)
	//init
	$(function() {
		var page = ${pageNo}
		var totalInventory = ${totalInventory}
		var totalPage = Math.ceil(totalInventory / 5)
		//生成分页
		//有些参数是可选的，比如lang，若不传有默认值
		kkpager.generPageHtml({
			pno : page,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalInventory,
			mode : 'click',//默认值是link，可选link或者click
			click : function(n) {
				// do something
				//手动选中按钮
				window.location.href = "ware/getAlloutware?pageNo=" + n;
				this.selectPage(n);
				return false;
			}
		});
	});
</script>
</html>