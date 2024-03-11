<%--
  Created by IntelliJ IDEA.
  User: kuy06
  Date: 2024-03-10
  Time: 오후 4:01
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
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        flex-direction: column;
    }
    form {margin-bottom: 0px !important;}
    table, th, td {
        font-size: 1rem;
        border: 1px solid black;
        border-collapse: collapse;
        text-align: center;
    }
    th, td {
        padding: 10px;
    }
    th {
        background-color: #f2f2f2;
    }

    .register-button {
        display: inline-block;
        padding: 10px 20px;
        margin-top: 20px;
        background-color: #1869e2;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }

    .action-button {
        font-size: 1rem;
        display: inline-block;
        padding: 5px 10px;
        background-color: #1869e2;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        border: none;
        cursor: pointer;
    }

    .container {
        text-align: center;
    }

    #deletebutton{
        margin-top: 20px;
    }
</style>
<body>
<div class="container" >
<h1>회원 리스트</h1>

<table>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach var="dto" items="${memberdtoList}">
    <tr>
        <td>${dto.id}</td>
        <td>${dto.username}</td>
        <td>${dto.email}</td>
        <td>${dto.joindate}</td>
        <td><a href="/member/listone?id=${dto.id}" class="action-button">수정</a></td>
        <td>
            <form action="/member/delete" method="post">
                <input type="hidden" name="id" value="${dto.id}" >
                <button type="submit" class="action-button">삭제</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

    <a href="/member/register" class="register-button">회원가입</a>

</div>
</body>
</html>
