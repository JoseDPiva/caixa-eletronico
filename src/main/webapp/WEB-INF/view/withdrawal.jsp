<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Saque">
    <jsp:body>
        <div id="form-saque">
            <form action="saque" method="post">
                <p style="color: #33691e;">Saque</p>
                <div class="input-field">
                    <input type="text" id="inputContaSaque" name="accountNumber" required>
                    <label for="inputContaSaque">Número da Conta:</label>
                </div>
                <div class="input-field">
                    <input type="text" id="inputValorSaque" name="withdrawalValue"  required>
                    <label for="inputValorSaque">Valor do Saque:</label>
                </div>
                <div class="input-field">
                    <input type="password" id="inputSenhaSaque" name="password" maxlength="3"  required>
                    <label for="inputSenhaSaque">Senha:</label>
                </div>
                <div class="center-align">
                    <button class="btn light-green center-align" style="color: #33691e;">Sacar</button>
                </div>
            </form>
        </div>
    </jsp:body>
</t:template>