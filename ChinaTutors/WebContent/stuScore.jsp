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
                <tr>
                    <th>章节名称</th>
                    <th>考试码</th>
                    <th>成绩</th>
                </tr>
                <c:forEach items="${scores}" var="c">
                    <tr id="${c.chapterTitle}">
                        <td>${c.chapterTitle}</td>
                        <td>${c.ECode}</td>
                        <td>${c.score}</td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </body>
</html>
