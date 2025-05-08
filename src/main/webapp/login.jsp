<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng Nhập</title>
</head>
<body>
<h2>Đăng Nhập</h2>

<form action="login.jsp" method="post">
    Tên đăng nhập: <input type="text" name="username" /><br/><br/>
    Mật khẩu: <input type="password" name="password" /><br/><br/>
    <input type="submit" value="Đăng Nhập" />
</form>

<c:if test="${not empty param.username && not empty param.password}">
    <c:if test="${param.username == 'admin' && param.password == '123456'}">
        <p style="color:green;">Đăng nhập thành công. Chào mừng <b>${param.username}</b>!</p>
    </c:if>
    <c:if test="${param.username != 'admin' || param.password != '123456'}">
        <p style="color:red;">Sai tên đăng nhập hoặc mật khẩu. Vui lòng thử lại.</p>
    </c:if>
</c:if>
</body>
</html>
