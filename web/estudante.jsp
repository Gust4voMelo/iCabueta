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
        <div id="modal" style="position: absolute; top: 300px; left: 500px; border: 1px black solid">
            
            <%@include file="cadastroEstudante.jsp" %>
            
            <br/>
            <button onclick="modalclose()">close</button>
        </div>
            <div id="modal2" style="position: absolute; top: 300px; left: 500px; border: 1px black solid">
            
            <%@include file="visualizaEstudante.jsp" %>
            
            <br/>
            <button onclick="modal2close()">close</button>
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
            %>
                <tr>
                    <td><%=est.getCodigo()%></td>
                    <td><%=est.getNome()%></td>
                    <td><%=est.getEmail()%></td>
                    <td><%=est.getAnoEntrada()%></td>
                    <td>
                        <a href='EstudanteServletNovo?codigo=<%=est.getCodigo()%>&redirect=visualiza'>visualizar</a>
                        <a href='EstudanteServletNovo?codigo=<%=est.getCodigo()%>&redirect=atualiza'>atualizar</a>
                        <a href='EstudanteServletNovo?codigo=<%=est.getCodigo()%>&op=delete'>deletar</a>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
        
        <script>
            
            var modal = document.getElementById("modal");

            var modal2 = document.getElementById("modal2");
            
            <%
                String redirect = request.getParameter("redirect");
                
                if(redirect == null){
            %>
                document.body.removeChild(modal);
                document.body.removeChild(modal2);
                
            <% }else if(redirect.equals("visualiza")){ %>
                document.body.removeChild(modal);
            <% }else{ %>
                document.body.removeChild(modal2);
            <% } %>
            
            function modalclose(){
                document.body.removeChild(modal);
            }
            
            function modal2close(){
                document.body.removeChild(modal2);
            }
            
            function modalopen(){
                document.body.appendChild(modal);
            }
        </script>
    </body>
</html>
