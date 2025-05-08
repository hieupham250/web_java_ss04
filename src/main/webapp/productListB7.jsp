<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>

<h1>Danh sách sản phẩm</h1>

<form action="bai7" method="get">
    <label for="minPrice">Giá tối thiểu: </label>
    <input type="number" step="0.01" name="minPrice" id="minPrice" value="${param.minPrice}"/>

    <label for="maxPrice">Giá tối đa: </label>
    <input type="number" step="0.01" name="maxPrice" id="maxPrice" value="${param.maxPrice}"/>

    <button type="submit">Lọc</button>
</form>
<c:if test="${not empty products}">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Mô tả</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty products}">
    <p>Không có sản phẩm nào trong khoảng giá này.</p>
</c:if>

</body>
</html>

