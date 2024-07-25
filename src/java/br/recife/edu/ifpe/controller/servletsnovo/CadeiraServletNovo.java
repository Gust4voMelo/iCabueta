/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servletsnovo;

import br.recife.edu.ifpe.model.entities.Cadeira;
import br.recife.edu.ifpe.model.repositories.CadeiraRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gusta
 */
@WebServlet(name = "CadeiraServletNovo", urlPatterns = {"/CadeiraServletNovo"})
public class CadeiraServletNovo extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String redirect = request.getParameter("redirect");
        
        Cadeira cad = CadeiraRepository.read(codigo);
        
        request.setAttribute("cadeira", cad);
        
        getServletContext().getRequestDispatcher("/cadeira.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        
        HttpSession session = request.getSession();
        
        session.setAttribute("msgCad", "Cadeira "+cad.getNome()+" foi cadastrada com sucesso!");
        
        response.sendRedirect("cadeira.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
