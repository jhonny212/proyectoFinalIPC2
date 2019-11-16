/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletrecepcion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import paquetescompartidos.iniciarconeccion;

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
          Calendar fecha=Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
         HttpSession sesion=request.getSession();
        String cui=sesion.getAttribute("cui").toString();
        processRequest(request, response);
        PrintWriter s=response.getWriter();
        if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
        try{
       switch(request.getParameter("ids")){
           case "1":
           try{
        Integer.parseInt(request.getParameter("telefono"));
       
            paciente.registrar(request);
        consulta tmp=new consulta();
        
        tmp.crearconsulta(request);
        response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=1");
       
        }catch(NumberFormatException e){
             consulta tmp=new consulta();
         response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=1");
       
        tmp.crearconsulta(request);
        s.print(e.getMessage());
        }
        
     
        break;
        
           case "2":
              consulta tmps=new consulta();
              tmps.cancelarconsulta(request);
                response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=2");
       
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
                       response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=3");
       
               break;
               
           case "4":
        
         
               String Query="INSERT INTO pagointernado (persona,precio, total, idinternado,fecha) select '"+cui+"', b.precio, b.precio+ sum(c.costo) as total, a.idinternado, curdate()  from internado a   join operaciones b on b.nombreOperacion=a.nombre  join medicamentosUsados c on c.idinternado=a.idinternado where a.idinternado=? && a.estado='Si' group by(a.idinternado) ; ";
       {
           try {
               PreparedStatement Prepared=iniciarconeccion.coneccion.prepareStatement(Query);
               Prepared.setInt(1, Integer.parseInt(request.getParameter("valor")));
               Prepared.executeUpdate();
               Query="update internado set estado='Cancelado' where idinternado=?";
               PreparedStatement PrepareD=iniciarconeccion.coneccion.prepareStatement(Query);
               PrepareD.setInt(1, Integer.parseInt(request.getParameter("valor")));
               PrepareD.executeUpdate();
               
           } catch (SQLException ex) {
               s.print(ex.getMessage());
           }
       }
       response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=4");
               break;
               
           case "5":
               
    String date=Integer.toString(año)+""+Integer.toString(mes);
    ResultSet res=null;
      String query="SELECT a.cantidad, b.costo FROM colamedicamento a join medicamento b on a.nombre=b.nombre WHERE a.idcola=? && a.nombre=?";
               PreparedStatement Prepared=null;
               try {
             
               Prepared=iniciarconeccion.coneccion.prepareStatement(query);
               Prepared.setString(1, date);
               Prepared.setString(2,request.getParameter("valor") );
               res=Prepared.executeQuery();
               if(res.next()){
               if(res.getInt("a.cantidad")>=Integer.parseInt(request.getParameter("cantidad"))){
               query="INSERT INTO pagomedicamento (cui,cantidad,total,persona, fecha, nombre) values (?,?,?,?,curdate(),'"+request.getParameter("valor")+"') ";
               Prepared=iniciarconeccion.coneccion.prepareStatement(query);
               Prepared.setInt(1, Integer.parseInt(request.getParameter("cui")));
               Prepared.setInt(2, Integer.parseInt(request.getParameter("cantidad")));
               
               Prepared.setInt(3, Integer.parseInt(request.getParameter("cantidad"))*res.getInt("b.costo"));
               Prepared.setInt(4, Integer.parseInt(cui));
               Prepared.executeUpdate();
               
               query="UPDATE colamedicamento  set cantidad=?  WHERE idcola=? && nombre=?";
               Prepared=iniciarconeccion.coneccion.prepareStatement(query);
               Prepared.setInt(1, res.getInt("a.cantidad")- Integer.parseInt(request.getParameter("cantidad")));
               Prepared.setString(2, date);
               Prepared.setString(3,request.getParameter("valor") );
               Prepared.executeUpdate();
              
               }
               
               }
                response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=5");
      
           } catch (SQLException ex) {
               s.print(ex.getMessage());
                response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp?id=5");
      
           }
               break;
    }}catch(NumberFormatException e){
         response.sendRedirect("/HospitalProject/recepcionista/indexrecepcion.jsp");
      
    
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
