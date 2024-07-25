<%-- 
    Document   : cadastroCadeira
    Created on : Jul 25, 2024, 2:46:22 PM
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
        <h1>Cadastro cadeira</h1>
        <form method="post" action="CadeiraServletNovo">
            Código: <input type="text" name="codigo"/><br/>
            Nome: <input type="text" name="nome"/></br>
            Ano: <input type="number" name="ano"/></br>
            Semestre: <input type="number" name="semestre"/><br/>
            Descrição: <textarea name="descricao"></textarea></br>
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
