<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Please login account</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/login.css">
</head>
<body>
    <div class="main">
        <div class="left">

        </div>
        <div class="right">
            <div class="r_top">
                <span class="logo">Login</span>
                <span class="register">Create an account</span>
            </div>
            <form id="form">
            <div class="r_middle">
                    <div class="username">
                        <input type="text" id="username">
                        <div> <img src="<%=request.getContextPath() %>/pages/images/uN.png" alt=""></div>
                    </div>
                    <div class="password">
                        <input type="password" id="password">
                        <div><img src="<%=request.getContextPath() %>/pages/images/pW.png" alt=""></div>
                    </div>
            </div>
            <div class="r_bottom">
                <input type="button" value="login" id="login">
            </div>
            </form>
        </div>
    </div>

    <div class="rpage">
        <div class="rmain">
            <div class="rleft">
                <ul>
                    <li>
                        <label for="rusernamer">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
                        <input type="text" id="rusernamer">
                    </li>
                    <li>
                        <label for="rpassword">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <input type="password" id="rpassword">
                    </li>
                    <li>
                        <label for="rpasswords">确认密码：</label>
                        <input type="password" id="rpasswords">
                    </li>
                    <li>
                        <label for="phone">手&nbsp;&nbsp;机&nbsp;&nbsp;号：</label>
                        <input type="text" id="phone">
                    </li>
                    <li>
                        <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
                        <input type="text" id="email">
                    </li>
                </ul>
            </div>
            <div class="rright">
                <ul>
                    <li class="rtop">
                        <label for="textarea">个性签名</label><br>
                        <textarea name="" id="textarea" ></textarea>
                    </li>
                    <li class="rrr rli">
                        <input type="button" value="register" id="register">
                    </li>
                </ul>
            </div>
        </div>
    </div>
    
   <script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script>
$(function(){
    /**
     * 对页面进行初始化
     */
    var init = function(){
        var $main = $(".main");
        var main_h = $main.height();
        var win_h = $(window).height();
        $main.css("top",(win_h - main_h) / 2 - 100 + "px");
        if((win_h - main_h) / 2 - 100 < 0){
        	 $main.css("top", "10px");
        }else{
        	$main.css("top",(win_h - main_h) / 2 - 100 + "px");
        }

        var $rmain = $(".rmain");
        var rmain_h = $rmain.height();
        
        if((win_h - main_h) / 2 - 100 < 0){
        	$rmain.css("top", "10px");
       	}else{
       		$rmain.css("top",(win_h - rmain_h) / 2 - 100 + "px");
       	}
        
    }
    init();
    $(window).on("load resize",function () {
        init();
    })

    /**
     * 发送登陆的请求
     */
    var sendLogin = function(){
        var $username = $("#username").val();
        var $password = $("#password").val();
        console.log("登陆");
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath() %>/LoginServlet",
            async:true,
            cache : false,
            data : {
                "username":$username,
                "password":$password
            },
            dataType : "text",
            success : function(msg) {
            	var obg = JSON.parse(msg);
                alert(obg.loginMsg);
            	window.location.href="<%=request.getContextPath() %>/IndexServlet";
            },
            error : function() {
                alert("登陆失败！");
            }
        })
    }

    /**
     * 发送注册信息
     */
    var sendRegister = function(){
        var $username = $("#rusernamer").val();
        var $password = $("#rpassword").val();
        var $phone = $("#phone").val();
        var $email = $("#email").val();
        var $textarea = $("#textarea").val();
        var $file = $("#tou").val();
        var $tou = "";
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath() %>/RegisterServlet",
            async:true,
            cache : false,
            data : {
                "username":$username,
                "password":$password,
                "phone":$phone,
                "email":$email,
                "signature":$textarea,
                "tou":$tou
            },
            dataType : "json",
            success : function(msg) {
                alert(msg.registerMsg);
                window.location.reload(true);
            },
            error : function() {
                alert("注册失败！");
            }
        })
    }

    /**
     * 验证登陆时，是否有账号密码是否为空
     */
    var loginIsEmpty = function(){
        var $username = $("#username").val();
        var $password = $("#password").val();
        if($username == ""){
            alert("用户名不能为空！！！")
            return ;
        }else{
            if($password == ""){
                alert("密码不能为空！！！");
                return ;
            }else{
                sendLogin();
            }
        }
    }
    /**
     * 验证注册时，信息是否为空。
     */
    var registerIsEmpty = function(){
        var $username = $("#rusernamer").val();
        var $password = $("#rpassword").val();
        var $rpassword = $("#rpasswords").val();
        var $phone = $("#phone").val();
        var $email = $("#email").val();
        var $textarea = $("#textarea").val();
        if($username == ""||$password==""||$rpassword==""||$phone==""||$email==""||$textarea==""){
            alert("信息不完善，请核对信息！！！");
            return ;
        }
        if(!($password == $rpassword)){
        	 alert("两次输出的密码不一致");
             return ;
        }
        
        var phonePattern = /^1[3456789]\d{9}$/;
        if(!phonePattern.test($phone)) {
            alert("手机号格式错误！！！");
            return ;
        }
        var emailPattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if(!emailPattern.test($email)) {
            alert("邮箱格式错误！！！");
            return ;
        }
        sendRegister();
    }

    /**
     * 点击登陆
     */
    $("#login").on("click",function(){
        loginIsEmpty();
    });
    /**
     * 显示到注册页面
     */
    $(".register").on("click",function(){
        $(".main").hide();
        $(".rpage").show();
        init();
    })
    /**
     * 点击注册
     */
    $("#register").on("click",function(){
    	console.log("registerIsEmpty");
        registerIsEmpty();
    })
    $("#form").on("keydown",function(){
    	if(window.event.keyCode==13) 
    		sendLogin();
    })
})
</script>
</body>
</html>
