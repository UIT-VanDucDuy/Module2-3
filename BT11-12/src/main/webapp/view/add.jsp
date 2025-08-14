<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<form action="/products?action=add" method="post">
    <h1>Thêm mới</h1>
    <%--    <input name="id" placeholder="Nhập id"><br>--%>
    <input name="name" placeholder="Nhập tên"><br>
    <input name="price" placeholder="nhập giá"><br>
    <input name="description" placeholder="nhập mô tả"><br>
    <input name="manufacturer" placeholder="nhập hãng sản xuất"><br>
    <button type="submit"> Lưu</button>
</form>
</body>
</html>