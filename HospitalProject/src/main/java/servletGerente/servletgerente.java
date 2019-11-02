/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletGerente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetescompartidos.empleado;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "servletgerente", urlPatterns = {"/servletgerente"})
public class servletgerente extends HttpServlet {

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
        gerente tmp=new gerente();
           PrintWriter s=response.getWriter();
      
        
        switch(request.getParameter("ids")){
            case "1":
                if(tmp.actualizarTarifario(request)){
            s.print("ja");
              response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=1&error=erro");
       
        }else{
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=1&error=error");
       
        s.print(tmp.getError()+"a");
        }
                break;
            case "2":
              if(tmp.actualizarGlobal(request)){
                  s.print(request.getParameter("iddato"));
              response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=2&error=erro");
       
        }else{
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=2&error=error");
       s.print(tmp.getError());
        }
                break;
                
                  case "3":
                      empleado ts=new empleado(request, request);
              if(tmp.contratar(request, ts)){
              response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=3&error=erro");
       }else{
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=3&error=error");
       s.print(tmp.getError()+"yes");
        }
                break;
                
                     case "4":
                 empleado tss=new empleado(request, request);
              if(tmp.contratarTemporal(request, tss)){
              response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=4&error=erro");
       
        }else{
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=4&error=error");
       s.print(tmp.getError()+"yes");
        }
                break;
                
                     case "5":
                if(tmp.generarPago(request)){
                         response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=5&error=erro");
      
                }else{
                 s.print(tmp.getError()+"yes");
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=5&error=error");
      
                }
                break;
                      case "6":
                if(tmp.actualizarPAgo(request,"")){
                         response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=6&error=erro");
      
                }else{
                 s.print(tmp.getError()+"yes");
           response.sendRedirect("/HospitalProject/gerente/principalManager.jsp?id=6&error=error");
      
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
