<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Depósito">
    <jsp:body>
        <div id="form-deposito">
            <form action="deposito" method="post">
                <p style="color: #33691e;">Depósito</p>
                <div class="input-field">
                    <input type="text" id="inputContaDeposito" name="accountNumber" required>
                    <label for="inputContaDeposito">Número da Conta:</label>
                </div>
                <div class="input-field">
                    <input type="text" id="inputValorDeposito" name="depositValue" required>
                    <label for="inputValorDeposito">Valor do Depósito:</label>
                </div>
                <div class="input-field">
                    <input type="password" id="inputSenhaDeposito" name="password" maxlength="3" required>
                    <label for="inputSenhaDeposito">Senha:</label>
                </div>
                <div class="center-align">
                    <button class="btn light-green center-align" style="color: #33691e;">Depositar</button>
                </div>
            </form>
        </div>

        <script>

        </script>
    </jsp:body>
</t:template>