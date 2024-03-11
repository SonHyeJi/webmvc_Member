<%--
  Created by IntelliJ IDEA.
  User: kuy06
  Date: 2024-03-11
  Time: 오후 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column; /* 변경: 아이템을 세로로 정렬 */
            height: 100vh;
        }
        .container {
            width: 100%;
            max-width: 300px;
            text-align: center;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px; /* 폼과 에러 메시지 사이의 간격 조정 */
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        .error-message {
            color: red;
            margin-bottom: 20px; /* 에러 메시지와 폼 사이의 간격 조정 */
        }
    </style>
</head>
<body>

<c:if test="${param.result == 'error'}">
    <div class="error-message">
        <h1>로그인 에러입니다. 다시 시도하세요!</h1>
    </div>
</c:if>

<form action="/login" method="post">
    <h1>Login</h1>
    <input type="text" name="id" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button type="submit">LOGIN</button>
</form>

</body>
</html>