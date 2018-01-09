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
                <table>
                    <tr class="head">
                        <th>班级编号</th>
                        <th>班级名称</th>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${oList}" var="c">
                        <tr id="${c.courses.courseId}">
                            <td>${c.classId}&nbsp;</td>
                            <td>${c.className}&nbsp;</td>
                            <td>${c.courses.courseId}&nbsp;</td>
                            <td>${c.courses.title}&nbsp;</td>
                            <td>
                                <a href="cvcourses?classId=${c.classId}&&stuId=${stu.stuId}">选课</a> &nbsp;
                            </td>
                        </tr>
                    </c:forEach>                
                </table>
            </div>
        </section>
    </body>
</html>
