<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="style/css/kkpager_orange.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="style/js/kkpager.min.js"></script>
<script type="text/javascript" src="style/js/bootstrap.min.js"></script>
<script src="<%=basePath%>style/lib/layui/layui.js" charset="utf-8"></script>
<link rel="stylesheet" href="<%=basePath%>style/lib/layui/css/layui.css">
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" align="center">
			<strong class="icon-reorder"><h2>生产列表</h2></strong>
			<hr>
		</div>
		<form method="POST" action="select/doProductSreach">
			<span>按名称查询：</span><input id="sreachName" name="sendSreachName"
				placeholder="请输入名称..." value="${sendSreachName}" />
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
		</form>
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#myModal3">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
		</button>
		<button type="button" class="btn btn-danger" onclick="PLDelete()">
			<span class="glyphicon glyphicon-minus"></span> 删除选中信息
		</button>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel" align="center">
							生产信息添加</h4>
					</div>
					<div class="modal-body" align="center">
						<form id="addform1">
							<table>
								<tr>
									<td>生产编号：</td>
									<td><input type="text" name="product_id"
										value="${p.productId}"></td>
								</tr>
								<tr>
									<td>生产时间：</td>
									<td><input type="date" name="product_time"
										value="${p.productTime}"></td>
								</tr>
								<tr>
									<td>生产数量：</td>
									<td><input type="text" name="product_number"
										value="${p.productNumber }"></td>
								</tr>
								<tr>
									<td>生产批次：</td>
									<td><input type="text" name="product_batch"
										value="${p.productBatch}"></td>
								</tr>
								<tr>
									<td>产品名称：</td>
									<td><input type="text" name="product_name"
										value="${p.productName}"></td>
								</tr>
								<tr>
									<td>产品规格：</td>
									<td><input type="text" name="product_type"
										value="${p.productType}"></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							关闭</button>
						<button type="button" class="btn btn-primary" onclick="add()">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>选择</th>
					<th>生产编号</th>
					<th>生产时间</th>
					<th>生产数量</th>
					<th>生产批次</th>
					<th>产品名称</th>
					<th>产品规格</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody id="productDateTable">
			</tbody>
			<%-- <c:forEach items="${list1}" var="p1" varStatus="num">
			<tr>
				<td>					
					<input name="CreatePaper" type="checkbox"  value="${p1.productId }"/>
				</td>
				<td>${p1.productId }</td>
				<td>${p1.productTime }</td>
				<td>${p1.productNumber}</td>
				<td>${p1.productBatch}</td>
				<td><button type="button" class="btn btn-info">修改</button></td>
				<td><button type="button" class="btn btn-warning">删除</button></td>
			</tr>
		</c:forEach> --%>
		</table>
		<!-- 在相应的位置上放置分页的DOM容器 -->
		<div id="kkpager"></div>
	</div>
	<tr>
		<td colspan="6" style="text-align: left;">
			<div class="btn-group" role="group">
				<button type="button" id="checkall"
					onclick="checkallInput('checkall')" class="btn btn-default">
					<span class="glyphicon glyphicon-ok-circle"></span> 全选
				</button>
				<button type="button" id="unCheckall"
					onclick="checkallInput('unCheckall')" class="btn btn-default">
					<span class="glyphicon glyphicon-ban-circle"></span> 全不选
				</button>
				<button type="button" id="reversedCheck"
					onclick="checkallInput('reversedCheck')" class="btn btn-default">
					<span class="glyphicon glyphicon-retweet"></span> 反选
				</button>
			</div>
		</td>

	</tr>
	
	<script type="text/javascript">
		var layer;
		$(function() {//页面初始化
			layui.use('layer', function() {
				layer = layui.layer;
			});
			var warning = "${warning }";
			if (warning != "") {
				alert(warning);
			}
		});
		$(function() {
			console.log(window.location.search);
			showPage(1);
			initKkpager();
		});
		function initKkpager() {
			$.ajax({
				url : "select/getProductPageInfo",
				data : {
					sreachKey : $("#sreachKey").val()
				},
				type : "POST",
				dataType : "text",
				success : function(result) {
					var pi = eval("(" + result + ")");
					//生成分页控件
					console.log("查询出应有的总页码是：" + pi.total);
					//Kkpager在一次初始化后，无法再改变分页结构
					kkpager.generPageHtml({
						//当前页码
						pno : '1',
						mode : 'click', //设置为click模式
						//总页码  
						total : pi.total,
						//总数据条数  
						totalRecords : pi.totalRecords,
						//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
						//适用于不刷新页面，比如ajax
						click : function(n) {
							//这里可以做自已的处理
							showPage(n);
							//处理完后可以手动条用selectPage进行页码选中切换
							this.selectPage(n);
						},
						//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
						getHref : function(n) {
							return '#';
						}

					});
				},
				error : function() {

				}
			});
		}
		function showPage(n) {
			$("#productDateTable").html("");//先清空原有的数据
			//加载新页的数据
			$
					.ajax({
						url : "select/selectProductTable",
						type : "post",
						data : {
							"currentPage" : n,
							"sreachKey" : $("#sreachName").val()
						},
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						dataType : "text",
						success : function(result) {
							console.log(result);
							var pt = eval("(" + result + ")");
							for (var i = 0; i < pt.length; i++) {
								$("#productDateTable")
										.append(
												'<tr><td><input name="checks[]" type="checkbox"  value="'
														+ pt[i].productId 
														+ '"/></td>'
														+ '<td>'
														+ pt[i].productId
														+ '</td>'
														+ '<td>'
														+ pt[i].productTime
														+ '</td>'
														+ '<td>'
														+ pt[i].productNumber
														+ '</td>'
														+ '<td>'
														+ pt[i].productBatch
														+ '</td>'
														+ '<td>'
														+ pt[i].productName
														+ '</td>'
														+ '<td>'
														+ pt[i].productType
														+ '</td>'
														+ '<td>'
														+ '<a href="update/updateproductdate?productId='
														+ pt[i].productId
														+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</a>'
														+ '<button type="button" class="btn btn-warning" onclick="del(\''
														+ pt[i].productId
														+ '\')\"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>'
														+ '</td></tr>');
							}
						},
						error : function() {

						}
					});
		}

		function del(productId) {
			if (confirm("确定删除生产编号为" + productId + "的数据吗？")) {
				$.ajax({
					url : "delete/deleteproductdate",
					data : {
						productId : productId
					},
					success : function(result) {
						alert("删除成功");
						window.location.reload();
					},
					error : function() {
						alert("删除失败...");
						window.location.reload();
					}
				})
			}
		}

		function add() {
			$.ajax({
				url : "add/addproductingdate",
				data : $("#addform1").serialize(),
				success : function(result) {
					alert("增加成功");
					window.location.reload();
				},
				error : function() {
					alert("增加失败...");
				}
			});
		}
		
		function checkallInput(type) {//全选、取消全选、反选
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
		//批量删除
		function PLDelete(){
			var ids = [];//声明一个空数组
			$("input[name='checks[]']").each(function(){//循环将已经勾选了的checkbox的value值装进数组中
				if(this.checked==true){
					ids.push($(this).val());
				}
			});
			if(ids.length!=0){//判断所选的数组是否为空
				layer.confirm('确定要删除选中的生产信息吗？',{icon:3,title:'提示'},function(index){
				$.ajax({
					url:"delete/PLdeleteproductdate",
					data:{
						"product_id" : ids
					},
					type:"post",
					dataType:"text",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					traditional:true,//ajax传入数组，必须写
					success:function(result){
						alert("删除成功");
						window.location.reload();
					},
					error:function(){
						alert("删除失败...");
					}			
				});
			});
			}else{
				parent.layer.alert('没有选中任何信息！');
			}
		}
	</script>
</body>

</html>
