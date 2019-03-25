<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>增加页面</h1>
			<hr>
		</div>
		<form action="IncreaseOrder" method="post" id="formx" onsubmit="return check()">
			<table class="table table-bordered" align="center">

				<tbody align="center">
					<tr>
						<td>销售方：</td>
						<td><input type="text" name="seller" id="seller"
							placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>购买方：</td>
						<td><input type="text" name="buyer" id="buyer"
							placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>订单时间：</td>
						<td><input type="date" name="orderTime" id="orderTime"
							placeholder="信息不能为空" style="width: 200px"></td>
					</tr>
					<tr>
						<td>订单地点：</td>
						<td><input type="text" name="orderLocahost"
							id="orderLocahost" placeholder="信息不能为空"></td>

					</tr>
					<tr>
						<td>订单类型：</td>
						<td><select id="orderType" name="orderType" class="form-control" style="width: 200px">
								<option value="0">销售订单</option>
								<option value="1">采购订单</option>
						</select></td>

					</tr>
					<tr>
						<td>商品单价：</td>
						<td><input type="text" name="productUnitPrice"
							id="productUnitPrice" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>商品总价：</td>
						<td><input type="text" name="productionTotalPrice"
							id="productionTotalPrice" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>商品名称：</td>
						<td><input type="text" name="productionName"
							id="productionName" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>商品数量：</td>
						<td><input type="text" name="productionNumber"
							id="productionNumber" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>规格型号：</td>
						<td><input type="text" name="productionType"
							id="productionType" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>产品库存编号：</td>
						<td><input type="text" name="productionWarehouseId"
							id="productionWarehouseId" placeholder="信息不能为空"></td>
					</tr>
					<tr>
						<td>订单审核状态：</td>
						<td><select id="orderAuditStatus" name="orderAuditStatus"
							class="form-control" style="width: 200px">
								<option value="0">已审核</option>
								<option value="1">未审核</option>
						</select></td>

					</tr>
				</tbody>
			</table>
			<button onclick="myCheck" type="submit" value="提交"
				class="btn btn-default">提交</button>
			<a href="queryAlltOrder" class="btn btn-default">退出</a>
		</form>
	</div>
</body>
<script type="text/javascript">
	function check(){
		
		var inputId=document.getElementById("seller").value;
		if(inputId){
			return true;
		}else{
			alert("请输入销售方");
			return false;
		}
		var inputId1=document.getElementById("buyer").value;
		if(inputId1){
			return true;
		}else{
			alert("请输入购买方");
			return false;
		}
		var inputId2=document.getElementById("orderTime").value;
		if(inputId2){
			return true;
		}else{
			alert("请输入订单时间");
			return false;
		}
		var inputId=document.getElementById("orderLocahost").value;
		if(inputId){
			return true;
		}else{
			alert("请输入订单地点");
			return false;
		}
		var inputId=document.getElementById("orderType").value;
		if(inputId){
			return true;
		}else{
			alert("请输入订单类型");
			return false;
		}
		var inputId=document.getElementById("productUnitPrice").value;
		if(inputId){
			return true;
		}else{
			alert("请输入商品单价");
			return false;
		}
		var inputId=document.getElementById("productionTotalPrice").value;
		if(inputId){
			return true;
		}else{
			alert("请输入商品总价");
			return false;
		}
		
		var inputId=document.getElementById("productionName").value;
		if(inputId){
			return true;
		}else{
			alert("请输入商品名称");
			return false;
		}
		var inputId=document.getElementById("productionNumber").value;
		if(inputId){
			return true;
		}else{
			alert("请输入商品数量");
			return false;
		}
		var inputId=document.getElementById("productionType").value;
		if(inputId){
			return true;
		}else{
			alert("请输入规格型号");
			return false;
		}
		var inputId=document.getElementById("productionWarehouseId").value;
		if(inputId){
			return true;
		}else{
			alert("请输入产品库存编号");
			return false;
		}
		var inputId=document.getElementById("orderAuditStatus").value;
		if(inputId){
			return true;
		}else{
			alert("请输入订单审核状态");
			return false;
		}
	}

	
</script>

</html>

