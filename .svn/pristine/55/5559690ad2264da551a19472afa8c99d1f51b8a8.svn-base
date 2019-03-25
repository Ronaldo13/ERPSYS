<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Bootstrap 实例 - 一个简单的网页</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>

	<table class="table table-bordered">
		
		<thead>
			<tr>
				<th>销售日志编号</th>
				<th>购买方</th>
				<th>销售时间</th>
				<th>销售数量</th>
				<th>产品库存编号</th>
				<th>订单编号</th>
				
				<th>查询</th>

				<th>删除</th>

			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${ErpsysSellLog }" var="ErpsysSellLog">
				<tr>
					<td>${ErpsysSellLog.sellLogId}</td>
					<td>${ErpsysSellLog.buyer}</td>
					<td>${ErpsysSellLog.sellTime}</td>
					<td>${ErpsysSellLog.sellNumber}</td>
					<td>${ErpsysSellLog.outWarehouseLogId}</td>
					<td>${ErpsysSellLog.orderId}</td>
					
					<td><a class="button border-red"
						href="querySellOrderByOrderId?orderId=${ErpsysSellLog.orderId}"> <span
							class="icon-trash-o"></span>查询
					</a></td>
					<td><a class="button border-red"
						href="deleteSellOrderByBuyLogId?sellLogId=${ErpsysSellLog.sellLogId}"> <span
							class="icon-trash-o"></span>删除
					</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>

</html>


