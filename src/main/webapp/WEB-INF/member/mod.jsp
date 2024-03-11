<%--
  Created by IntelliJ IDEA.
  User: kuy06
  Date: 2024-03-11
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>회원 정보 수정</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }
        div.form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #1869e2;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top:20px;
        }

    </style>
</head>
<body>
<h2>회원 정보 수정</h2>

<form action="/member/mod" method="post">
    <input type="hidden" name="id" value="${id.id}"/> <!-- Hidden 필드로 ID 전송 -->

    <div>
        <label for="password">Password:</label>
        <input type="text" id="password" name="password" value="${id.password}" required/>
    </div>

    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${id.username}" required/>
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${id.email}" required/>
    </div>

    <button type="submit">수정 완료</button>
</form>

</body>
</html>
