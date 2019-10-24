/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEncargadoEmpleado;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetescompartidos.empleado;
import paquetescompartidos.iniciarconeccion;
import paquetescompartidos.usuario;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "encargado", urlPatterns = {"/encargado"})
public class encargado extends HttpServlet {

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
        encargadoEmpleado tmp=new encargadoEmpleado();
        PrintWriter s=response.getWriter();
        
       switch(request.getParameter("ids")){
       
           case "1":
               tmp.asignarVacaciones(request.getParameter("cui"),"e");
                   break;
              case "2":
                  String sql=null;
            sql="SELECT DATEDIFF('1997-12-31 ','1997-12-30') as diferencia";
             {
            try {
                PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
                tmp.actualizarVacaciones(request);
            } catch (SQLException ex) {
            }
            }
           
                  
                   break;
             case "3":
                   break;        
               case "4":
                   break;    
           case "5":
                   break;
                   
              case "6":
                   break;
                   
             case "7":
                   break;    
                   
               case "8":
                   break;          
       }
        //tmp.actualizarVacaciones(request);
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
        PrintWriter s=response.getWriter();
        processRequest(request, response);
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();
    }
            empleado tmp=new empleado(Integer.parseInt(request.getParameter("cui")),request.getParameter("contra"));
             boolean validar=false;  
            String sql="SELECT idcontratoEmpleado FROM contratoEmpleado WHERE cui=?";
            PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setInt(1, tmp.getCui());
         
            ResultSet res=crearusuario.executeQuery();
            if(res.next()){
            validar=true;
            tmp.setId(res.getInt("idcontratoEmpleado"));
            }
        } catch (SQLException ex) {
            validar=false;
            s.print(ex.getMessage());
        }
        if(validar){
      
        tmp.crearUsuario(tmp);
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
