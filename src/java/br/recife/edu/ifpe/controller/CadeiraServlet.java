/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.entities.Cadeira;
import br.recife.edu.ifpe.model.repositories.CadeiraRepository;
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
@WebServlet(name = "CadeiraServlet", urlPatterns = {"/CadeiraServlet"})
public class CadeiraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("codigo") != null) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            if (request.getParameter("op") != null) {
                
                //form editar
                if (request.getParameter("op").equals("edit")) {
                    
                    Cadeira cEdit = CadeiraRepository.read(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet Cadeira</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Cadeira</h1>");
                        out.println("<a href='CadeiraServlet'>Ver Cadeiras cadastradas</a><br/>");
                        out.println("<form method='post' action='CadeiraServlet'>");
                        out.println("Codigo: <input type='hidden' name='codigo' value='" + cEdit.getCodigo() + "'/>" + cEdit.getCodigo() + "</br>");
                        out.println("Nome: <input type='text' name='nome' value='" + cEdit.getNome() + "'/></br>");
                        out.println("Ano: <input type='number' name='ano' value='" + cEdit.getAno() + "'/></br>");
                        out.println("Semestre: <input type='number' name='semestre' value='" + cEdit.getSemestre() + "'/></br>");
                        out.println("Descrição: <textarea name='descricao'>" + cEdit.getDescricao() + "</textarea></br>");
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
                    
                    CadeiraRepository.delete(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet Cadeira</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='CadeiraServlet'>Cadeiras Cadastradas</a>");
                        out.println("<h1>A Cadeira foi deletada com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }
            
            //table para quando n tiver parametros
            
            Cadeira cad = CadeiraRepository.read(codigo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Cadeira</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Cadeira cadastrada no sistema</h1>");
                out.println("<a href='CadeiraServlet'>Ver cadeiras cadastradas</a><br/>");
                out.println("<h5>código:" + cad.getCodigo() + "</h5>");
                out.println("<h5>Nome:" + cad.getNome() + "</h5>");
                out.println("<h5>Ano:" + cad.getAno() + "</h5>");
                out.println("<h5>Semestre:" + cad.getSemestre() + "</h5>");
                out.println("<h5>Descrição:" + cad.getDescricao() + "</h5>");
                out.println("</tr>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }
        
        List<Cadeira> cadeiras = CadeiraRepository.readAll();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadeira</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadeiras cadastradas no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Nome</th><th>Ano</th><th>Semestre</th><th>Descrição</th><th>operações</th>"
                    + "</tr>");
            for (Cadeira cad : cadeiras) {
                out.println("<tr>");
                out.println("<td>" + cad.getCodigo() + "</td>");
                out.println("<td>" + cad.getNome() + "</td>");
                out.println("<td>" + cad.getAno() + "</td>");
                out.println("<td>" + cad.getSemestre() + "</td>");
                out.println("<td>" + cad.getDescricao() + "</td>");
                out.println("<td><a href='CadeiraServlet?codigo=" + cad.getCodigo() + "'>detalhar</a>"
                        + "     <a href='CadeiraServlet?codigo=" + cad.getCodigo() + "&op=edit'>editar</a>"
                        + " <a href='CadeiraServlet?codigo=" + cad.getCodigo() + "&op=delete'>deletar</a></td>");
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
        int ano = Integer.parseInt(request.getParameter("ano"));
        int semestre = Integer.parseInt(request.getParameter("semestre"));
        String descricao = request.getParameter("descricao");
        String edit = request.getParameter("edit");

        Cadeira cad = new Cadeira();
        cad.setCodigo(codigo); 
        cad.setNome(nome);
        cad.setAno(ano);
        cad.setSemestre(semestre);
        cad.setDescricao(descricao);

        if (edit != null) {
            CadeiraRepository.update(cad);
        } else {
            CadeiraRepository.create(cad);
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadeiraServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("op") != null && request.getParameter("op").equals("edit")) {
                out.println("<h1>Cadeira " + nome + " foi cadastrada com sucesso!</h1>");
            } else {
                out.println("<h1>Cadeira " + nome + " foi alterada com sucesso!</h1>");
            }
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
