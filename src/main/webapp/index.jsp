<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Caixa Eletrônico">
    <jsp:body>
        <main>
            <div class="center-align" id="div-operacoes-inicial">
                <a href="saque" class="btn light-green">Sacar</a><br>
                <a href="deposito" class="btn light-green">Depositar</a><br>
                <a href="extrato" class="btn light-green">Imprimir Extrato</a><br>
                <a href="conta" class="btn light-green">Criar Conta</a>
            </div>
            <br>
            <c:if test="${not empty accounts}">
                <p>Conta registrada com sucesso. Número: ${accounts[0].getAccountNumber()}.</p>
            </c:if>
        </main>
    </jsp:body>
</t:template>

