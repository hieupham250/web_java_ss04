<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Doanh Thu</title>
</head>
<body>
<h1>Danh Sách Doanh Thu Theo Tháng</h1>
<table border="1">
    <thead>
    <tr>
        <th>Month</th>
        <th>Revenue</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="revenue" items="${revenueList}">
        <tr>
            <td>${revenue.month}</td>
            <td>${revenue.revenue}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:set var="totalRevenue" value="0" />
<c:forEach var="revenue" items="${revenueList}">
    <c:set var="totalRevenue" value="${totalRevenue + revenue.revenue}" />
</c:forEach>

<h2>Total Revenue: ${totalRevenue}</h2>
<c:choose>
    <c:when test="${totalRevenue > 10000}">
        <p style="color: green;">Tổng doanh thu lớn hơn 10,000!</p>
    </c:when>
    <c:otherwise>
        <p style="color: red;">Tổng doanh thu không lớn hơn 10,000.</p>
    </c:otherwise>
</c:choose>
</body>
</html>

