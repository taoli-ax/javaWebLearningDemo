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

    <script src="javascript/popper.min.js"></script>

    <script href="bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <script href="bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js"></script>
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
            <span class="fs-4">checkout</span>
          </a>
        </header>

        

        <div class="p-5 mb-4 bg-light rounded-3">
          <div class="container-fluid py-5">
            <article class="my-3" id="tables">
              <div>
                <div class="bd-example-snippet bd-code-snippet"><div class="bd-example">
                  <table class="table table-responsive table-striped caption-top">
                    <caption>goods in your cart</caption>
                    <thead>
                    <tr>
                      <th scope="col">序号</th>
                      <th scope="col">名称</th>
                      <th scope="col">图片</th>
                      <th scope="col">数量</th>
                      <th scope="col">单价</th>
                      <th scope="col">小计</th>
                    </tr>
                    </thead>
                    <tbody  class="table-group-divider">
                      <c:forEach items="${cartList}" var="item" varStatus="id" >
                        <tr>
                          <td class="itemIndex">${id.index+1}</td>
                          <td>${item.goods.name}</td>
                          <td><img width="80px" src="${pageContext.request.contextPath}/image/${item.goods.image}"></td>
                          <td>${item.goods_quantity}</td>
                          <td>${item.goods.retail_price}</td>
                          <td id="subtotal">${item.subtotal}</td>
                        </tr>
                  
                      </c:forEach>
                    </tbody>
                    <tfoot  class="table-group-divider ">
                      <tr>
                      <th colspan="5">合计：</th>
                      <td id="total">${total}</td>
                      </tr>
                    </tfoot>
                  </table>
                  <a href="${pageContext.request.contextPath}/settle.jsp">结算</a>
                
                </div>
              </div>
            </article>
            <!-- <h1 class="display-5 fw-bold"></h1>
            <p class="col-md-8 fs-4"></p> -->
            
              
      
        

        <footer class="pt-3 mt-4 text-muted border-top">
          &copy; 2022
        </footer>
      </div>
    </main>
</body>
<script>
  

  $(".btn").click(function(){
    
    })

  
  
</script>
</html>