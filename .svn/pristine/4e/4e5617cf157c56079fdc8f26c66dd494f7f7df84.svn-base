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
<link rel="stylesheet" href="<%=basePath%>style/css/timepicker/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>style/js/timepicker/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=basePath%>style/js/timepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<body>
	<div
		style="position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0; width: 90%; height: 90%;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">入账金额<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="number" class="form-control NotNull" placeholder="入账金额"
						id="recordMoney" value="${record.recordMoney }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">入账原因<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<input type="text" class="form-control NotNull" placeholder="入账原因"
						id="recordReason" value="${record.recordReason }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">入账时间<span style="color:red;"> *</span></label>
				<div class="col-sm-10">
					<!--作为组件使用-->
					<div class="input-append date" id="datetimepicker"
						data-date-format="yyyy-mm-dd hh:ii:ss">
						<input type="text" class="form-control" value="${NowDatetime }" id="recordTimeString"
							readonly> <span class="add-on"><i
							data-date-icon="icon-calendar" class="icon-calendar"></i></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="" style="text-align: center">
					<button type="button" class="btn btn-success"
						onclick="submitInsert()" style="width: 46%">
						<span class="glyphicon glyphicon-ok"></span> 提交
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
			$('#datetimepicker').datetimepicker({
				language : "zh-CN",
				weekStart: 1,
	            todayBtn: 1,
	            autoclose: 1,
	            todayHighlight: 1,
	            keyboardNavigation: true,
			});
		})
		function submitInsert() {
			if (hasNotNull()){//先判断是否有需要填写的input没有填写
			$.ajax({
						url : "insertRecordBillSubmit",
						type : "post",
						dataType : "text",
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						data : {
							recordId : $("#recordId").val(),
							recordMoney : $("#recordMoney").val(),
							recordReason : $("#recordReason").val(),
							recordTimeString: $("#recordTimeString").val()
						// 					recordTimeString : $("#recordTimeString").val()
						},
						success : function(result) {
							// 					alert(result);
							if (result == "SUCCESS") {
								parent.parent.showMessage("插入账单成功！")
								parent.window.location.href = "financialManagementRecordBill?pageEnd=yes"
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭 
							}else{
								parent.showMessage("增加数据失败！请联系管理员！");
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭 
							}
						},
						fail : function(){
							parent.showMessage("无法连接服务器！");
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭 
						}
					});
			}else{//如果有空值则提示有东西没输入
				parent.layer.open({
					  title: '温馨提示'
					  ,content: '表单不能留空哦~'
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