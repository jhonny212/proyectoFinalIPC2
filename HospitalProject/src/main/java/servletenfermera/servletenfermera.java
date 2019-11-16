/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletenfermera;

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
import javax.servlet.http.HttpSession;
import paquetescompartidos.iniciarconeccion;
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
       if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
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
                 s.print(cui);
                 s.print(id1);
                 enfermera.update(cui, id1);
              response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=1");
              
                break;
              case "2":
                 
                enfermera.update(cui, id1);
                response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=2");
             
                break;  
              case "3":
                  
                  break;
              case "4":
              
                  if(colamedicamento.colamedicamento(request)){
              response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=4&error=erro");
                  
                  }else{
              response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=4&error=error");
                  }
                  break;
                  
              case "5":
                  
                   String SSQL="select a.idcontratoEmpleado from medicosDestinados a join internado b where b.estado='No' && a.idinternado='"+request.getParameter("dato")+"' ;";
         
            try {
                PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(SSQL);
                ResultSet GetR=prepared.executeQuery();
               
                while(GetR.next()){
                    s.print(GetR.getInt("a.idcontratoEmpleado")+"aca");
                SSQL="UPDATE contratoEmpleado SET estado='libre'  WHERE idcontratoEmpleado=? ";
                PreparedStatement PP=iniciarconeccion.coneccion.prepareStatement(SSQL);
                PP.setInt(1, GetR.getInt("a.idcontratoEmpleado"));
                PP.executeUpdate();
                }
                SSQL="UPDATE internado SET estado='Si' WHERE idinternado=?";
                PreparedStatement TT=iniciarconeccion.coneccion.prepareStatement(SSQL);
                TT.setInt(1, Integer.parseInt(request.getParameter("dato")));
                TT.executeUpdate();
            } catch (SQLException ex) {
                s.print(ex.getMessage());
            }
            
        
         try {
                SSQL="select a.cui from especialistaDestinado a where a.idinternado=?;";
                PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(SSQL);
                prepared.setInt(1, Integer.parseInt(request.getParameter("dato")));
                ResultSet GetR=prepared.executeQuery();
               
                while(GetR.next()){
                SSQL="UPDATE especialista SET estado='libre'  WHERE cui=? ";
                PreparedStatement PP=iniciarconeccion.coneccion.prepareStatement(SSQL);
                PP.setInt(1, GetR.getInt("a.cui"));
                PP.executeUpdate();
                }
               
            } catch (SQLException ex) {
                s.print(ex.getMessage());
            }
            
                  response.sendRedirect("/HospitalProject/enfermera/indexnurse.jsp?id=5&error=erro");
              
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
