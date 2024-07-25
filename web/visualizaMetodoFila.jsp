<%-- 
    Document   : visualizaMetodoFila
    Created on : Jul 25, 2024, 6:06:25 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.MetodoFila"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Metodo de fila cadastrado</h1>
        <%
            MetodoFila metodoFila = (MetodoFila)request.getAttribute("metodoFila");
            if(metodoFila != null){
        %>
        <table border="1">
            <tr>
                <th>Código</th><td><%=metodoFila.getCodigo()%></td>
            </tr>
            <tr>
                <th>Descrição Curta</th><td><%=metodoFila.getDescricaoCurta()%></td>
            </tr>
            <tr>
                <th>Descrição Longa</th><td><%=metodoFila.getDescricaoLonga()%></td>
            </tr>                            
        </table>
        <% } %>
    </body>
</html>
