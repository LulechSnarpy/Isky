<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>后台管理系统</title>
        <meta name="author" content="DeathGhost" />
        <link rel="stylesheet" type="text/css" href="css3/style.css">
        <!--[if lt IE 9]>
        <script src="js/html5.js"></script>
        <![endif]-->
        <script src="js3/jquery.js"></script>
        <script src="js3/jquery.mCustomScrollbar.concat.min.js"></script>
        <script>
            function deleteChapter(id, cid) {
                //发送一个ajax请求
                $.ajax({
                    url: 'deletechapters', //deleteProduct?productId=P001
                    type: 'GET', //提交请求的方法类型GET或POST等
                    data: 'chapterId=' + id, //请求数据
                    success: function () { //请求成功的话执行的js语句
                        $("tr#" + id).remove();
                    }
                });
            }
        </script>
    </head>
    <body>
        <!--header-->
        <header>
            <h2>讲师端</h2>
        </header>
        <!--aside nav-->
        <!--aside nav-->
        <aside class="lt_aside_nav content mCustomScrollbar">
            <h2><a href="forteaIndex">起始页</a></h2>
            <ul>
                <li>
                    <dl>
                        <dd><a href="showcourse">查看课程</a></dd>
                        <dd><a href="forexamadd">添加章节测试题</a></dd>
                        <dd><a href="teashowclass">查看班级</a></dd>
                    </dl>
                </li>
            </ul>
        </aside>

        <section class="rt_wrap content mCustomScrollbar">
            <div class="rt_content">
                <fieldset>
                    <legend>课程名</legend>
                    <p><span>章节编号 &nbsp;</span>${course.courseId}</p>
                    <table>
                        <tr class="head">
                            <th>章节编号</th>
                            <th>章节</th>
                            <th>章节名</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${oList}" var="c">
                            <tr id="${c.chapterId}">
                                <td>${c.chapterId}  &nbsp;</td>
                                <td>${c.chapter}  &nbsp;</td>
                                <td>${c.title}  &nbsp;</td>
                                <td>
                                    <a href="showchapterdetail?chapterId=${c.chapterId}&&courseId=${course.courseId}">查看详情</a> &nbsp;
                                    <a href="forupdatechapters?chapterId=${c.chapterId}&&courseId=${course.courseId}">编辑</a> &nbsp;
                                    <a href="deletechapters?chapterId=${c.chapterId}&&courseId=${course.courseId}">删除</a> &nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="foraddchapters?courseId=${course.courseId}">添加</a>
                </fieldset>
            </div>
        </section>
    </body>
</html>
