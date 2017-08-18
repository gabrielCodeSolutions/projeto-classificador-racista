/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.DaoTexto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xino
 */
public class ValidarTexto extends HttpServlet {

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
            throws ServletException, IOException 
    {
        processRequest(request, response);
        if(request.getParameter("opiniao") == null)
        {
            response.sendRedirect("validar.jsp?erro=0");
            return;
        }
        if( request.getParameter("opiniao").equals("S") & request.getParameter("racista") == null )
        {
            response.sendRedirect("validar.jsp?erro=1");
            return;
        }
       
        
        
        
        HttpSession sessao = request.getSession();
        DaoTexto dt = new DaoTexto();
        try {
             String racista = request.getParameter("racista");
            if (request.getParameter("racista") == null) 
            {
                racista = "N";
            }
            
            dt.Classificar(Integer.parseInt(request.getParameter("id_texto")),
                            racista,
                            request.getParameter("opiniao"),(int)sessao.getAttribute("id"));
            response.sendRedirect("validar.jsp");
        } catch (SQLException ex) {
            ex.getMessage();
            Logger.getLogger(ValidarTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
