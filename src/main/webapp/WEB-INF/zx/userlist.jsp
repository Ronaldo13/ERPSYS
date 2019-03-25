<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>style/src/kkpager_blue.css" />  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>style/src/kkpager.min.js"></script>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-body" align="center">
    	<form action="dosearch" method="post" class="bs-example bs-example-form" role="form">
    	<div class="input-group" style="width: 50%">
				<input id="search" name="search" placeholder="输入关键词..." value="${search}" type="text" class="form-control">
				<span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							搜索
						</button>
				</span>
		</div>
    	</form><br>
        <table class="table table-bordered table-hover" style="width: 50%">
			<tr align="center">
				<td><h class="glyphicon glyphicon-user"><b>用户名</b></h></td>
				<td><h class="glyphicon glyphicon-cog"><b>操作</b></h></td>
			</tr>
			<tbody id="tbody"></tbody>
		</table>
		<div id="kkpager" style="width: 50%" align="center"></div>
    </div>
</div>

</body>
<script type="text/javascript">
	$.ajax({
		url:"donum",
		type:"post",
		data:{"search":$("#search").val()},
		dataType:"json",
		success:function (mess){
			//生成分页控件  
			kkpager.generPageHtml({
				pno : '1',
				mode : 'click', //设置为click模式
				//总页码  
				total : mess.pageNum,  
				//总数据条数  
				totalRecords : mess.count,
				//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
				//适用于不刷新页面，比如ajax
				click : function(n){
					//这里可以做自已的处理
					$.ajax({
						url:"dolist",
						data:{"num":n,"search":$("#search").val()},
						type:"post",
						dataType:"json",
						success:function (mess){
							$("#tbody").html("");
							for(var i=0;i<mess.length;i++){
								$("#tbody").append("<tr align='center'><td>" + mess[i]+ "</td><td><a href='powerpage?username="+mess[i]+"' >分配权限</a></td></tr>")
							}
						}
					})
					//处理完后可以手动条用selectPage进行页码选中切换
					this.selectPage(n);
				},
				//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
				getHref : function(n){
					return '#';
				}
				
			});
		}
	})
	$.ajax({
		url:"dolist",
		data:{"num":1,"search":$("#search").val()},
		type:"post",
		dataType:"json",
		success:function (mess){
			$("#tbody").html("");
			for(var i=0;i<mess.length;i++){
				$("#tbody").append("<tr align='center'><td>" + mess[i]+ "</td><td><a href='powerpage?username="+mess[i]+"'>分配权限</a></td></tr>")
			}
		}
	})
</script>
</html>