<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<table border="1" cellpadding="10">
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
            <td>
                <c:choose>
                    <c:when test="${product.price == 0.0}">
                        Sản phẩm không có thông tin
                    </c:when>
                    <c:otherwise>
                        ${product.price}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${product.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
