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
<link rel="stylesheet" href="<%=basePath%>style/lib/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>style/css/cutsom-style.css">
<link rel="stylesheet" href="<%=basePath%>style/css/kkpager_hth.css">
<script src="<%=basePath%>style/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>style/js/kkpager.min.js"></script>

<body>
	<!-- 隐藏域 -->
	<input id="pageNo" type="hidden" value="${pageNo }">
	<!-- end 隐藏域 -->
	<div id="" style="">
		<form class="form-inline">
			<button type="button" class="btn btn-success"
				onclick="show('增加新账单','<%=basePath%>insertAccountsReceivable',400,580)">
				<span class="glyphicon glyphicon-plus"></span> 增加新账单
			</button>
			<button type="button" class="btn btn-danger" onclick="PLDelete()">
				<span class="glyphicon glyphicon-minus"></span> 删除选中账单
			</button>
			<div class="form-group">
				<p class="form-control-static">账务名称:</p>
			</div>
			<div class="form-group">
				<input style="width: 8em;" type="text" class="form-control"
					id="searchAccountsReceivableName" name="searchAccountsReceivableName" placeholder="账务名称" value="${searchAccountsReceivableName }">
			</div>
			<div class="form-group">
				<p class="form-control-static">应收款方:</p>
			</div>
			<div class="form-group">
				<input style="width: 8em;" type="text" class="form-control"
					id="searchName" name="searchName" placeholder="应收款方姓名" value="${searchName }">
			</div>
			<button type="button" class="btn btn-default" onclick="doSearchName()">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

			<table class="table table-hover" style="text-align: center;">
				<tr style="font-weight: bold;">
					<td>#</td>
					<td>应收账务编号</td>
					<td>应收账务名称</td>
					<td>应收账务金额</td>
					<td>应收款方</td>
					<td>账务记录时间</td>
					<td>是否已收账</td>
					<td>到账时间</td>
					<td>操作</td>
				</tr>
				<tbody>
					<c:forEach items="${erpsysAccountsReceivableList }"
						var="accountsReceivables">
						<tr id="accountsReceivable${accountsReceivables.accountsReceivableId }">
							<td><input type="checkbox" name="checks[]"
								id="${accountsReceivables.accountsReceivableId }"
								value="${accountsReceivables.accountsReceivableId }" /></td>
							<td>${accountsReceivables.accountsReceivableId }</td>
							<td>${accountsReceivables.accountsReceivableName }</td>
							<td>${accountsReceivables.accountsReceivableMoney }</td>
							<td>${accountsReceivables.accountsPayer }</td>
							<td>${accountsReceivables.accountsRecordTimeString }</td>
							<td><c:choose>
									<c:when test="${accountsReceivables.alreadyReceived==1 }">
										<span style="color: green;">已收账</span>
									</c:when>
									<c:otherwise>
										<span style="color: red;">未收账</span>
									</c:otherwise>
								</c:choose></td>
							<td>${accountsReceivables.paymentTimeString }</td>
							<td>
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default btn-sm"
										onclick="show('应收账务单管理','<%=basePath%>editAccountsReceivable?accountsReceivableId=${accountsReceivables.accountsReceivableId }','400','650')">
										<span class="glyphicon glyphicon-pencil"></span> 编辑
									</button>
									<button type="button" class="btn btn-danger btn-sm"
										onclick="del(${accountsReceivables.accountsReceivableId })">
										<span class="glyphicon glyphicon-remove"></span> 删除
									</button>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr id="kkpagerLine">
						<!-- kkpager -->
						<td colspan="9" style="height: 50px">
							<div class="btn-group" role="group" style="float: left;">
								<button type="button" id="checkall"
									onclick="checkallInput('checkall')" class="btn btn-default">
									<span class="glyphicon glyphicon-ok-circle"></span> 全选
								</button>
								<button type="button" id="unCheckall"
									onclick="checkallInput('unCheckall')" class="btn btn-default">
									<span class="glyphicon glyphicon-ban-circle"></span> 全不选
								</button>
								<button type="button" id="reversedCheck"
									onclick="checkallInput('reversedCheck')"
									class="btn btn-default">
									<span class="glyphicon glyphicon-retweet"></span> 反选
								</button>
							</div>
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
	var layer;
	$(function(){//页面初始化
		layui.use('layer', function() {
			layer = layui.layer;
		});
		var warning = "${warning }";
		if(warning!=""){
			alert(warning);
		}
	});
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
                flushPage();
                return false;
            }
        });
    });
	function checkallInput(type){//全选、取消全选、反选
		if (type == "checkall") {
			$("input[name='checks[]']").each(function() {
				this.checked = true;
			});
		} else if (type == "unCheckall") {
			$("input[name='checks[]']").each(function() {
				this.checked = false;
			});
		} else if (type == "reversedCheck") {
			$("input[name='checks[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		}
	}
	function show(title, url, w, h) {//弹出层
			layer.open({
				type : 2,
				area : [ w + 'px', h + 'px' ],
				fix : false, //不固定
				shadeClose : true,
				shade : 0.4,
				title : title,
				content : url,
				cancel: function(indexp, layero){ 
					//只有当点击confirm框的确定时，该层才会关闭
					layer.confirm('确定要关闭窗口吗？', {icon: 3, title:'提示'}, function(index){
						 layer.close(index);//关闭询问框
						 layer.close(indexp);//关闭窗口
						});
					  return false; 
				}
			});
	}
	function doSearchName(){//简单判断查询money的值是否符合要求，并拼接域名发往后台，不用ajax是为了刷新页面的时候，继续停留在当前页
			var searchName = $("#searchName").val();
			var searchAccountsReceivableName = $("#searchAccountsReceivableName").val();
			window.location.href="<%=basePath%>financialManagementAccountsReceivable?searchName="+searchName+"&searchAccountsReceivableName="+searchAccountsReceivableName;
	}
	//弹出窗口调用该方法来改变表格中的值,从而不用刷新页面
	function changeTable(accountsReceivableId,accountsReceivableName,accountsReceivableMoney,accountsPayer,accountsRecordTimeString,alreadyReceived,paymentTimeString){
		//修改当前行应收账务名称
		$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(2).text(accountsReceivableName)
		//修改当前行应收账务金额
		$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(3).text(accountsReceivableMoney)
		//修改当前行应收款方
		$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(4).text(accountsPayer)
		//修改当前行账务记录时间
		$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(5).text(accountsRecordTimeString)
		//修改当前行是否已收账
		//修改并赋予颜色
		if(alreadyReceived=="已收账"){
			$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(6).html('<span style="color: green;">'+alreadyReceived+'</span>')
		}else{
			$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(6).html('<span style="color: red;">'+alreadyReceived+'</span>')
		}
		//修改当前行出账时间
		$("#accountsReceivable"+accountsReceivableId+"").find("td").eq(7).text(paymentTimeString)
		parent.showMessage('账单修改成功！')
	}
	function showMessage(message){
		layer.msg(message, {
			  icon: 1,
			  time: 1500
			}, function(){
			  //可调用函数
			});
	}
	function del(id){//单个删除，不多赘述
		layer.confirm('确定要删除编号为'+id+'的应收账务单吗？', {icon: 3, title:'提示'}, function(index){
			$.ajax({
				url : "deleteAccountsReceivableSubmit",
				type : "post",
				dataType : "text",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : {
					accountsReceivableId : id
				},
				success : function(result) {
					// 					alert(result);
					if (result == "SUCCESS") {
						parent.showMessage('账单删除成功！')
						flushPage();
					}else{
						parent.showMessage("删除数据失败！请联系管理员！");
					}
				},
				fail : function(){
					parent.showMessage("无法连接服务器！");
				}
			});
			 layer.close(index);//关闭询问框
			});
	}
	//刷新当前页面
	function flushPage(){
		var href = window.location.href;//获取完整url
		var protocol = window.location.protocol;//获取url协议部分
		var searchName = $("#searchName").val();
		var searchAccountsReceivableName = $("#searchAccountsReceivableName").val();
		var pageNo = $("#pageNo").val();
		if((searchName == null || searchName == "" )&&((searchAccountsReceivableName == null || searchAccountsReceivableName == "" ))){//拼接url
			window.location.href = protocol + "?pageNo=" + pageNo;
		}else{
			window.location.href = href + "&pageNo=" + pageNo;
		}
		
	}
	//批量删除
	function PLDelete(){
		var ids = [];//声明一个空数组
		$("input[name='checks[]']").each(function() {//循环将已经勾选复选框的条目的value装进数组中,index为当前循环的索引
			if(this.checked==true){
				ids.push($(this).val());
			}
		});
		if(ids.length!=0){//非空则把该数组ajax发送到后台进行批量删除
			layer.confirm('确定要删除选中的应收账务单吗？', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					url : "PLdeleteAccountsReceivableSubmit",
					type : "post",
					dataType : "text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					traditional:true,//ajax传入数组，必须写
					data : {
						"accountsReceivableIds" : ids
					},
					success : function(result) {
						if (result == "SUCCESS") {
							parent.showMessage('账单删除成功！')
							flushPage();
						}else{
							parent.showMessage("删除数据失败！请联系管理员！");
						}
					},
					fail : function(){
						parent.showMessage("无法连接服务器！");
					}
				});
				 layer.close(index);//关闭询问框
			});
		}else{
			parent.layer.alert('没有选中任何账单信息！'); 
		}
	}
	
	
	
// 	//获取url字符串
// 	function getRequest() {   
// 	   var url = location.search; //获取url中"?"符后的字串   
// 	   var theRequest = new Object();   
// 	   if (url.indexOf("?") != -1) {   
// 	      var str = url.substr(1);   
// 	      strs = str.split("&");   
// 	      for(var i = 0; i < strs.length; i ++) {   
// 	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
// 	      }   
// 	   }   
// 	   return theRequest;
// 	}   

	</script>





</html>