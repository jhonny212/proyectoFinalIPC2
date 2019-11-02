/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletenfermera;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servletrecepcion.enfermera;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "servletenfermera", urlPatterns = {"/servletenfermera"})
public class servletenfermera extends HttpServlet {

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
       
        int id1=0;
        int cui=0;
          HttpSession sesion=request.getSession();
        
          PrintWriter s=response.getWriter();
       try{
          id1=Integer.parseInt(request.getParameter("idcontrato"));
      
          cui=Integer.parseInt(sesion.getAttribute("cui").toString());
       }catch(NumberFormatException e){}
        switch(request.getParameter("ids")){
            case "1":
             s.print(   enfermera.update(cui, id1) );
               response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=1");
              
                break;
              case "2":
                s.print(   enfermera.update(cui, id1) );
             response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=2");
                
                break;  
                
              case "4":
                  if(colamedicamento.colamedicamento(request)){
              response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=4&error=erro");
                  
                  }else{
              response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=4&error=error");
                  }
                  break;
        
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
        processRequest(request, response);
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
