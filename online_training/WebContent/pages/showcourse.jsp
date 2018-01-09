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
	<div style="width:500px; margin:0 auto">
		<table class="table table-striped table-hover">
	 		<caption>已选课程</caption>
	 		<thead>
	 			<tr>
		 			<th>ID</th>
		 			<th>课程名</th>
		 			<th>课程状态</th>
		 			<th>课程成绩</th>
		 			<th>操作</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:forEach items="${list}" var="cou">
		 			<tr>
		 				<td><c:out value="${cou.id}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.name}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.state}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.score}" default="未知"></c:out></td>
		 				<td><button class="btn btn-default">学习</button></td>
		 			</tr>
	 			</c:forEach>
	 				<tr>
		 				<td><c:out value="${cou.id}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.name}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.state}" default="未知"></c:out></td>
		 				<td><c:out value="${cou.score}" default="未知"></c:out></td>
		 				<td><button class="btn btn-default">学习</button></td>
		 			</tr>
	 		</tbody>
		</table>
	</div>
</body>
</html>