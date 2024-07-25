<%-- 
    Document   : visualizaEstudante
    Created on : Jul 25, 2024, 6:01:26 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Estudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Estudante cadastrado</h1>
        <%
            Estudante estudante = (Estudante)request.getAttribute("estudante");
            if(estudante != null){
        %>
        <table border="1">
            <tr>
                <th>Código</th><td><%=estudante.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%=estudante.getNome()%></td>
            </tr>
            <tr>
                <th>E-mail</th><td><%=estudante.getEmail()%></td>
            </tr>
            <tr>
                <th>Ano de entrada</th><td><%=estudante.getAnoEntrada()%></td>
            </tr>                             
        </table>
        <% } %>
    </body>
</html>
