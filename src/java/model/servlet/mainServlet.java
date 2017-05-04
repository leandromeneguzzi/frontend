/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.MercadoriaDAO;
import model.DAO.NegocioDAO;
import model.bean.Mercadoria;
import model.bean.Negocio;

/**
 *
 * @author Leandro
 */
@WebServlet(name = "mainServlet", urlPatterns = {"/mainServlet"})
public class mainServlet extends HttpServlet {

    //
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mainServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mainServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        MercadoriaDAO m = new MercadoriaDAO();
        NegocioDAO n = new NegocioDAO();
        int key = m.create(new Mercadoria(request.getParameter("tipo"), request.getParameter("mercadoria"), Integer.parseInt(request.getParameter("quantidade")), Double.parseDouble(request.getParameter("preco"))));
        n.create(new Negocio(request.getParameter("negocio"), request.getParameter("telefone"), request.getParameter("nome"), key));
        ArrayList<Mercadoria> mercadorias = new ArrayList<>();
        ArrayList<Negocio> negocios = new ArrayList<>();
        mercadorias = m.read();
        negocios = n.read();
        request.setAttribute("mercadorias", mercadorias);
        request.setAttribute("negocios", negocios);
        request.getRequestDispatcher("listaMercadorias.jsp").forward(request, response);
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
