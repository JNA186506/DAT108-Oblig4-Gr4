<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="no-nb">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/deltagerscript.js" defer></script>
    <meta charset="UTF-8">
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>
<c:forEach var="error" items="${errors}">
   <p style="color:red;">${error}</p>
</c:forEach>
<!-- Jeg har fjernet alt som har med form og input å gjøre,
     siden dette er pensum. Her får dere sette opp skjemaet
     selv. Lykke til.
-->
<div id="root">
    <fieldset>
        <legend>Registrer deltager</legend>
        <form action="${pageContext.request.contextPath}/registrer" method="post">
            <label for="fornavn">Fornavn</label>
            <input type="text" id="fornavn" name="fornavn"><br>

            <label for="etternavn">Etternavn</label>
            <input type="text" id="etternavn" name="etternavn"><br>

            <label for="nummer">Mobilnummer</label>
            <input type="tel" id="nummer" name="mobil"><br>

            <label for="passord1">Passord</label>
            <input type="password" id="passord1" name="passord"><br>

            <label for="passord2">Repetert passord</label>
            <input type="password" id="passord2" name="passord2"><br>

            <p>Kjønn</p>
            <label>
                <input type="radio" name="kjonn" value="Mann" checked> Mann
            </label>
            <label>
                <input type="radio" name="kjonn" value="Kvinne"> Kvinne
            </label>
            <input type="submit" id="submitBtn" value="Registrer!">
        </form>
    </fieldset>
</div>
</body>
</html>
