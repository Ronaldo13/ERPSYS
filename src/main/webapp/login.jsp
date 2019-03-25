<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>零件加工厂ERP管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="style/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="style/css/font.css">
<link rel="stylesheet" href="style/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="style/js/xadmin.js"></script>
<script type="text/javascript">
	//如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接
	if (window != top) {
		top.location.href = location.href;
	}
</script>
</head>
<body class="login-bg">
	<div class="login">
		<div class="message">青阳ERP管理系统-用户登录</div>
		<div id="darkbannerwrap"></div>
		<form method="post" class="layui-form" action="dologin">
			<input name="username" placeholder="用户名" type="text"
				class="layui-input">
			<hr class="hr15">
			<input name="password" placeholder="密码" type="password"
				class="layui-input">
			<hr class="hr15">
			<input lay-submit lay-filter="login" style="width: 100%;"
				type="submit" value="登录" onclick="dologin()" />
			<hr class="hr20">
		</form>
	</div>
</body>
</html>