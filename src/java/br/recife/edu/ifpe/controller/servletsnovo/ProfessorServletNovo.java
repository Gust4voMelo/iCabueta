/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servletsnovo;

import br.recife.edu.ifpe.model.entities.Professor;
import br.recife.edu.ifpe.model.repositories.ProfessorRepository;
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
@WebServlet(name = "ProfessorServletNovo", urlPatterns = {"/ProfessorServletNovo"})
public class ProfessorServletNovo extends HttpServlet {

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
        
        Professor prof = ProfessorRepository.read(codigo);
        
        request.setAttribute("professor", prof);
        
        getServletContext().getRequestDispatcher("/professor.jsp").forward(request, response);
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
        
        HttpSession session = request.getSession();
        
        session.setAttribute("msgProf", "Professor "+prof.getNome()+" foi cadastrado com sucesso!");
        
        response.sendRedirect("professor.jsp");
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
