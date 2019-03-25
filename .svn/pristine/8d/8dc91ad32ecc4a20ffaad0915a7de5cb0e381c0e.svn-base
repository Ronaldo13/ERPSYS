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
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>欢迎进入本系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="style/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="style/css/font.css">
<link rel="stylesheet" href="style/css/xadmin.css">
<link rel="stylesheet" href="style/css/cutsom-style.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="x-body">
		<blockquote class="layui-elem-quote">
			欢迎进入青阳ERP管理系统！v1.0；本机时间：<span id="showTimeLabel">YYYY-MM-DD
				xx:xx:xx</span>；
		</blockquote>
		<fieldset class="layui-elem-field">
			<legend>信息总览</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<thead>
						<tr>
							<th colspan="2" scope="col">您的账户基础信息</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th width="30%">您的账号</th>
							<td><span>${accountId }</span></td>
						</tr>
						<tr>
							<td>您的姓名</td>
							<td>${name }</td>
						</tr>
						<tr>
							<td>您的登录时间</td>
							<td>${time}</td>
						</tr>
						<tr>
							<td>您的IP地址</td>
							<td>${ip}</td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</fieldset>
		<!-- 示例：调用父窗口的某个方法 -->
		<blockquote class="layui-elem-quote layui-quote-nm">
			本系统前端框架支持：X-admin（<a
				onclick="parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')">http://x.xuebingsi.com/</a>）；
			前端框架整合：青阳龙野（kohgylw@163.com）； 项目开发：华清远见成都分中心（<a
				onclick="parent.x_admin_show('华清远见成都中心主页','http://cd.hqyj.com/?baidu')">http://cd.hqyj.com/?baidu</a>）java
			EE项目组
		</blockquote>
	</div>
</body>
<script type="text/javascript">
	//页面初始化方法
	function showBrowserVersion() {
		var userAgent = window.navigator.userAgent;
		$("#browserVersion").text(userAgent);
	}

	function reServerTime() {
		$("#rstBtn").attr("disabled", "disabled");
		$("#rstBtn").css("display", "none");
		//执行获取服务器时间的方法……
		//回弹按钮
		setTimeout("popRstBtn()", 5000);
	}

	function popRstBtn() {
		$("#rstBtn").removeAttr("disabled");
		$("#rstBtn").css("display", "inline");
	}

	function reOnlineNum() {
		$("#ronBtn").attr("disabled", "disabled");
		$("#ronBtn").css("display", "none");
		//执行获取在线人数的方法……
		//回弹按钮
		setTimeout("popRonBtn()", 1000);
	}

	function popRonBtn() {
		$("#ronBtn").removeAttr("disabled");
		$("#ronBtn").css("display", "inline");
	}

	function showLocalTime() {
		getLoaclTime();
		var t1 = window.setInterval('getLoaclTime()', 1000);
	}
	
	function getLoaclTime(){
		var nt = new Date();
		var yy = nt.getFullYear();
		var mm = nt.getMonth();
		var dd = nt.getDate();
		var h = nt.getHours();
		var m = nt.getMinutes();
		var s = nt.getSeconds();
		$("#showTimeLabel").text(
				yy + "-" + mm + "-" + dd + " " + h + ":" + m + ":" + s);
	}

	$(function() {
		showBrowserVersion();
		showLocalTime();
	});
</script>
</html>