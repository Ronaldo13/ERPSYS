<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分配权限</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">分配权限</h3>
		</div>
		<div class="panel-body" align="center">
			<form action="dopower" method="post">
				<input type="hidden" value="<%=request.getParameter("username")%>" name="username" id="username">
				<input id="1" name="power" type="checkbox" value="1"/>管理员
				<input id="2" name="power" type="checkbox" value="2"/>仓库
				<input id="3" name="power" type="checkbox" value="3"/>市场
				<input id="4" name="power" type="checkbox" value="4"/>员工
				<input id="5" name="power" type="checkbox" value="5"/>生产
				<input id="6" name="power" type="checkbox" value="6"/>人事
				<input id="7" name="power" type="checkbox" value="7"/>财务<br>
				<hr>
				<input class="btn btn-warning" type="submit" value="确认" />
				<a href="userlist" class="btn btn-danger">取消</a>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$.ajax({
		url:'powerpage2',
		data:{'username':$("#username").val()},
		type:'post',
		dataType:'json',
		success:function (mess){
			for(var i=0;i<mess.length;i++){
				$("#"+mess[i]+"").attr("checked","checked")
			}
		}
	})
</script>
</html>