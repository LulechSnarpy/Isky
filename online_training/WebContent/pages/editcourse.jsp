<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="../dist/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width:400px; height:120px; background-color:rgba(190,190,190,0.3);
		padding:10px 20px;margin: 0 auto; border-radius:10px">
		<form class="form-horizontal" role="form">
		 <div class="form-group">
		    <label for="couname" class="col-sm-3 control-label">章节名称</label>
		    <div class="col-sm-9">
			   	<input class="form-control" type="text" name="couname" id="couname" placeholder="请输入章节名称"/>
		    </div>
		  </div>
		  <input type="submit" class="btn btn-default" value="修改"/>
		  <input type="reset" class="btn btn-default" value="清空"/>
		  <button style="float:right" class="btn btn-default">返回</button>
		</form>
	</div>
</body>
</html>