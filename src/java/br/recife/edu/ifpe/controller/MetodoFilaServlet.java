/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.entities.MetodoFila;
import br.recife.edu.ifpe.model.repositories.MetodoFilaRepository;
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
@WebServlet(name = "MetodoFilaServlet", urlPatterns = {"/MetodoFilaServlet"})
public class MetodoFilaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("codigo") != null) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            if (request.getParameter("op") != null) {
                
                //form editar
                if (request.getParameter("op").equals("edit")) {
                    
                    MetodoFila mfEdit = MetodoFilaRepository.read(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet MetodoFilaServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Metodo Fila</h1>");
                        out.println("<a href='MetodoFilaServlet'>Ver metodos de fila cadastrados</a><br/>");
                        out.println("<form method='post' action='MetodoFilaServlet'>");
                        out.println("Codigo: <input type='hidden' name='codigo' value='" + mfEdit.getCodigo() + "'/>" + mfEdit.getCodigo() + "</br>");
                        out.println("Descrição curta: <input type='text' name='descricaoCurta' value='" + mfEdit.getDescricaoCurta()+ "'/></br>");
                        out.println("Descrição longa: <input type='text' name='descricaoLonga' value='" + mfEdit.getDescricaoLonga()+ "'/></br>");
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
                    
                    MetodoFilaRepository.delete(codigo);
                    
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet MetodoFilaServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='MetodoFilaServlet'>Metodos de fila Cadastrados</a>");
                        out.println("<h1>O Metodo de fila foi deletado com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }
            
            //table para quando n tiver parametros
            
            MetodoFila mf = MetodoFilaRepository.read(codigo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MetodoFilaServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Metodos de fila cadastrados no sistema</h1>");
                out.println("<a href='MetodoFilaServlet'>Ver Metodos de fila cadastrados</a><br/>");
                out.println("<h5>código:" + mf.getCodigo() + "</h5>");
                out.println("<h5>Descrição curta:" + mf.getDescricaoCurta()+ "</h5>");
                out.println("<h5>Descrição Longa:" + mf.getDescricaoLonga()+ "</h5>");           
                out.println("</tr>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }
        
        List<MetodoFila> MetodosFila = MetodoFilaRepository.readAll();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MetodoFilaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Metodos de fila cadastrados no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Descriçao curta</th><th>Descrição Longa</th><th>operações</th>"
                    + "</tr>");
            for (MetodoFila mf: MetodosFila) {
                out.println("<tr>");
                out.println("<td>" + mf.getCodigo() + "</td>");
                out.println("<td>" + mf.getDescricaoCurta() + "</td>");
                out.println("<td>" + mf.getDescricaoLonga() + "</td>");
                out.println("<td><a href='MetodoFilaServlet?codigo=" + mf.getCodigo() + "'>detalhar</a>"
                        + "     <a href='MetodoFilaServlet?codigo=" + mf.getCodigo() + "&op=edit'>editar</a>"
                        + " <a href='MetodoFilaServlet?codigo=" + mf.getCodigo() + "&op=delete'>deletar</a></td>");
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
        String descricaoCurta = request.getParameter("descricaoCurta");
        String descricaoLonga = request.getParameter("descricaoLonga");
        String edit = request.getParameter("edit");

        MetodoFila mf = new MetodoFila();
        mf.setCodigo(codigo); 
        mf.setDescricaoCurta(descricaoCurta);
        mf.setDescricaoLonga(descricaoLonga);

        if (edit != null) {
            MetodoFilaRepository.update(mf);
        } else {
            MetodoFilaRepository.create(mf);
        }
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MetodoFilaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("op") != null && request.getParameter("op").equals("edit")) {
                out.println("<h1>Metodo de fila " + descricaoCurta + " foi cadastrado com sucesso!</h1>");
            } else {
                out.println("<h1>Metodo de fila " + descricaoCurta + " foi alterado com sucesso!</h1>");
            }
            out.println("<a href='MetodoFilaServlet'>Ver metodos de fila cadastrados</a><br/>");
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
