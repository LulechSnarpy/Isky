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
	 		<caption>考试信息</caption>
	 		<thead>
	 			<tr>
		 			<th>ID</th>
		 			<th>考试码</th>
		 			<th>课程名</th>
		 			<th>章节名</th>
		 			<th>考试时长</th>
		 			<th>试题文件</th>
		 			<th>操作</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:forEach items="${list}" var="exam">
		 			<tr>
		 				<td><c:out value="${exam.id}" default="未知"></c:out></td><%--考试的id --%>
		 				<td><c:out value="${exam.name}" default="未知"></c:out></td><%--考试的名称 --%>
		 				<td><c:out value="${exam.couname}" default="未知"></c:out></td><%--考试的课程名称--%>
		 				<td><c:out value="${exam.unitname}" default="未知"></c:out></td><%--考试的章节名称 --%>
		 				<td><c:out value="${exam}" default="未知"></c:out></td><%--考试的时长 --%>
		 				<td><c:out value="${exam}" default="未知"></c:out></td><%--试题文件的名称 --%>
		 				<td><button class="btn btn-default">编辑</button><button class="btn btn-default">删除</button></td>
		 			</tr>
	 			</c:forEach>
	 				<tr>
		 				<td><c:out value="${exam.id}" default="未知"></c:out></td><%--考试的id --%>
		 				<td><c:out value="${exam.name}" default="未知"></c:out></td><%--考试的名称 --%>
		 				<td><c:out value="${exam.couname}" default="未知"></c:out></td><%--考试的课程名称--%>
		 				<td><c:out value="${exam.unitname}" default="未知"></c:out></td><%--考试的章节名称 --%>
		 				<td><c:out value="${exam}" default="未知"></c:out></td><%--考试的时长 --%>
		 				<td><c:out value="${exam}" default="未知"></c:out></td><%--试题文件的名称 --%>
		 				<td><button class="btn btn-default">编辑</button><button class="btn btn-default">删除</button></td>
		 			</tr>
		 			<tr>
		 				<td><button class="btn btn-default">添加</button></td>
		 			</tr>
	 		</tbody>
		</table>
	</div>
</body>
</html>