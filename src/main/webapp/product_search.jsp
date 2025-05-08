<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tìm Kiếm Sản Phẩm</title>
</head>
<body>
<h2>Danh Sách Sản Phẩm</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
        </tr>
    </c:forEach>
</table>

<h3>Tìm Kiếm Sản Phẩm Theo ID</h3>
<form method="post" action="bai5">
    <label for="searchId">Nhập ID:</label>
    <input type="number" name="searchId" id="searchId" />
    <input type="submit" value="Tìm kiếm"/>
</form>

<c:if test="${searchResult == null}">
    <p style="color: red;">Sản phẩm không tìm thấy.</p>
</c:if>

<c:if test="${searchResult != null}">
    <h3>Kết Quả Tìm Kiếm:</h3>
    <p><strong>ID:</strong> ${searchResult.id}</p>
    <p><strong>Tên:</strong> ${searchResult.productName}</p>
    <p><strong>Giá:</strong> ${searchResult.price}</p>
    <p><strong>Mô tả:</strong> ${searchResult.description}</p>
</c:if>
</body>
</html>
