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
        <form method="post" action="MetodoFilaServletNovo">
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.codigo : ''}"/><br/>
            Descrição curta: <input type="text" name="descricaoCurta" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.descricaoCurta : ''}"/></br>
            Descrição longa: <textarea name="descricaoLonga">${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.descricaoCurta : ''}</textarea></br>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza') ? 'atualizar' : 'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza') ? 'Atualizar' : 'Cadastrar'}"/>
        </form>
    </body>
</html>
