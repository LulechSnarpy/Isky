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

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<header>
    <h1>讲师端</h1>
 
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
            <legend>班级信息</legend>
            <table>
                <tr class="head">
                    <th>班级编号</th>
                    <th>班级名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${oList}" var="c">
                    <tr id="${c.classId}">
                        <td>${c.classId} &nbsp;</td>
                        <td>${c.className} &nbsp;</td>
                        <td>
                            <a href="showclassscore?classId=${c.classId}">查看考试成绩</a> &nbsp;
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
 </div>
</section>
</body>
</html>
