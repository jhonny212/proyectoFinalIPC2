/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

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
 * @author jhonny
 */
@WebServlet(name = "servletemployee", urlPatterns = {"/servletemployee"})
public class servletemployee extends HttpServlet {

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
        PrintWriter print=response.getWriter();
        empleado tmp=new empleado(Integer.parseInt(request.getParameter("cui")),request.getParameter("contra"));
        String tipo=tmp.iniciarSesio(tmp);
        PrintWriter s=response.getWriter();
        if( tipo.equals("")){
     response.sendRedirect("/HospitalProject/indexEmployee.jsp");
     }else{
             HttpSession sesion=request.getSession();
             sesion.setAttribute("cui", tmp.getCui());
             s.print(tipo);
        switch(tipo){
             
            case "encargado de empleado":
                response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp");
    
                break;
                    case "recepcionista":
                 response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp");
    
                break;
                
                            case "Operador":
                 response.sendRedirect("/HospitalProject/operador/indexoperador.jsp");
    
                break;
                
                            case "enfermera":
                 response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp");
    
                break;
                
                            case "gerente":
            response.sendRedirect("/HospitalProject/gerente/principalManager.jsp");
    
                break;
                
        
        }
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
