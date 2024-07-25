<%-- 
    Document   : estudante
    Created on : Jul 25, 2024, 3:41:25 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Estudante"%>
<%@page import="java.util.List"%>
<%@page import="br.recife.edu.ifpe.model.repositories.EstudanteRepository"%>
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
                session.removeAttribute("msgEst");
            }
        %>
        
        <button onclick="modalopen()">Nova Estudante</button>
        <div id="modal" style="position: absolute; top: 300px; left: 600px; border: 1px black solid">
            
            <%@include file="cadastroEstudante.jsp" %>
            
            <br/>
            <button onclick="modalclose()">close</button>
        </div>
            
        <%
            List<Estudante> estudantes = EstudanteRepository.readAll();
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Ano entrada</th>
                <th>operações</th>
            </tr>
            <%
                for (Estudante est: estudantes) {
                out.println("<tr>");
                out.println("<td>" + est.getCodigo() + "</td>");
                out.println("<td>" + est.getNome() + "</td>");
                out.println("<td>" + est.getEmail() + "</td>");
                out.println("<td>" + est.getAnoEntrada()+ "</td>");
                out.println("<td><a href='EstudanteServlet?codigo=" + est.getCodigo() + "'>detalhar</a>"
                        + "     <a href='EstudanteServlet?codigo=" + est.getCodigo() + "&op=edit'>editar</a>"
                        + " <a href='EstudanteServlet?codigo=" + est.getCodigo() + "&op=delete'>deletar</a></td>");
                out.println("</tr>");
                }
            %>
        </table>
        
        <script>
            
            var modal = document.getElementById("modal");
            
            document.body.removeChild(modal);
            
            function modalclose(){
                document.body.removeChild(modal);
            }
            
            function modalopen(){
                document.body.appendChild(modal);
            }
        </script>
    </body>
</html>
