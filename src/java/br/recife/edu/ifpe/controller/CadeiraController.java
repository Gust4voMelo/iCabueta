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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
public class CadeiraController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //alteração
        if (req.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(req.getParameter("codigo"));

            if (req.getParameter("op") != null) {

                if (req.getParameter("op").equals("edit")) {

                    Cadeira cEdit = CadeiraRepository.read(codigo);

                    resp.setContentType("text/html;charser=UTF-8");
                    try (PrintWriter out = resp.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet CadeiraController</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Cadeira</h1>");
                        out.println("<a href='CadeiraController'>Ver cadeiras cadastradas</a><br/>");
                        out.println("<form method='post' action='CadeiraController'>");
                        out.println("Codigo: <input type='hidden' name='codigo' value='" + cEdit.getCodigo() + "'/>" + cEdit.getCodigo() + "</br>");
                        out.println("Nome: <input type='text' name='nome' value='" + cEdit.getNome() + "'/></br>");
                        out.println("Ano: <input type='text' name='email' value='" + cEdit.getSemestre() + "'/></br>");
                        out.println("Semestre: <input type='text' name='semestre' value='" + cEdit.getSemestre() + "'/></br>");
                        out.println("Descrição: <textarea name='descricao'>" + cEdit.getDescricao() + "</textarea></br>");
                        out.println("<input type='submit' value='editar'/>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");

                        return;
                    }
                }

                //delete
                if (req.getParameter("op").equals("delete")) {

                    CadeiraRepository.delete(codigo);

                    resp.setContentType("text/html;charset=UTF-8");

                    try (PrintWriter out = resp.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet CadastroCadeiraServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='CadeiraController'>Cadeiras Cadastradas</a>");
                        out.println("<h1>A cadeira foi deletada com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }

            Cadeira cad = CadeiraRepository.read(codigo);

            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CadeiraController</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Cadeira cadastrada no sistema</h1>");
                out.println("<a href='CadeiraController'>Ver cadeiras cadastradas</a><br/>");

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
        
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadeiraController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadeiras cadastradas no sistema</h1>");
            out.println("<a href='index.html'>Home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Nome</th><th>Ano</th><th>Semetre</th><th>Descrição</th><th>operações</th>"
                    + "</tr>");

            for (Cadeira cad : cadeiras) {
                out.println("<tr>");
                out.println("<td>" + cad.getCodigo() + "</td>");
                out.println("<td>" + cad.getNome() + "</td>");
                out.println("<td>" + cad.getAno() + "</td>");
                out.println("<td>" + cad.getSemestre() + "</td>");
                out.println("<td>" + cad.getDescricao() + "</td>");
                out.println("<td><a href='CadeiraController?codigo=" + cad.getCodigo() + "'>detalhar</a>"
                        + "     <a href='CadeiraController?codigo=" + cad.getCodigo() + "&op=edit'>editar</a>"
                        + " <a href='CadeiraController?codigo=" + cad.getCodigo() + "&op=delete'>deletar</a></td>");
                out.println("</tr>");
            }

            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        String nome = req.getParameter("nome");
        int ano = Integer.parseInt(req.getParameter("ano"));
        int semestre = Integer.parseInt(req.getParameter("semestre"));
        String descricao = req.getParameter("descricao");
        
        Cadeira cad = new Cadeira();
        
        cad.setCodigo(codigo);
        cad.setNome(nome);
        cad.setAno(ano);
        cad.setSemestre(semestre);
        cad.setDescricao(descricao);
        
        Cadeira cadCadastrado = CadeiraRepository.read(codigo);
        CadeiraRepository.update(cad);
        
        resp.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroCadeiraServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='CadeiraController'>Cadeiras Cadastradas</a>");
            out.println("<h1>A cadeira " + nome + " foi alterado com sucesso</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
    @Override
    public String getServletInfo(){
        return "Short description";
    }
}