<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h1>修改页面</h1>
	<hr>
		<form action="<%=basePath%>update/updateproductmaterialdate2" method="post"
		enctype="multipart/form-data">
			<table>
				<tr>
					<td>产品库存编号：</td>
					<td><input type="text" name="production_warehouse_id" value="${erpsysProductMaterialConsume.productionWarehouseId}"></td>
				</tr>
				<tr>
					<td>产品名称：</td>
					<td><input type="text" name="product_name" value="${erpsysProductMaterialConsume.productName}"></td>
				</tr>
				<tr>
					<td>产品数量：</td>
					<td><input type="text" name="product_number" value="${erpsysProductMaterialConsume.productNumber}"></td>
				</tr>
				<tr>
					<td>产品规格：</td>
					<td><input type="text" name="product_type" value="${erpsysProductMaterialConsume.productType}"></td>
				</tr><tr>
					<td>产品库存编号：</td>
					<td><input type="text" name="production_warehouse_id" value="${erpsysProductMaterialConsume.productionWarehouseId}"></td>
				</tr>
				<tr>
					<td><input type="submit"  value="修改"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>