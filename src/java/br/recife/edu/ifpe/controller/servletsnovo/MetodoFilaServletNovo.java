/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servletsnovo;

import br.recife.edu.ifpe.model.entities.MetodoFila;
import br.recife.edu.ifpe.model.repositories.MetodoFilaRepository;
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
@WebServlet(name = "MetodoFilaServletNovo", urlPatterns = {"/MetodoFilaServletNovo"})
public class MetodoFilaServletNovo extends HttpServlet {


    
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
        
        MetodoFila mf = MetodoFilaRepository.read(codigo);
        
        request.setAttribute("metodoFila", mf);
        
        getServletContext().getRequestDispatcher("/metodoFila.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        
        session.setAttribute("msgMetFil", "Metodo de fila "+mf.getDescricaoCurta()+" foi cadastrado com sucesso!");
        
        response.sendRedirect("metodoFila.jsp");
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
