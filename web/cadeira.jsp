<%-- 
    Document   : cadeira
    Created on : Jul 25, 2024, 2:49:08 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.Cadeira"%>
<%@page import="br.recife.edu.ifpe.model.repositories.CadeiraRepository"%>
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
        <h1>Cadeiras cadastradas</h1>
        <%
            String mensagem = (String)session.getAttribute("msgCad");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
                session.removeAttribute("msgCad");
            }
        %>
        
        <button onclick="modalopen()">Nova cadeira</button>
        <div id="modal" style="position: absolute; top: 300px; left: 500px; border: 1px black solid">
            
            <%@include file="cadastroCadeira.jsp" %>
            
            <br/>
            <button onclick="modalclose()">close</button>
        </div>
        <div id="modal2" style="position: absolute; top: 300px; left: 500px; border: 1px black solid">
            
            <%@include file="visualizaCadeira.jsp" %>
            
            <br/>
            <button onclick="modal2close()">close</button>
        </div>
            
        <% 
            List<Cadeira> cadeiras = CadeiraRepository.readAll();
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Ano</th>
                <th>Semestre</th>
                <th>Descrição</th>
                <th>operações</th>
            </tr>
            <%
                for (Cadeira cad : cadeiras) {
            %>
                <tr>
                    <td><%=cad.getCodigo()%></td>
                    <td><%=cad.getNome()%></td>
                    <td><%=cad.getAno()%></td>
                    <td><%=cad.getSemestre()%></td>
                    <td><%=cad.getDescricao()%></td>
                    <td>
                        <a href='CadeiraServletNovo?codigo=<%=cad.getCodigo()%>&redirect=visualiza'>visualizar</a>
                        <a href='CadeiraServletNovo?codigo=<%=cad.getCodigo()%>&redirect=atualiza'>atualizar</a>
                        <a href='CadeiraServletNovo?codigo=<%=cad.getCodigo()%>&op=delete'>deletar</a>
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
