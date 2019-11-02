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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
         if(iniciarconeccion.coneccion==null){
                   iniciarconeccion.IniciarConeccion();
                   }
       switch(request.getParameter("ids")){
       
           case "0":
               
         if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}      
        {
            try {
                String sql="UPDATE contratoEmpleado SET estate='SI' WHERE cui=?";
                PreparedStatement up=iniciarconeccion.coneccion.prepareStatement(sql);
                up.setInt(1, Integer.parseInt(request.getParameter("cui")));
                up.executeUpdate();
                       response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=0&error=erro");
          
              
            } catch (SQLException ex) {
                   response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=0&error=erro");
          
              
            }
        }
               
               
               
               break;
               
               
           case "1":
               tmp.asignarVacaciones(request.getParameter("cui"),"e");
               
                   break;
              case "2":
                  String sql=null;
                  Calendar fecha = new GregorianCalendar();
                  
            {
            try {
                  
                sql="select vacaciones from contratoEmpleado where cui=?";
                PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
               
                iniciarSesion.setInt(1, Integer.parseInt(request.getParameter("cui")));
                ResultSet res=iniciarSesion.executeQuery();
                if(res.next()){
                sql="SELECT DATEDIFF('"+res.getDate("vacaciones")+"','"+fecha.get(Calendar.YEAR)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.DAY_OF_MONTH)+"') as diferencia";
                PreparedStatement iniciarSesion2=iniciarconeccion.coneccion.prepareStatement(sql);
                ResultSet ResultSet2 = iniciarSesion2.executeQuery();
                if(ResultSet2.next()){
                s.print(ResultSet2.getLong(1)+"aca");
                
                if(ResultSet2.getLong("diferencia")>=0){
                if(tmp.actualizarVacaciones(request)){
                         response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=2&error=erro");
          
                }else{
                  response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=2&error=error");
          
                }
                }else{
                         response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=2&error=error");
          
                }
                }else{
                   response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=2&error=error");
          
                }
                }
                
            } catch (SQLException ex) {
                s.print(ex.getMessage());
            }
            }
           
                  
                   break;
             case "3":
                    if(tmp.actualizarEmpleado(request, 2) ){
                  response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=3&error=erro");
          
                    }else
                    {
                     response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=3&error=error");
                        s.print(tmp.getError());
                    }
                    
                   break;        
               case "4":
                                       if(tmp.actualizarEmpleado(request, 1)){
                   response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=4&error=erro");
          
                    }else
                    {
                     response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=4&error=error");
          
                    }
                   break;    
           case "5":
               
               
                   break;
                   
              case "6":
                 empleado a=new empleado(Integer.parseInt(request.getParameter("cui")),request.getParameter("contra"));
                 
                 if(a.crearUsuario(a)){
                         response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=6&error=erro");
          
                  
                  }else{
                 response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=6&error=error");
                s.print(a.getError()+"aca");
                  
                  }
                  break;
                   
             case "7":
                   break;    
                   
               case "8":
                   
                   String Sql="UPDATE contratoEmpleado a SET a.sueldo=a.sueldo+'"+request.getParameter("aumento")+"' where a.cui=? ";
               {
            try {
                PreparedStatement act=iniciarconeccion.coneccion.prepareStatement(Sql);
                act.setInt(1, Integer.parseInt(request.getParameter("cui")));
                act.executeUpdate();
                            response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=8&error=erro");
          
             
            } catch (SQLException ex) {
                            response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=8&error=erro");
          
             
                s.print(ex.getMessage());
            }
        }
                   
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
      
        if(tmp.crearUsuario(tmp)){
                response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=6&error=erro");
          
                 
        }else{
                response.sendRedirect("/HospitalProject/encargadoEmpleado/principalEncargado.jsp?id=6&error=error");
          
                 
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
