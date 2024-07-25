<%-- 
    Document   : visualizaProfessor
    Created on : Jul 25, 2024, 6:14:24 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Professor cadastrado</h1>
        <%
            Professor professor = (Professor)request.getAttribute("professor");
            if(professor != null){
        %>
        <table border="1">
            <tr>
                <th>Código</th><td><%=professor.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%=professor.getNome()%></td>
            </tr>
            <tr>
                <th>E-mail</th><td><%=professor.getEmail()%></td>
            </tr>                            
        </table>
        <% } %>
    </body>
</html>
