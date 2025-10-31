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
    <p style="color:red;">${feilNavn}</p>
    <p style="color:red;">${feilPassord}</p>
    <p style="color:red;">${ikkeLoggetInn}</p>
    <p style="color:red;">${loggetUt}</p>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username"></label>
        <p>Mobil</p>
        <input id="username" name="username" type="text" value="${param.username}">

        <label for="password"></label>
        <p>Passord</p>
        <input id="password" name="passord" type="password">

        <label for="loginBtn"></label>
        <input id="loginBtn" type="submit" value="Login">
        <a href="/paamelding">
            <button type="button">
                Registrer deltager
            </button>
        </a>
    </form>

</fieldset>
</body>
</html>