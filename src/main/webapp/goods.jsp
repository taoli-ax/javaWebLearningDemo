<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.108.0">
    <title>Jumbotron example · Bootstrap v5.3</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/jumbotron/">

    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js">
    <script src="javascript/jquery-3.6.3.js"></script>

    



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    
  </head>
  <body>
    
<main>
  <div class="container py-4">
    <header class="pb-3 mb-4 border-bottom">
      <a href="${pageContext.request.contextPath}" class="d-flex align-items-center text-dark text-decoration-none">
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" class="me-2" viewBox="0 0 118 94" role="img"><title>Bootstrap</title><path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z" fill="currentColor"></path></svg>
        <span class="fs-4">Goods detail</span>
      </a>
    </header>
    
    
    <div class="p-1 mb-1 bg-light rounded-3">
      <div class="container-fluid py-1">
        <a href="${pageContext.request.contextPath}/cart/checkOutPage">购物车</a><b>0件</b>
        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">
          <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"></path>
          <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"></path>
        </svg>
      </div>
    </div>
    
<!-- 
    <div class="row align-items-md-stretch">
      <div class="col-md-6">
        <div class="h-100 p-5 bg-primary-subtle rounded-3">
          <img src=${pageContext.request.contextPath}/image/${goodsInstance.image}>
          
        </div>
      </div>
      <div class="col-md-6">
        <div class="h-100 p-5 bg-primary-subtle border rounded-3">
          <h2>${goodsInstance.name}</h2>
          <p>desc:${goodsInstance.caption}</p>
          <p>publisher:${goodsInstance.publisher}</p>
          <p>comments:${goodsInstance.comment_num}</p>
          <p>price:${goodsInstance.retail_price}</p>
          <button class="btn btn-outline-secondary" type="button">add to cart</button>
        </div>
      </div>
    </div> -->
    <div class="row align-items-md-stretch">
      <div class="container-fluid">
        <div class="row p-5 bg-primary-subtle border rounded-3">
            <div class="col-md-6 border">
                <img src=${pageContext.request.contextPath}/image/${goodsInstance.image} alt="商品图片" class="img-fluid">
            </div>
            <div class="col-md-6 border">
              <h2 id="product-name">${goodsInstance.name}</h2>
              <p id="product-id">${goodsInstance.id}</p>
              <p>${goodsInstance.caption}</p>
              <p>${goodsInstance.publisher}</p>
              <p>${goodsInstance.comment_num}</p>
              <p class="price">${goodsInstance.retail_price}</p>
             
              <div class="form-group m-2">
                <button type="submit" class="btn btn-primary" id="add-to-cart">加入购物车</button>
                <button type="submit" class="btn btn-success" id="buy-now">立即购买</button>
                <label for="quantity">数量:</label>
                <input type="number"  id="quantity" value="1"  min="1" max="99" >
              
              
            </div>
             
            </div>
        </div>
      </div>
    </div>



    

    <footer class="pt-3 mt-4 text-muted border-top">
      &copy; 2022
    </footer>
  </div>
</main>
</body>
<script>
  $("#add-to-cart").click(function(){
    $.ajax({
      url:`${pageContext.request.contextPath}/cart/addToCart`,
      data:{
        num:$("#quantity").val(),
        price:$(".price").text(),
        name:$("#product-name").text(),
        productId:$("#product-id").text()
      },
      type:"post",
      success(msg){
        console.log(msg);
      }
    })
  })
  //ajax异步等待会阻塞页面跳转
  // $(".bi-cart-plus").click(function(){
  //       $.ajax({
  //         url: "${pageContext.request.contextPath}/cart/checkOutPage",
  //         type:"get",
  //         success(msg){
            
  //           console.log(msg)
  //         }
  //       })
     
  //     })
  
  
</script>
</html>
