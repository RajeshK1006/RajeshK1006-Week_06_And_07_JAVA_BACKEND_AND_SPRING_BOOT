<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 50px;
        }
        h1 {
            color: #2c3e50;
        }
        h3 {
            color: #27ae60;
        }
        p {
            color: #34495e;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>SUCCESSFUL LOGIN</h1>
    <h3>Hi <%= request.getAttribute("user") %>, Login successful!</h3>
    <p>Welcome to your account.</p>
    <a href="login.html">Logout?</a>
</body>
</html>
