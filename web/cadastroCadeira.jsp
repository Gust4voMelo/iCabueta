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
            
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?cadeira.codigo:''}"/><br/>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?cadeira.nome:''}"/></br>
            Ano: <input type="number" name="ano" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?cadeira.ano:''}"/></br>
            Semestre: <input type="number" name="semestre" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?cadeira.semestre:''}"/><br/>
            Descrição: <textarea name="descricao">${(param.redirect != null && param["redirect"] eq 'atualiza')?cadeira.codigo:''}</textarea></br>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}" value="1"/>
            
            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}"/>
        </form>
    </body>
</html>
