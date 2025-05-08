<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Sinh Viên</title>
</head>
<body>
<h1>Danh Sách Sinh Viên</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Điểm Trung Bình</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gpa}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>Số lượng sinh viên có điểm GPA > 7.0: ${highGpaCount}</h3>
</body>
</html>
