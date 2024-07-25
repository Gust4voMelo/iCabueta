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
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? estudante.codigo : ''}"/><br/>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? estudante.nome : ''}"/><br/>
            e-mail: <input type="text" name="email" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? estudante.email : ''}"/><br/>
            Senha: <input type="password" name="senha" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? estudante.senha : ''}"/><br/>
            Ano de entrada: <input type="number" name="anoEntrada" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? estudante.anoEntrada : ''}"/><br/>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza') ? 'atualizar' : 'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza') ? 'Atualizar' : 'Cadastrar'}"/>
        </form>
    </body>
</html>
