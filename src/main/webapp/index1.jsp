<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="javascript/jquery-3.6.3.js"></script>
</head>
<body class="index">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">图书电商</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div>
        <c:if test="${not empty user}">
            <ul class="short-cut">
                <li>个人中心</li>
                <li>订单中心</li>
                <p>安全退出</p>
            </ul>
        </c:if>
        <c:if test="${empty user}">
            <ul class="short-cut">
                <li>登录</li>
                <a href=${pageContext.request.contextPath}/register.jsp>注册</a>

            </ul>
        </c:if>
    </div>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">图书分类</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">购物车</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">我的订单</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container my-5">
    <div class="side-bar" id="container-side-bar">
        <ul class="hot_goods">
        </ul>

    </div>
    <div class="card-deck">
        <div class="card">
            <button id="newest">whats new</button>
            <ul class="list" >
            </ul>

        </div>
        <div class="card">
            <img src="https://via.placeholder.com/340x200" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">图书名称1</h5>
                <p class="card-text">图书描述1</p>
                <p class="card-text">价格1</p>
                <a href="#" class="btn btn-primary">购买</a>
            </div>
        </div>
        <div class="card">
            <img src="https://via.placeholder.com/340x200" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">图书名称2</h5>
                <p class="card-text">图书描述2</p>
                <p class="card-text">价格2</p>
                <a href="#" class="btn btn-primary">购买</a>
            </div>
        </div>
        <div class="card">
            <img src="https://via.placeholder.com/340x200" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">图书名称3</h5>
                <p class="card-text">图书描述3</p>
                <p class="card-text">价格3</p>
                <a href="#" class="btn btn-primary">购买</a>
            </div>
        </div>
    </div>
</div>

</body>

</html>