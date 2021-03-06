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
<head>
<base href="<%=basePath%>" />
<script src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>style/css/bootstrap.min.css">
<head>
<body>
	<div class="form-group">
		<label for="disabledTextInput" class="col-sm-2 control-label">产品库存编号
		</label>
		<div class="col-sm-10">
			<input type="text" id="productionWarehouseId" class="form-control"
				value="${wareHouseModel.productionWarehouseId }" disabled>
		</div>
	</div>
	<div class="form-group has-success">
		<label class="col-sm-2 control-label" for="inputSuccess"> 名称：
		</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="productionName"
				value="${wareHouseModel.productionName}">
		</div>
	</div>
	<div class="form-group has-success">
		<label class="col-sm-2 control-label" for="inputSuccess"> 数量：
		</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="productionNumber"
				value="${wareHouseModel.productionNumber}">
		</div>
	</div>
	<div class="form-group has-success">
		<label class="col-sm-2 control-label" for="inputSuccess">
			规格型号： </label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="productionType"
				value="${wareHouseModel.productionType}">
		</div>
	</div>
	<div style="text-align: center">
		<button type="button" class="btn btn-success" onclick="subchange()">
			提交</button>
		<button type="button" class="btn btn-danger" onclick="closechange()"
			align="right">取消</button>
	</div>
</body>
<script type="text/javascript">
	function closechange() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	}
	function subchange() {
		$.ajax({
			url : "ware/subchange",
			type : "post",
			dataType : "text",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				productionWarehouseId : $("#productionWarehouseId").val(),
				productionName : $("#productionName").val(),
				productionNumber : $("#productionNumber").val(),
				productionType : $("#productionType").val()
			},
			success : function(result) {
				if ("SUCCESS" == result) {
					var productionWarehouseId = $("#productionWarehouseId")
							.val();
					var productionName = $("#productionName").val();
					var productionNumber = $("#productionNumber").val();
					var productionType = $("#productionType").val();
					parent.changetable(productionWarehouseId, productionName,
							productionNumber, productionType);
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭 
				} else {
					parent.showMessage("修改数据失败！请重新修改或请联系管理员！");
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭 						
				}
			},
			fail : function() {
				parent.showMessage("未能修改，服务器出错........")
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭 					
			}
		});
	}
</script>
</html>