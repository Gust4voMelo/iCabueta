/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servletsnovo;

import br.recife.edu.ifpe.model.entities.Cadeira;
import br.recife.edu.ifpe.model.repositories.CadeiraRepository;
import java.io.IOException;
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
        String op = request.getParameter("op");

        if ("delete".equals(op)) {
            Cadeira cad = CadeiraRepository.read(codigo);
            if (cad != null) {
                CadeiraRepository.delete(codigo);
                request.getSession().setAttribute("msgCad", "Cadeira " + cad.getNome() + " deletada com sucesso!");
            }
            response.sendRedirect("cadeira.jsp");
        } else {
            Cadeira cad = CadeiraRepository.read(codigo);
            request.setAttribute("cadeira", cad);
            getServletContext().getRequestDispatcher("/cadeira.jsp").forward(request, response);
        }
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

        String atualizar = request.getParameter("atualizar");

        Cadeira cad = new Cadeira();

        cad.setCodigo(codigo);
        cad.setNome(nome);
        cad.setAno(ano);
        cad.setSemestre(semestre);
        cad.setDescricao(descricao);

        HttpSession session = request.getSession();

        if (atualizar != null) {
            CadeiraRepository.update(cad);
            session.setAttribute("msgCad", "Cadeira " + cad.getNome() + " foi atualizada com sucesso!");
        } else {
            CadeiraRepository.create(cad);
            session.setAttribute("msgCad", "Cadeira " + cad.getNome() + " foi cadastrada com sucesso!");
        }

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
