<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Danh sách ghế</title>
</head>
<body>
<c:if test="${not empty total}">
  <h3 style="color:green;">Tổng tiền: ${total} VND</h3>
</c:if>

<c:if test="${empty total}">
  <form action="seats" method="post">
    <table border="1" cellpadding="5" cellspacing="0">
      <tr>
        <th>Mã ghế</th>
        <th>Tên ghế</th>
        <th>Giá</th>
        <th>Trạng thái</th>
        <th>Chọn</th>
      </tr>
      <c:forEach var="seat" items="${seatList}">
        <tr>
          <td>${seat.id}</td>
          <td>${seat.name}</td>
          <td>${seat.price}</td>
          <td>
            <c:if test="${seat.booked}">Đã đặt</c:if>
            <c:if test="${!seat.booked}">Trống</c:if>
          </td>
          <td>
            <c:if test="${seat.booked}">
              <input type="checkbox" disabled />
            </c:if>
            <c:if test="${!seat.booked}">
              <input type="checkbox" name="selectedSeats" value="${seat.id}" />
            </c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    <br>
    <input type="submit" name="submit" value="Thanh toán" />
  </form>
</c:if>

<c:if test="${not empty error}">
  <h3 style="color:red;">${error}</h3>
</c:if>

</body>
</html>
