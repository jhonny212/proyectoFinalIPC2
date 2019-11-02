/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletoperador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
@WebServlet(name = "Operator", urlPatterns = {"/Operator"})
public class Operator extends HttpServlet {

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
        if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
        switch(request.getParameter("ids")){
            case "1":
                medicamento tmp=null;
                try{
                tmp=new medicamento(request);
               if(tmp.actualizar(tmp)){
                }else{
                }
                s.print(tmp.getError());
                }catch(NumberFormatException e){
                }
              
                break;
               
                
            case "2":
               
              medicamento medicamento=new medicamento();
                    Calendar fechA = Calendar.getInstance();
                    String getFecha=Integer.toString(fechA.get(Calendar.YEAR));
                   getFecha+=Integer.toString(fechA.get(Calendar.MONTH)+1);
                if(medicamento.Colamedicamento(request, getFecha)){
                   
                   }else{
                   s.print(medicamento.getError()+"aca");
                   }
              break;
            
            case "3":
               int codigo=0;
               if(request.getParameter("cantidad").equals("0") && request.getParameter("costo").equals("0") )
               {
               }else if(request.getParameter("cantidad").equals("0") && !request.getParameter("costo").equals("0")){
               codigo=1;
               }else if(!request.getParameter("cantidad").equals("0") && request.getParameter("costo").equals("0")){
               codigo=2;
               }else if(!request.getParameter("cantidad").equals("0") && !request.getParameter("costo").equals("0")){
               codigo=3;
               }
               medicamento medi=new medicamento();
               medi.actualizarMedicamento(codigo, request);
               
               s.print(codigo);
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
