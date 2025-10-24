<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <script src="deltagerscript.js" defer></script>
    <title>Deltagerliste</title>
</head>
<body>
<h3>Deltagerliste</h3>
    <table>
        <tr>
            <td>Kjonn</td>
            <td>Navn</td>
            <td>Mobil</td>
        </tr>
        <c:forEach var="deltager" items="${deltagere}">
            <tr>
                <td>${deltager.kjonn}</td>
                <td>${deltager.fornavn} &nbsp; ${deltager.etternavn}</td>
                <td>${deltager.mobil}</td>
            </tr>
        </c:forEach>
    </table>
</body>