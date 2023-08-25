<%--
  Created by IntelliJ IDEA.
  User: DANG HAI
  Date: 8/9/2023
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="/products/add" method="post">
        <input name="id" value="${product.id}"><br>
        <input name="name" value="${product.name}"><br>
        <input name="price" value="${product.price}"><br>
        <input name="img" value="${product.img}"><br>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>
