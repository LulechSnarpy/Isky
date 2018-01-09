<%-- 
    Document   : chapList
    Created on : 2017-6-16, 9:10:23
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>产品列表</legend>
            <table>
                <tr class="head">
                    <th>章节编号</th>
                    <th>课程编号</th>
                    <th>标题</th>
                    <th>章节</th>
                </tr>
                <c:forEach items="${oList}" var="c">
                    <tr id="${c.chapterId}">
                        <td>${c.chapterId}</td>
                        <td>${c.courses.courseId}</td>
                        <td>${c.title}</td>
                        <td>${c.chapter}</td>
                        <td>
                            <a>编辑</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </body>
</html>
