/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletrecepcion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "recepcion", urlPatterns = {"/recepcion"})
public class recepcion extends HttpServlet {

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
        PrintWriter s=response.getWriter();
        try{
       switch(request.getParameter("ids")){
           case "1":
           try{
        Integer.parseInt(request.getParameter("telefono"));
       
            paciente.registrar(request);
        consulta tmp=new consulta();
        tmp.crearconsulta(request);
        }catch(NumberFormatException e){}
        
     
        break;
        
           case "2":
              consulta tmps=new consulta();
              tmps.cancelarconsulta(request);
              s.print(tmps.getError());
               break;
               
           case "3":
               
            
               internado internar=new internado(request);
               if(internado.internar(internar)){
               enfermera.asignarEmpleado(enfermera.id(request), enfermera.codigo(request.getParameter("enfermera")));
               if(!request.getParameter("seleccion1").equals("No") && request.getParameter("seleccion2").equals("No") ){
                     enfermera.asignarEmpleado(enfermera.id(request), enfermera.codigo(request.getParameter("seleccion1")));
             
                   
               }else if(request.getParameter("seleccion1").equals("No") && !request.getParameter("seleccion2").equals("No")){
                                medico.asignarEmpleado(enfermera.id(request), enfermera.codigo(request.getParameter("seleccion2")));
             
               
               }else if(!request.getParameter("seleccion1").equals("No") && !request.getParameter("seleccion2").equals("No"))
               {
                           enfermera.asignarEmpleado(enfermera.id(request), enfermera.codigo(request.getParameter("seleccion1")));
                           medico.asignarEmpleado(enfermera.id(request), enfermera.codigo(request.getParameter("seleccion2")));
             
               
               }
                   }
              
               break;
    }}catch(NumberFormatException e){
    
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
