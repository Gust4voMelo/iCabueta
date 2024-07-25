<%-- 
    Document   : cadastroProfessor
    Created on : Jul 24, 2024, 8:12:20 PM
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
        <h1>Cadastro Professor</h1>
        <form method="post" action="ProfessorServletNovo">
            Código: <input type="text" name="codigo"/><br/>
            Nome: <input type="text" name="nome"/></br>
            e-mail: <input type="text" name="email"/></br>
            Senha: <input type="password" name="senha"/><br/>
            
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
