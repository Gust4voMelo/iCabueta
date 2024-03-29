/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.entities.Estudante;
import br.recife.edu.ifpe.model.repositories.EstudanteRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
@WebServlet(name = "EstudanteServlet", urlPatterns = {"/EstudanteServlet"})
public class EstudanteServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("codigo") != null) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            if (request.getParameter("op") != null) {
                
                //form editar
                if (request.getParameter("op").equals("edit")) {
                    
                    Estudante eEdit = EstudanteRepository.read(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet EstudanteServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Estudante</h1>");
                        out.println("<a href='EstudanteServlet'>Ver Estudantes cadastrados</a><br/>");
                        out.println("<form method='post' action='EstudanteServlet'>");
                        out.println("Codigo: <input type='hidden' name='codigo' value='" + eEdit.getCodigo() + "'/>" + eEdit.getCodigo() + "</br>");
                        out.println("Nome: <input type='text' name='nome' value='" + eEdit.getNome() + "'/></br>");
                        out.println("E-mail: <input type='text' name='email' value='" + eEdit.getEmail()+ "'/></br>");
                        out.println("Senha: <input type='text' name='senha' value='" + eEdit.getSenha() + "'/></br>");
                        out.println("Ano entrada: <input type='number' name='anoEntrada' value='" + eEdit.getAnoEntrada()+ "'/></br>");
                        out.println("<input type='hidden' name='edit'>");
                        out.println("<input type='submit' value='editar'/>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");

                        return;
                    }
                }
                
                //delete cadeira
                if (request.getParameter("op").equals("delete")) {
                    
                    EstudanteRepository.delete(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet EstudanteServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='EstudanteServlet'>Estudantes Cadastrados</a>");
                        out.println("<h1>O Estudante foi deletado com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }
            
            //table para quando n tiver parametros
            
            Estudante est = EstudanteRepository.read(codigo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EstudanteServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Estudante cadastrado no sistema</h1>");
                out.println("<a href='EstudanteServlet'>Ver estudantes cadastrados</a><br/>");
                out.println("<h5>código:" + est.getCodigo() + "</h5>");
                out.println("<h5>Nome:" + est.getNome() + "</h5>");
                out.println("<h5>E-mail:" + est.getEmail() + "</h5>");           
                out.println("<h5>Ano Entrada:" + est.getAnoEntrada()+ "</h5>");
                out.println("</tr>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }
        
        List<Estudante> estudantes = EstudanteRepository.readAll();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudanteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estudantes cadastrados no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Nome</th><th>E-mail</th><th>Ano entrada</th><th>operações</th>"
                    + "</tr>");
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
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo")); //recupera as informações do form
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int anoEntrada = Integer.parseInt(request.getParameter("anoEntrada"));
        String senha = request.getParameter("senha");
        String edit = request.getParameter("edit");

        Estudante est = new Estudante();
        est.setCodigo(codigo); 
        est.setNome(nome);
        est.setEmail(email);
        est.setSenha(senha);
        est.setAnoEntrada(anoEntrada);

        if (edit != null) {
            EstudanteRepository.update(est);
        } else {
            EstudanteRepository.create(est);
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudanteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("op") != null && request.getParameter("op").equals("edit")) {
                out.println("<h1>Estudante " + nome + " foi cadastrado com sucesso!</h1>");
            } else {
                out.println("<h1>Estudante " + nome + " foi alterado com sucesso!</h1>");
            }
            out.println("<a href='EstudanteServlet'>Ver estudantes cadastrados</a><br/>");
            out.println("<a href='index.html''>Home</a>");
            out.println("</body>");
            out.println("</html>");
        
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
