<%-- 
    Document   : estudante
    Created on : Jul 25, 2024, 3:41:25 PM
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
        <a href="index.html">Home</a></br>
        <h1>Estudantes cadastrados</h1>
        <%
            String mensagem = (String)session.getAttribute("msgEst");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
            }
        %>
    </body>
</html>
