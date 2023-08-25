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
      <p>Nhập ID:<input name="id"><br></p>
      <p>Nhập tên: <input name="name"></p><br>
      <p>Nhập giá: <input name="price"></p><br>
      <p>Nhập ảnh: <input name="img"></p><br>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
