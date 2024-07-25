<%-- 
    Document   : cadastroEstudante
    Created on : Jul 25, 2024, 3:39:22 PM
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar estudante</h1>
        <form method="post" action="EstudanteServletNovo">
            Código: <input type="text" name="codigo"/><br/>
            Nome: <input type="text" name="nome"/></br>
            e-mail: <input type="text" name="email"/></br>
            Senha: <input type="password" name="senha"/><br/>
            Ano de entrada: <input type="number" name="anoEntrada"/></br>
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
