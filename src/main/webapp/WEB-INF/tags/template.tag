<%@tag description="template inicial" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="title" %>

<html>

<head>
    <title>${title}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="assets/resources/styles/custom.css">
</head>

<body>

<nav class="light-green">
    <div class="nav-wrapper container">
        <a href="hello-servlet" class="brand-logo" style="color: #33691e;">Caixa Eletrônico</a>
    </div>
</nav>

<main class="container">
    <jsp:doBody></jsp:doBody>
</main>

<footer class="light-green center">
    <p>Contas registradas: ${counterApplication}. Operações feitas nesta seção: ${counterSession}.</p>
</footer>

<script src=" https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="assets/libraries/jquery/jquery-2.2.4.min.js"></script>
<script src="assets/libraries/jquery.mask.min.js"></script>
</body>

</html>