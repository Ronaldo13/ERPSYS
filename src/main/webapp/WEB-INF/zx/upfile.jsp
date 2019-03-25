<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传头像</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-primary">
	
	<div class="panel-heading">
		<h3 class="panel-title">上传头像</h3>
	</div>
	<div class="panel-body">
		<div class="alert alert-danger">注意:只能上传jpg格式图片</div>
		<form action="upfile" method="post" enctype="multipart/form-data">
			<label>上传头像：</label><input type="file" name="file"><br>
			<input type="submit" value="提交" class="btn btn-success">
		</form>
	</div>
</div>

</body>
</html>