<%-- 
    Document   : metodoFila
    Created on : Jul 25, 2024, 3:37:09 PM
    Author     : gusta
--%>

<%@page import="br.recife.edu.ifpe.model.entities.MetodoFila"%>
<%@page import="br.recife.edu.ifpe.model.repositories.MetodoFilaRepository"%>
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
        <h1>Metodos de fila cadastrados</h1>
        <%
            String mensagem = (String)session.getAttribute("msgMetFil");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
                session.removeAttribute("msgMetFil");
            }
        %>
        
        <button onclick="modalopen()">Novo metodo de fila</button>
        <div id="modal" style="position: absolute; top: 300px; left: 600px; border: 1px black solid">
            
            <%@include file="cadastroMetodoFila.jsp" %>
            
            <br/>
            <button onclick="modalclose()">close</button>
        </div>
            
        <%
            List<MetodoFila> metodosFila = MetodoFilaRepository.readAll();
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Descriçao curta</th>
                <th>Descrição Longa</th>
                <th>operações</th>
            </tr>
            <%
                for (MetodoFila mf: metodosFila) {
            %>
                <tr>
                    <td><%=mf.getCodigo()%></td>
                    <td><%=mf.getDescricaoCurta()%></td>
                    <td><%=mf.getDescricaoLonga()%></td>
                    <td>
                        <a href='MetodoFilaServletNovo?codigo=<%=mf.getCodigo()%>'>detalhar</a>
                        <a href='MetodoFilaServletNovo?codigo=<%=mf.getCodigo()%>&op=edit'>editar</a>
                        <a href='MetodoFilaServletNovo?codigo=<%=mf.getCodigo()%>&op=delete'>deletar</a></td>
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
