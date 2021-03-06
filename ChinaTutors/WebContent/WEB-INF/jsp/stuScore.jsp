<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>后台管理系统</title>
        <meta name="author" content="DeathGhost" />
        <link rel="stylesheet" type="text/css" href="css4/style.css">
        <!--[if lt IE 9]>
        <script src="js/html5.js"></script>
        <![endif]-->
        <script src="js4/jquery.js"></script>
        <script src="js4/jquery.mCustomScrollbar.concat.min.js"></script>
        <script>

            (function ($) {
                $(window).load(function () {

                    $("a[rel='load-content']").click(function (e) {
                        e.preventDefault();
                        var url = $(this).attr("href");
                        $.get(url, function (data) {
                            $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                            //scroll-to appended content 
                            $(".content").mCustomScrollbar("scrollTo", "h2:last");
                        });
                    });

                    $(".content").delegate("a[href='top']", "click", function (e) {
                        e.preventDefault();
                        $(".content").mCustomScrollbar("scrollTo", $(this).attr("href"));
                    });

                });
            })(jQuery);
        </script>
    </head>
    <body>
        <!--header-->
        <header>
            <h2>学生端</h2>

        </header>
        <!--aside nav-->
        <!--aside nav-->
        <aside class="lt_aside_nav content mCustomScrollbar">
            <h2><a href="forstuIndex?stuId=${stu.stuId}">起始页</a></h2>
            <ul>
                <li>
                    <dl>
                        <dd><a href="forcvcourse?stuId=${stu.stuId}">在线选课</a></dd>
                        <dd><a href="stushowcourse?stuId=${stu.stuId}">查看课程</a></dd>
                    </dl>
                </li>
            </ul>
        </aside>
        <section class="rt_wrap content mCustomScrollbar">
            <div class="rt_content">   
                <fieldset>
                    <legend  style="font-weight: bold;font-size: 20px;color:brown;">考试成绩</legend>
                    <table>
                        <tr class="head">
                            <th>章节名称</th>
                            <th>考试码</th>
                            <th>成绩</th>
                        </tr>
                        <c:forEach items="${scores}" var="c">
                            <tr id="${c.chapterTitle}">
                                <td>${c.chapterTitle}&nbsp;</td>
                                <td>${c.ECode}&nbsp;</td>
                                <td>${c.score}&nbsp;</td>
                            </tr>
                        </c:forEach>
                    </table>
                </fieldset>
                <a href="stushowchapter?courseId=${course.courseId}&&stuId=${stu.stuId}">返回</a>
            </div>
        </section>

    </body>
</html>
