<%-- 
    Document   : professor
    Created on : Jul 25, 2024, 2:31:02 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Professor"%>
<%@page import="br.recife.edu.ifpe.model.repositories.ProfessorRepository"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.html">Home</a></br>
        <h1>Professores Cadastrados</h1>        
        <%
            String mensagem = (String)session.getAttribute("msgProf");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
                session.removeAttribute("msgProf");
            }
        %>
        
        <button onclick="modalopen()">Novo professor</button>
        <div id="modal" style="position: absolute; top: 300px; left: 600px; border: 1px black solid">
            
            <%@include file="cadastroProfessor.jsp" %>
            
            <br/>
            <button onclick="modalclose()">close</button>
        </div>
            
        <%
            List<Professor> professores = ProfessorRepository.readAll();
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>operações</th>
            </tr>
            <%
                for (Professor prof: professores) {
            %>
                <tr>
                    <td><%=prof.getCodigo()%></td>
                    <td><%=prof.getNome()%></td>
                    <td><%=prof.getEmail()%></td>
                    <td>
                        <a href='ProfessorServletNovo?codigo=<%=prof.getCodigo()%>'>detalhar</a>
                        <a href='ProfessorServletNovo?codigo=<%=prof.getCodigo()%>&op=edit'>editar</a>
                        <a href='ProfessorServletNovo?codigo=<%=prof.getCodigo()%>&op=delete'>deletar</a></td>
                </tr>
            <%
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
