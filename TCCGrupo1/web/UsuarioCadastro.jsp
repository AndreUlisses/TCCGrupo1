<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastror Usuário</title>
    </head>
    <body>
        <h1>Adiconar Usuário</h1>
        <form method="post" action="Servlet" name="frmPrincipal" id="frmPrincipal">
            Informe seu email: <input type="text" name="Email" id="Email">
            <br>
            Informe sua senha: <input type="password" name="Senha" id="Senha">
            <br>
            <button type="submit">Enviar</button>
            <input type="hidden" name="txtObjeto" id="txtObjeto" value="Usuario">
            <input type="hidden" name="txtMetodo" id="txtMetodo" value="Salvar">
        </form>
    </body>
</html>
