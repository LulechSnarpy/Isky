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
                    <legend  style="font-weight: bold;font-size: 20px;color:brown;">章节详情</legend>
                    <form action="updatechapters?chapterId=${c.chapterId}&&courseId=${course.courseId}" method="post">
                        <p><span>章节编号： </span>${c.chapterId}</p>
                        <span>章节：</span><input type="text" name="chapter" value="${c.chapter}">
                        <br><br>
                        <span>章节名：</span><input type="text" name="title" value="${c.title}">
                        <br><br> 
                        <span>章节内容：</span><input type="text" name="content" value="${c.content}">
                        <br><br>
                        <input type="submit" value="提交更改">
                    </form>
                </fieldset>
            </div>
        </section>
    </body>
</html>
