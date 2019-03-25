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
<script src="<%=basePath%>style/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>style/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>style/css/cutsom-style.css">
<link rel="stylesheet" href="<%=basePath%>style/css/kkpager_hth.css">
<script type="text/javascript"
	src="<%=basePath%>style/js/kkpager.min.js"></script>

<body>
	<!-- 隐藏域 -->
	<input id="pageNo" type="hidden" value="${pageNo }">
	<!-- end 隐藏域 -->
	<div id="" style="">
		<form class="form-inline" style="text-align: center;">
			<div class="form-group">
				<p class="form-control-static" style="font-weight: bolder; font-size: 1.5em">根据条件筛选：</p>
			</div>
			<div class="form-group">
				<select class="form-control" id="operationType" name="operationType">
					<option value="">所有操作</option>
					<option value="新增" <c:if test="${operationType=='新增' }"> selected="selected"</c:if>>新增</option>
					<option value="删除" <c:if test="${operationType=='删除' }"> selected="selected"</c:if>>删除</option>
					<option value="修改" <c:if test="${operationType=='修改' }"> selected="selected"</c:if>>修改</option>
				</select>
			</div>
			<div class="form-group">
				<select class="form-control" id="billType" name="billType">
					<option value="">所有账单</option>
					<option value="入账账单" <c:if test="${billType=='入账账单' }"> selected="selected"</c:if>>入账账单</option>
					<option value="出账账单" <c:if test="${billType=='出账账单' }"> selected="selected"</c:if>>出账账单</option>
					<option value="应收账单" <c:if test="${billType=='应收账单' }"> selected="selected"</c:if>>应收账单</option>
					<option value="应出账单" <c:if test="${billType=='应出账单' }"> selected="selected"</c:if>>应出账单</option>
				</select>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<input style="width: 8em;" type="text" class="form-control" -->
<!-- 					id="billId" name="billId" placeholder="账单id" -->
<%-- 					value="${billId }"> --%>
<!-- 			</div> -->
			<div class="form-group">
				<input style="width: 8em;" type="text" class="form-control"
					id="accountId" name="accountId" placeholder="操作人员id"
					value="${accountId }">
			</div>
			<button type="button" class="btn btn-default" onclick="searchLog()">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

			<table class="table table-hover" style="text-align: center;">
				<tr style="font-weight: bold;">
					<td>财务日志编号</td>
					<td>操作</td>
					<td>操作人员id</td>
					<td>操作时间</td>
				</tr>
				<tbody>
					<c:forEach items="${erpsysFinanceLogList }" var="erpsysFinanceLog">
						<tr id="record${erpsysFinanceLog.financeLogId }">
							<td>${erpsysFinanceLog.financeLogId }</td>
							<td>${erpsysFinanceLog.operation }</td>
							<td>${erpsysFinanceLog.accountId }</td>
							<td>${erpsysFinanceLog.operationTimeString }</td>
						</tr>
					</c:forEach>
					<tr id="kkpagerLine">
						<!-- kkpager -->
						<td colspan="4" style="height: 50px">
							<div id="kkpager"
								style="width: 40%; position: absolute; margin: auto; left: 0; right: 0;">

							</div>

						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
<script>
	/* kkpager */
	$(function(){
		var pageNo = ${pageNo};
		var totalRecords = ${totalRecords};
		var pageSize = ${pageSize};
        var totalPage = Math.ceil(totalRecords/pageSize);
        kkpager.generPageHtml({
            pno : pageNo,//当前页码
            total : totalPage,//总页码
            totalRecords : totalRecords,//总数据条数
            mode : 'click',//默认值是link，可选link或者click
            click : function(pageNo){
                this.selectPage(pageNo);
                $("#pageNo").val(pageNo);
                var operationType = $("#operationType").val();
                var billType = $("#billType").val();
                var accountId = $("#accountId").val();
                window.location.href = "financialManagementLog?pageNo="+pageNo+"&operationType="+operationType+"&billType="+billType+"&accountId="+accountId
                return false;
            }
        });
    });
	function searchLog(){//简单判断查询的值是否符合要求，并拼接域名发往后台，不用ajax是为了刷新页面的时候，继续停留在当前页
		var operationType = $("#operationType").val();
        var billType = $("#billType").val();
        var accountId = $("#accountId").val();
        window.location.href = "financialManagementLog?pageNo=1&operationType="+operationType+"&billType="+billType+"&accountId="+accountId
	}
	function showMessage(message){
		layer.msg(message, {
			  icon: 1,
			  time: 1500
			}, function(){
			  //可调用函数
			});
	}
</script>

</html>