<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inscription and login forms Responsive Widget Template :: w3layouts</title>
        <link href="css1/style.css" rel='stylesheet' type='text/css' />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Inscription and login forms,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    </script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Copse|Roboto' rel='stylesheet' type='text/css'>
    <!--//webfonts-->
</head>
<body>
    <!--/start-main-->
    <div class="main">
        <div class="wrap">
            <!--/start-topo-one-->
            <div class="top-one">
                <!--/start-login-->
                <div class="login-one">
                    <div class="create-account">
                        <div class="login-head">
                            <h2>注册</h2>
                            <span class="line">
                                <span class="sub-line"></span>
                            </span>
                        </div>
                        <form action="register">
                            <p>中文名</p>
                            <input name="cnName" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }" >
                            <p>英文名</p>
                            <input name="enName" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }" >
                            <p>用户名</p>
                            <input name="stuId" type="text" class="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }" >
                            <p>密码</p>
                            <input name="spassword" type="password" value="" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }">
                            <div class="sign-up">
                                <input type="reset" value="清空">
                                <input type="submit" onclick="myFunction()" value="注册" >
                                </form>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>