/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.entities.Professor;
import br.recife.edu.ifpe.model.repositories.ProfessorRepository;
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
@WebServlet(name = "ProfessorServlet", urlPatterns = {"/ProfessorServlet"})
public class ProfessorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("codigo") != null) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            if (request.getParameter("op") != null) {
                
                //form editar
                if (request.getParameter("op").equals("edit")) {
                    
                    Professor pEdit = ProfessorRepository.read(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ProfessorServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Professor</h1>");
                        out.println("<a href='ProfessorServlet'>Ver professores cadastrados</a><br/>");
                        out.println("<form method='post' action='ProfessorServlet'>");
                        out.println("Codigo: <input type='hidden' name='codigo' value='" + pEdit.getCodigo() + "'/>" + pEdit.getCodigo() + "</br>");
                        out.println("Nome: <input type='text' name='nome' value='" + pEdit.getNome() + "'/></br>");
                        out.println("E-mail: <input type='text' name='email' value='" + pEdit.getEmail()+ "'/></br>");
                        out.println("Senha: <input type='text' name='senha' value='" + pEdit.getSenha() + "'/></br>");
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
                    
                    ProfessorRepository.delete(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ProfessorServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='ProfessorServlet'>Professores Cadastrados</a>");
                        out.println("<h1>O Professor foi deletado com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }
            
            //table para quando n tiver parametros
            
            Professor prof = ProfessorRepository.read(codigo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProfessorServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Professor cadastrado no sistema</h1>");
                out.println("<a href='ProfessorServlet'>Ver Professores cadastrados</a><br/>");
                out.println("<h5>código:" + prof.getCodigo() + "</h5>");
                out.println("<h5>Nome:" + prof.getNome() + "</h5>");
                out.println("<h5>E-mail:" + prof.getEmail() + "</h5>");
                out.println("</tr>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }
        
        List<Professor> professores = ProfessorRepository.readAll();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Professores cadastrados no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Nome</th><th>E-mail</th><th>operações</th>"
                    + "</tr>");
            for (Professor prof: professores) {
                out.println("<tr>");
                out.println("<td>" + prof.getCodigo() + "</td>");
                out.println("<td>" + prof.getNome() + "</td>");
                out.println("<td>" + prof.getEmail() + "</td>");
                out.println("<td><a href='ProfessorServlet?codigo=" + prof.getCodigo() + "'>detalhar</a>"
                        + "     <a href='ProfessorServlet?codigo=" + prof.getCodigo() + "&op=edit'>editar</a>"
                        + " <a href='ProfessorServlet?codigo=" + prof.getCodigo() + "&op=delete'>deletar</a></td>");
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
        String senha = request.getParameter("senha");
        String edit = request.getParameter("edit");

        Professor prof = new Professor();
        prof.setCodigo(codigo); 
        prof.setNome(nome);
        prof.setEmail(email);
        prof.setSenha(senha);
        
        if (edit != null) {
            ProfessorRepository.update(prof);
        } else {
            ProfessorRepository.create(prof);
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("op") != null && request.getParameter("op").equals("edit")) {
                out.println("<h1>Professor " + nome + " foi cadastrado com sucesso!</h1>");
            } else {
                out.println("<h1>Professor " + nome + " foi alterado com sucesso!</h1>");
            }
            out.println("<a href='ProfessorServlet'>Ver professores cadastrados</a><br/>");
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
