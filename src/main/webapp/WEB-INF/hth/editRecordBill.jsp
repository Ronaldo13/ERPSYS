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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=basePath%>style/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<body>
	<div
		style="position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0; width: 90%; height: 90%;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">入账账单编号<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control notNull" placeholder="入账账单编号"
						id="recordId" value="${record.recordId }" disabled>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">入账金额<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="number" class="form-control" placeholder="入账金额"
						id="recordMoney" value="${record.recordMoney }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">入账原因<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control notNull" placeholder="入账原因"
						id="recordReason" value="${record.recordReason }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">入账时间<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control notNull" placeholder="入账时间"
						id="recordTimeString" value="${record.recordTimeString }" disabled>
				</div>
			</div>
			<div class="form-group">
				<div class="" style="text-align: center">
					<button type="button" class="btn btn-success"
						onclick="submitChange()" style="width: 46%">
						<span class="glyphicon glyphicon-ok"></span> 提交更改
					</button>
					<button type="button" class="btn btn-danger "
						onclick="closePage();" style="width: 46%">
						<span class="glyphicon glyphicon-remove-sign"></span> 取消
					</button>
				</div>
			</div>
			<span id="message" style="color: red;">${message }</span>
		</form>
	</div>
	<script type="text/javascript">
		function submitChange() {
			if (hasNotNull() == true) {
				$
						.ajax({
							url : "editRecordBillSubmit",
							type : "post",
							dataType : "text",
							contentType : "application/x-www-form-urlencoded;charset=utf-8",
							data : {
								recordId : $("#recordId").val(),
								recordMoney : $("#recordMoney").val(),
								recordReason : $("#recordReason").val(),
							// 					recordTimeString : $("#recordTimeString").val()
							},
							success : function(result) {
								// 					alert(result);
								if (result == "SUCCESS") {
									var recordId = $("#recordId").val();
									var recordMoney = $("#recordMoney").val();
									var recordReason = $("#recordReason").val();
									// 						alert("修改成功！")
									//当你在iframe页面关闭自身时
									parent.changeTable(recordId, recordMoney,
											recordReason);
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭 
								} else {
									parent.showMessage("修改数据失败！请联系管理员！");
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭 
								}
							},
							fail : function() {
								parent.showMessage("无法连接服务器！");
								var index = parent.layer
										.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭 
							}
						});
			} else {//如果有空值则提示有东西没输入
				parent.layer.open({
					title : '温馨提示',
					content : '除出账时间以外,表单不能留空哦~'
				});
			}
		}
		function closePage() {
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭 
		}
		function hasNotNull() {
			var hasNN = true;//声明一个全局变量用于返回一个值
			$(".NotNull").each(function() {
				var v = this.value;
				if (v != null && v != "") {
					//不为空则什么都不做
				} else {
					//只要有一个为空，则返回一个false;
					hasNN = false;
				}
			});
			return hasNN;
		}
	</script>
</body>
</html>