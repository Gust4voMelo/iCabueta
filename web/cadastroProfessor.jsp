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
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.codigo : ''}"/><br/>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.nome : ''}"/></br>
            e-mail: <input type="text" name="email" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.email : ''}"/></br>
            Senha: <input type="password" name="senha" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.senha : ''}"/><br/>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza') ? 'atualizar' : 'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza') ? 'Atualizar' : 'Cadastrar'}"/>
        </form>
    </body>
</html>
