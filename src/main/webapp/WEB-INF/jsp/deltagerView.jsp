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
				<c:choose>
					<c:when test="${deltager.kjonn=='Mann'}">
						<td>&#9794</td>
					</c:when>
					<c:when test="${deltager.kjonn=='Kvinne'}">
						<td>&#9792</td>
					</c:when>
				</c:choose>
                <td>${deltager.fornavn} &nbsp; ${deltager.etternavn}</td>
                <td>${deltager.mobil}</td>
            </tr>
        </c:forEach>
    </table>
</body>