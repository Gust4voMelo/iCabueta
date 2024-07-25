<%-- 
    Document   : cadastroMetodoFila
    Created on : Jul 25, 2024, 3:34:31 PM
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
        <h1>Cadastro de metodo de fila</h1>
        <a href="index.html">Home</a></br>
        <form method="post" action="MetodoFilaServletNovo">
            Código: <input type="text" name="codigo"/><br/>
            Descrição curta: <input type="text" name="descricaoCurta"/></br>
            Descrição longa: <textarea name="descricaoLonga"></textarea></br>
            
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
