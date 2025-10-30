<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Påmeldt</title>
</head>

<body>
<fieldset>
    <legend>Login</legend>
    <label for="username"></label>
    <input id="username" name="username" type="text">

    <label for="password"></label>
    <input id="password" name="password" type="password">

    <label for="loginBtn"></label>
    <input id="loginBtn" type="submit" value="Login">
</fieldset>
</body>
</html>