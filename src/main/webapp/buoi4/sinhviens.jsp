<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <c:forEach items="${lists}" var="a" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${a.mssv}</td>
                <td>${a.ten}</td>
                <td>${a.diaChi}</td>
                <td>${a.gioiTinh}</td>
                <td>${a.tuoi}</td>
                <td>
                    <a href="/sinh-vien/remove?a=${i.index}">Delete</a>
                    <a href="/sinh-vien/view-update?viTri=${i.index}">Update</a>
                    <a href="/sinh-vien/detail?viTri=${i.index}">Detail</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
