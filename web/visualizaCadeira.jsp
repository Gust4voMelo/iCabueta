<%-- 
    Document   : visualizaCadeira
    Created on : Jul 25, 2024, 5:36:02 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Cadeira"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadeira cadastrada</h1>
        
        <%
            Cadeira cadeira = (Cadeira)request.getAttribute("cadeira");
            if(cadeira != null){
        %>
        <table border="1">
            <tr>
                <th>Código</th><td><%=cadeira.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%=cadeira.getNome()%></td>
            </tr>
            <tr>
                <th>Ano</th><td><%=cadeira.getAno()%></td>
            </tr>
            <tr>
                <th>Semestre</th><td><%=cadeira.getSemestre()%></td>
            </tr>
            <tr>
                <th>Descrição</th><td><%=cadeira.getDescricao()%></td>
            </tr>                  
        </table>
        <% } %>
    </body>
</html>
