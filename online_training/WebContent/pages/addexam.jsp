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
	<div style="width:400px; height:360px; background-color:rgba(190,190,190,0.3);
		padding:10px 20px;margin: 0 auto; border-radius:10px">
		<form class="form-horizontal" role="form">
		 <div class="form-group">
		    <label for="ename" class="col-sm-3 control-label">考试码</label>
		    <div class="col-sm-9">
			   	<input class="form-control" type="text" name="ename" id="ename" placeholder="请输入考试码"/>
		    </div>
		  </div>
		 <div class="form-group">
		    <label for="course" class="col-sm-3 control-label">课程名</label>
		    <div class="col-sm-9">
			    <select class="form-control" name="cou" id="course">
			    	<option value="0">===未选择===</option>
			    	<c:forEach items="" var="k">
			    		<option value="${k.id}">${k.name}</option>
			    	</c:forEach>
			    </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="unit" class="col-sm-3 control-label">章节名</label>
		    <div class="col-sm-9">
			    <select class="form-control" name="unit" id="unit">
			    	<option value="0">===未选择===</option>
			    	<c:forEach items="" var="k">
			    		<option value="${k.id}">${k.name}</option>
			    	</c:forEach>
			    </select>
		    </div>
		  </div>
		 <div class="form-group">
		    <label for="etime" class="col-sm-3 control-label">考试时长</label>
		    <div class="col-sm-9">
			    <select class="form-control" name="etime" id="etime">
			    	<option value="0">===未选择===</option>
			    	<option value="10">10</option>
			    	<option value="30">30</option>
			    	<option value="90">90</option>
			    	<option value="100">100</option>
			    	<option value="120">120</option>
			    </select>
		    </div>
		  </div>
		  <div class="form-group" style="margin-left: 10px">
		    <label for="efile">考试题目</label>
		    <input type="file" id="efile">
		    <p class="help-block">请上传考试题目</p>
		  </div>
		  <input type="submit" class="btn btn-default" value="添加"/>
		  <input type="reset" class="btn btn-default" value="清空"/>
		</form>
	</div>
</body>
</html>