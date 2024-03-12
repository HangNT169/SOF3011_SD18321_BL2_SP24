<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
<%--    for(Doi tuong : ten mang)--%>
    <tbody>
        <c:forEach items="${lists}" var="a">
            <tr>
                <td>STT</td>
                <td>${a.mssv}</td>
                <td>${a.ten}</td>
                <td>${a.diaChi}</td>
                <td>${a.gioiTinh}</td>
                <td>${a.tuoi}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
