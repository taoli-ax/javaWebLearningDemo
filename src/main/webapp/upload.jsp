<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.108.0">
    <title>Jumbotron example · Bootstrap v5.3</title>
    <script href="javascript/popper.min.js"></script>

    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js">
    <script src="javascript/jquery-3.6.3.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="card">
            <div class="card-header">
                <h5>user avatar</h5>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/upload/uploadAvatar" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="formFile" class="form-label">Default file input example</label>
                        <input class="form-control" type="file" id="formFile">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Upload</button>
                    </div>

                </form>
            </div>
            <div class="card-footer"></div>
        </div>
    </dvi>
    
</body>
</html>