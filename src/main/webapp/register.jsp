<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css">
    <script src="javascript/jquery-3.6.4.js"></script>
</head>
<body>
  <form action="${pageContext.request.contextPath}/register/newRegister" method="post">
   <label for="username" >用户名</label>
   <input type="text" id="username" name="username" required><span id="username_message"></span>


   <label for="email">电子邮件</label>
   <input type="email" id="email" name="email"  >

   <label for="password">密码</label>
   <input type="password" id="password" name="password" required><label id="password_message"></label>

   <label for="confirm-password">确认密码</label>
   <input type="password" id="confirm-password" name="confirm-password" required >

    <img  src="${pageContext.request.contextPath}/verificationCode">
    <input type="text" name="captcha" class="captcha_content" required>
    <label id="captcha_message"></label>
    <a href="javascript:void(0)">换一张</a>

   <button id="submit" type="submit">注册</button>
  </form>
  <div id="error_message"></div>

<script>
        // 验证码手动更新
        function changeCaptcha(){
                console.log("111");
                var date=new Date();
                $("img").attr("src","${pageContext.request.contextPath}/verificationCode?id="+date.getTime());
                }
        $("img").click(changeCaptcha)
        $("a").click(changeCaptcha)
        // 密码确认校验
        $("#confirm-password").blur(function(){

            if($("#password").val()==$(this).val()){
                $("#password_message").html("密码匹配").css("color","green");
                $("#submit").prop("disable",false);

            }else{
                $('#password_message').html('密码不匹配').css('color', 'red');
                $('#submit').prop('disabled', true);

            }
        })
        // 注册按钮校验 是否为空
        $("#submit").click(function(){
            if($("#username").val()=="" || $("#username").length()<6 ){
                $("#error_message").html("用户名不能小于6位").fadeIn().delay(2000).fadeOut();
                return;
            }
            if($("#password").val()=="" || $("#password").length()<6){
                 $("#error_message").html("密码不能小于6位").fadeIn().delay(2000).fadeOut();
                 return;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/register/newRegister",
                type:"post",
                data:{
                    "username":$("#username").val(),
                    "password":$("#password").val(),
                    "email":$("#email").val()
                },
                success(msg){
                    console.log(msg)
                }

                        
            })
        })
        // 用户名验证
        $("#username").blur(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/register/CheckUserExist",
                type:"post",
                data:{"username":$("#username").val()},
                
                success(msg){
                    console.log(msg);
                    
                    if(msg!="available"){
                        var icon = '<i class="fas fa-times" style="color:red;"> 用户名已存在或不能为空</i>';
                        $("#username_message").html(icon);
                    }else{
                        var icon = '<i class="fas fa-check" style="color:green;"> 用户名OK</i>';
                        $("#username_message").html(icon);
                    }
                }
        })
        }
        )
        // 验证码验证
        $(".captcha_content").blur(function(){
        
            $.ajax({
                url:"${pageContext.request.contextPath}/register/CheckCaptcha",
                type:"post",
                data:{
                    "captcha_ajax":$(".captcha_content").val(),
                },
                success(msg){
                    if(msg=="false"){
                        var hint='<div class="alert alert-warning" role="alert"><i class="fa fa-exclamation-triangle" style="color:red;">验证码输入错误</i></div>'
                        $("#captcha_message").html(hint);
                    }else{
                        var icon = '<i class="fas fa-check" style="color:green;"> 验证码OK</i>';
                        $("#captcha_message").html(icon);
                    }
                }
            })
        })
        

</script>
</body>
</html>


