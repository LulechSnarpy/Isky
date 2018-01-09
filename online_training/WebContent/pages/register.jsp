<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="../dist/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../dist/js/bootstrap.min.js"></script>
<style>
	input{
		border-radius:5px;
	}
</style>
</head>
<body>
	<div style="width:300px; height:200px; line-height:50px; background-color:rgba(190,190,190,0.3);margin: 0 auto;text-align: center; border-radius:10px">
		<form role="form">
		 <div class="form-group">
		    <label for="username">姓名:</label>
		    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
		  </div>
		  <div class="form-group">
		    <label for="password">密码:</label>
		    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
		  </div>
		  <div class="form-group">
		    <label for="class">班级:</label>
		    <input type="text" class="form-control" id="class" name="class" placeholder="请输入班级">
		  </div>
		  <input type="submit" class="btn btn-default" value="注册"/>
		</form>
	</div>
</body>
</html>