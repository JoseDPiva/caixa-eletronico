<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:template title="Registrar Conta">
    <jsp:body>
        <div id="form-registro-conta">
            <form action="conta" method="post">
                <p style="color: #33691e;">Registre sua nova conta:</p>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="text" id="inputNomeRegistro" name="name" required>
                        <label for="inputNomeRegistro">Nome Completo:</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" id="inputCPFRegistro" name="cpf" required>
                        <label for="inputCPFRegistro">CPF:</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="password" id="inputSenhaRegistro" name="password" maxlength="3" required>
                        <label for="inputSenhaRegistro">Crie uma senha (3 números):</label>
                    </div>
                    <div class="center-align">
                        <button class="btn light-green center-align" style="color: #33691e;">Registrar
                            Conta</button>
                    </div>
                </div>
            </form>
        </div>
        <script>
            window.onload = function(){
                $('#inputCPFRegistro').mask('000.000.000-00');
                $('#inputSenhaRegistro').mask('000');
            }
        </script>
    </jsp:body>
</t:template>