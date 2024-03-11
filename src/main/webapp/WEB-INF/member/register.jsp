<%--
  Created by IntelliJ IDEA.
  User: kuy06
  Date: 2024-03-10
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>회원가입</title>
</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-size: 0.9em;
        color: #666;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .button {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #007bff;
        color: white;
        font-size: 1em;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-top: 20px;
    }

</style>
<body>

<form action="/member/register" method="post">
    <h2>회원가입</h2>
    <div>
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" required>
    </div>
    <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="username">이름</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <button type="submit" class="button">회원가입</button>
        <button type="reset" class="button">다시입력</button>
    </div>
</form>

</body>
</html>
