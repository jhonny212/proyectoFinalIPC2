/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletadmin;

import administracionreportes.gananciasadmin;
import administracionreportes.ingresos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import paquetescompartidos.usuario;

import paquetescompartidos.iniciarconeccion;
import paquetescompartidos.reporte;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "adminsesion", urlPatterns = {"/adminsesion"})
public class adminsesion extends HttpServlet {

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
        PrintWriter s=response.getWriter();
          if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
        processRequest(request, response);
        
      //  administrador tmp=new administrador(request);
        HttpSession sesion=request.getSession();
      
        creacionadmin tmp=new creacionadmin(request);
          switch (request.getParameter("id")){
            case "1":
       
                         try{
                Double.parseDouble(request.getParameter("costo"));
                if(tmp.crearAreaDeTrabajo(sesion.getAttribute("usuario").toString(), request)){
        response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=1&error=erro");
        }else{
        s.print(tmp.getError());
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=1&error=error");
        }
        }catch(NumberFormatException e){
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=1&error=error");
        
        }
        
                break;
            case "2":
               try{
               
                      Double.parseDouble(request.getParameter("costo"));
              
                      if(tmp.crearAreaHabitacion(sesion.getAttribute("usuario").toString(), request)){
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=2&error=erro");
        }else{
        s.print(tmp.getError());
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=2&error=error");
        }
           
               }catch(NumberFormatException e){
                response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=2&error=error");
        
               }
                break;
                
               case "3":
                   
               try{
                         Double.parseDouble(request.getParameter("costo"));
               
               
                         if(tmp.crearEmpleo(sesion.getAttribute("usuario").toString(), request)){
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=3&error=erro");
        }else{
        s.print(tmp.getError());
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=3&error=error");
        }
               }catch(NumberFormatException e){
                 response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=3&error=error");
       
               }
         
      
                break;  
                
                  case "4":
                 try{
                         Double c=      Double.parseDouble(request.getParameter("costo"));
                          Double d=     Double.parseDouble(request.getParameter("precio"));
               
                      
                     if(tmp.crearOperaciones(sesion.getAttribute("usuario").toString(), request)){
          response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=4&error=erro");
        }else{
        s.print(tmp.getError());
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=4&error=error");
        }
                 }catch(NumberFormatException e){
                     s.print(e.getMessage());
                  response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=4&error=error");
        }
                      
         
      
                break; 
                
                  case "5":
                      try{
                  if(tmp.registrarMedico(sesion.getAttribute("usuario").toString(), request)){
          response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=5&error=erro");
        }else{
        s.print(tmp.getError());
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=5&error=error");
        }}catch(NumberFormatException e){
         response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=5&error=error");
        
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
        if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
        PrintWriter s=response.getWriter();
        usuario tmp=new administrador(request);
   
        switch (request.getParameter("id")){
            case "1":
                    if(tmp.crearUsuario(tmp)){
            response.sendRedirect("/HospitalProject/administrador/registrar-administrador.jsp?error=exito");
        }else{
        s.print(tmp.getError());
            response.sendRedirect("/HospitalProject/administrador/registrar-administrador.jsp?error=error");
        }
      
                break;
            case "2":
                    if(tmp.iniciarSesion(tmp)){
            response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp");
            HttpSession sesion=request.getSession();
            
          
            sesion.setAttribute("usuario", tmp.getUsuario());
        }else{
        s.print(tmp.getError()+"aca");
       
           response.sendRedirect("/HospitalProject/administrador/indexAdmin.jsp?error=error");
        }
      
                break;
            case "8":
               File file=new File("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+request.getParameter("nombre")+".pdf"); 
               if(file.exists()){
                   response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=8&error=error");
       
               }else{
               reporte report =new reporte();
               s.print(report.administrador(request.getParameter("nombre"), "", request, true)+"aja");
                   response.sendRedirect("/HospitalProject/administrador/paginaadmin.jsp?id=8&error=erro");
       
               }
               
               
                break;
            
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
