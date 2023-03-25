<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>用户登录</title>
  <!-- 引入Bootstrap的CSS文件 -->
  <script src="javascript/jquery-3.6.4.js"></script>
  <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css" >
</head>
<body>

  <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/login/LoginByEmail" method="post">
              <h2 class="text-center">Log In</h2>


              <div class="mb-3">
                  <label for="email" class="form-label">Email</label>
                  <input type="email" id="Email" class="form-control" name="Email" required autofocus>
             </div>

              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password">
              </div>
              <div class="form-group custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="rememberMe">
                <label class="custom-control-label" for="rememberMe">Remember me</label>
               </div>

              <div class="text-center">
                <button type="submit" id="login" class="btn btn-primary btn-block w-50">Log In</button>
              </div>


              <hr>

              <div class="text-center">
               <p class="text-center mb-0">Don't have an account? <a href="#">Register Now</a> and get 10% off your first purchase!</p>
              </div>
            </form>
          </div>
        </div>
      </div>

</body>
<script>

    $("#login").click(function(){
         console.log($("#Email").val());
         console.log($("#password").val());
          $.ajax({
                      url:"${pageContext.request.contextPath}/login/LoginByEmail",
                      type:"post",
                      data:{
                      "Email": $("#Email").val(),
                      "password":$("#password").val(),
                  },
                      dataType:"json",
                      success(msg){
                          console.log(msg);
                      }
                  })
 


    })
</script>
</html>

