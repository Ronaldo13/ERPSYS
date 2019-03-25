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
<script type="text/javascript" src="<%=basePath%>style/js/kkpager.min.js"></script>

<body>
	<!-- 隐藏域 -->
	<input id="pageNo" type="hidden" value="${pageNo }">
	<!-- end 隐藏域 -->
	<div id="" style="">
		<form class="form-inline">
			<button type="button" class="btn btn-success"
				onclick="show('增加新账单','<%=basePath%>insertExpenditureBill',400,550)">
				<span class="glyphicon glyphicon-plus"></span> 增加新账单
			</button>
			<button type="button" class="btn btn-danger" onclick="PLDelete()">
				<span class="glyphicon glyphicon-minus"></span> 删除选中账单
			</button>
			<div class="form-group">
				<label class="sr-only">Email</label>
				<p class="form-control-static">账单金额范围:</p>
			</div>
			<div class="form-group">
				<input style="width: 8em;" type="text" class="form-control"
					id="startMoney" name="startMoney" placeholder="起始值"
					value="${startMoney }">
			</div>
			<span>-</span>
			<div class="form-group">
				<input style="width: 8em;" type="text" class="form-control"
					id="endMoney" name="endMoney" placeholder="结束值"
					value="${endMoney }">
			</div>
			<button type="button" class="btn btn-default" onclick="searchMoney()">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>

			<table class="table table-hover" style="text-align: center;">
				<tr style="font-weight: bold;">
					<td>#</td>
					<td>出账账单编号</td>
					<td>出账金额</td>
					<td>出账原因</td>
					<td>出账时间</td>
					<td>操作</td>
				</tr>
				<tbody>
					<c:forEach items="${erpsysExpenditureList }" var="expenditures">
						<tr id="expenditure${expenditures.expenditureId }">
							<td><input type="checkbox" name="checks[]"
								id="${expenditures.expenditureId }" value="${expenditures.expenditureId }" /></td>
							<td>${expenditures.expenditureId }</td>
							<td>${expenditures.expenditureMoney }</td>
							<td>${expenditures.expenditureReason }</td>
							<td>${expenditures.expenditureTimeString }</td>
							<td>
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default btn-sm"
										onclick="show('出账账单管理','<%=basePath%>editExpenditureBill?expenditureId=${expenditures.expenditureId }','400','450')">
										<span class="glyphicon glyphicon-pencil"></span> 编辑
									</button>
									<button type="button" class="btn btn-danger btn-sm"
										onclick="del(${expenditures.expenditureId })">
										<span class="glyphicon glyphicon-remove"></span> 删除
									</button>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr id="kkpagerLine">
						<!-- kkpager -->
						<td colspan="6" style="height: 50px">
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
							<div id="kkpager" style="width: 40%; position: absolute;margin: auto;left: 0;right: 0;">
								
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
	function searchMoney(){//简单判断查询money的值是否符合要求，并拼接域名发往后台，不用ajax是为了刷新页面的时候，继续停留在当前页
		var startMoney = $("#startMoney").val();
		var endMoney = $("#endMoney").val();
		
			if(startMoney==null || startMoney==""){
				window.location.href="<%=basePath%>financialManagementExpenditureBill?endMoney="+endMoney;
			}
			if(endMoney==null  || endMoney==""){
				window.location.href="<%=basePath%>financialManagementExpenditureBill?startMoney="+startMoney;
			}else{
				if(startMoney>endMoney){
					alert("起始值不能大于结束值！")
				}
				window.location.href="<%=basePath%>financialManagementExpenditureBill?startMoney="+startMoney+"&endMoney="+endMoney;
			}
	}
	//弹出窗口调用该方法来改变表格中的值,从而不用刷新页面
	function changeTable(expenditureId,expenditureMoney,expenditureReason){
		//修改当前行金额
		$("#expenditure"+expenditureId+"").find("td").eq(2).text(expenditureMoney)
		//修改当前行出账原因
		$("#expenditure"+expenditureId+"").find("td").eq(3).text(expenditureReason)
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
		layer.confirm('确定要删除编号为'+id+'的出账账单吗？', {icon: 3, title:'提示'}, function(index){
			$.ajax({
				url : "deleteExpenditureBillSubmit",
				type : "post",
				dataType : "text",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : {
					expenditureId : id
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
		var startMoney = $("#startMoney").val();
		var endMoney = $("#endMoney").val();
		var pageNo = $("#pageNo").val();
		if((startMoney == null || startMoney == "" )&& (endMoney == null || endMoney == "")){//拼接url
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
			layer.confirm('确定要删除选中的出账账单吗？', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					url : "PLdeleteExpenditureBillSubmit",
					type : "post",
					dataType : "text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					traditional:true,//ajax传入数组，必须写
					data : {
						"expenditureIds" : ids
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