<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Extrato">
    <jsp:body>
        <div id="form-extrato">
            <form action="extrato" method="post">
                <p style="color: #33691e;">Extrato</p>
                <div class="input-field">
                    <input type="text" id="inputContaExtrato" name="accountNumber" required>
                    <label for="inputContaExtrato">Número da Conta:</label>
                </div>
                <div class="input-field">
                    <input type="password" id="inputSenhaExtrato" name="password" maxlength="3" required>
                    <label for="inputSenhaExtrato">Senha:</label>
                </div>
                <div class="center-align">
                    <button class="btn light-green center-align" style="color: #33691e;">Gerar Extrato</button>
                </div>
            </form>
        </div>
    </jsp:body>
</t:template>