<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=basePath%>style/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=basePath%>style/css/timepicker/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/timepicker/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/timepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<body>
	<div
		style="position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0; width: 90%; height: 90%;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">应收账务名称<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control NotNull" placeholder="应收账务名称"
						id="accountsReceivableName" value="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">应收账务金额<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control NotNull" placeholder="应收账务金额"
						id="accountsReceivableMoney" value="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">应付款方<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control NotNull" placeholder="应付款方"
						id="accountsPayer" value="">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">账务记录时间<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<!--作为组件使用-->
					<div class="input-append date" id="datetimepicker1"
						data-date-format="yyyy-mm-dd hh:ii:ss">
						<input type="text" class="form-control NotNull" value="${NowDatetime }"
							id="accountsRecordTimeString" readonly> <span
							class="add-on"><i data-date-icon="icon-calendar"
							class="icon-calendar"></i></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">是否已收账<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<select id="alreadyReceived" class="form-control NotNull">
						<option value="1">已收账</option>
						<option value="0" selected = "selected">未收账</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">到账时间</label>
				<div class="col-sm-10">
					<!--作为组件使用-->
					<div class="input-append date" id="datetimepicker2"
						data-date-format="yyyy-mm-dd hh:ii:ss">
						<input type="text" class="form-control" value=""
							id="paymentTimeString" readonly> <span class="add-on"><i
							data-date-icon="icon-calendar" class="icon-calendar"></i></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="" style="text-align: center">
					<button type="button" class="btn btn-success"
						onclick="submitInsert()" style="width: 46%">
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
		$(function() {
			$('#datetimepicker1 ').datetimepicker({
				language : "zh-CN",
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				pickerPosition : 'top-right'
			});
			$('#datetimepicker2').datetimepicker({
				language : "zh-CN",
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				keyboardNavigation : true,
				pickerPosition : 'top-right'
			});
		})
		function submitInsert() {
			if (hasNotNull() == true){
				$
						.ajax({
							url : "insertAccountsReceivableSubmit",
							type : "post",
							dataType : "text",
							contentType : "application/x-www-form-urlencoded;charset=utf-8",
							data : {
								accountsReceivableId : $("#accountsReceivableId")
										.val(),
								accountsReceivableName : $("#accountsReceivableName")
										.val(),
								accountsReceivableMoney : $(
										"#accountsReceivableMoney").val(),
								accountsPayer : $("#accountsPayer").val(),
								accountsRecordTimeString : $(
										"#accountsRecordTimeString").val(),
								alreadyReceived : $("#alreadyReceived").val(),
								paymentTimeString : $("#paymentTimeString").val(),
							// 					accountsReceivableTimeString : $("#accountsReceivableTimeString").val()
							},
							success : function(result) {
								// 					alert(result);
								if (result == "SUCCESS") {
									parent.parent.showMessage("插入账单成功！")
									parent.window.location.href = "financialManagementAccountsReceivable?pageEnd=yes"
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
			}
			else{//如果有空值则提示有东西没输入
				parent.layer.open({
					  title: '温馨提示'
					  ,content: '除到账时间以外,表单不能留空哦~'
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
				if (v != null && v != ""){
					//不为空则什么都不做
				}else{
					//只要有一个为空，则返回一个false;
					hasNN = false;
				}
			});
			return hasNN;
		}
	</script>
</body>
</html>