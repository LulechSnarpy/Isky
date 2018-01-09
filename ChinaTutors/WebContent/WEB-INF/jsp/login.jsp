<%-- 
    Document   : login
    Created on : 2017-6-16, 15:40:17
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>登陆</title>
        <link href="css2/style.css" rel='stylesheet' type='text/css' />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js2/jquery.min.js"></script>
        <script src="js2/easyResponsiveTabs.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#horizontalTab').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion           
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                });
            });
        </script>
        <!--webfonts-->
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,400,600,700,200italic,300italic,400italic,600italic|Lora:400,700,400italic,700italic|Raleway:400,500,300,600,700,200,100' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="main">
            <h1>登陆</h1>
            <div class="sap_tabs">  
                <div id="horizontalTab"  
                     style="display: block; width: 100%; margin: 0px;">  
                    <ul class="resp-tabs-list">  
                        <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><div class="top-img"><img src="images/top-note.png" alt=""/></div><span>学员登陆</span>
                        </li>  
                        <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><div class="top-img"><img src="images/top-note.png" alt=""/></div><span>管理员登陆</span>

                        </li>  
                        <div class="clearfix"></div>  
                    </ul>
                    <div class="resp-tabs-container">
                        <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                            <div class="facts">
                                <!--login1-->
                                <div class="register">
                                    <form action="stulogin">
                                        <p>学员ID </p>
                                        <input name="stuId" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                    this.value = '';
                                                }" >
                                        <p>密码 </p>
                                        <input name="spassword" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                    this.value = '';}" >
                                        <div class="p-container">
                                            <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>记住密码</label>
                                            <div class="submit two">
                                                <input type="submit" value="登陆" >
                                            </div>
                                            <div class="clear"> </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>		
                        <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                            <div class="facts">
                                <!--login1-->
                                <div class="register">
                                    <form action="tealogin">
                                        <p>管理员ID </p>
                                        <input name="teaId" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                    this.value = '';}" >
                                        <p>密码 </p>
                                        <input name="tpassword" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                    this.value = '';
                                                }" >


                                        <div class="p-container">
                                            <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>记住密码</label>
                                            <div class="submit two">
                                                <input type="submit" value="登陆" >
                                            </div>
                                            <div class="clear"> </div>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>		
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
