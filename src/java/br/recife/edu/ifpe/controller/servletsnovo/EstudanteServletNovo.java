/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servletsnovo;

import br.recife.edu.ifpe.model.entities.Estudante;
import br.recife.edu.ifpe.model.repositories.EstudanteRepository;
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
@WebServlet(name = "EstudanteServletNovo", urlPatterns = {"/EstudanteServletNovo"})
public class EstudanteServletNovo extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        Estudante est = EstudanteRepository.read(codigo);
        
        request.setAttribute("estudante", est);
        
        getServletContext().getRequestDispatcher("/estudante.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        
        session.setAttribute("msgEst", "Estudante "+est.getNome()+" foi cadastrado com sucesso!");
        
        response.sendRedirect("estudante.jsp");
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
