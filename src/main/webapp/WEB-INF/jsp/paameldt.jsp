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
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>
    ${deltager.fornavn}&nbsp;${deltager.etternavn}<br />
    ${deltager.mobil} <br />
    ${deltager.kjonn} <br />
</p>
<a href="${pageContext.request.contextPath}/deltagerView">Gå til deltagerlisten</a>
</body>
</html>