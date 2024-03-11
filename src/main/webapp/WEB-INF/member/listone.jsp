<%--
  Created by IntelliJ IDEA.
  User: kuy06
  Date: 2024-03-11
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 40px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:hover {background-color: #f5f5f5;}

    .center {
        text-align: center;
    }

    button[type="submit"] {

        margin-top: 20px;
    }

    .mod-button {
        display: inline-block;
        padding: 10px 20px;
        margin-top: 20px;
        background-color: #1869e2;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        float: right;
    }

</style>
</head>
<body>
<h2 class="center">회원정보 수정</h2>
<table>
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
    </tr>
    <tr>
        <td>${memberDTO.id}</td>
        <td>${memberDTO.password}</td>
        <td>${memberDTO.username}</td>
        <td>${memberDTO.email}</td>
        <td>${memberDTO.joindate}</td>
    </tr>
</table>

<a href="/member/mod?id=${memberDTO.id}" class="mod-button">수정하기</a>

</body>
</html>
