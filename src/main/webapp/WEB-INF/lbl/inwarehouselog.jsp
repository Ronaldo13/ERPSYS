<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table">
		<tr>
			<th>入库时间</th>
			<th>入库原因</th>
			<th>入库数量</th>
		</tr>
		<tr>
			<td>${iwhm.inWarehouseTime}</td>
			<td>${iwhm.inWarehouseReason}</td>
			<td>${iwhm.inWarehouseNumber}</td>
		</tr>
	</table>
	<a href="doProductMaterialSreach" class="btn btn-default">返回</a>
</body>
</html>