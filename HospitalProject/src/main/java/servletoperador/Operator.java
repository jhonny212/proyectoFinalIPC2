/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletoperador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetescompartidos.iniciarconeccion;
import paquetescompartidos.reporte;


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
              
                    response.sendRedirect("http://localhost:8080/HospitalProject/operador/indexoperador.jsp?id=1");
          
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
                    response.sendRedirect("http://localhost:8080/HospitalProject/operador/indexoperador.jsp?id=3");
          
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
               response.sendRedirect("http://localhost:8080/HospitalProject/operador/indexoperador.jsp?id=2");
               s.print(codigo);
                break;    
                
            case "4":
                 Calendar fecha=Calendar.getInstance();
                   int año=fecha.get(Calendar.YEAR);
                   int mes=fecha.get(Calendar.MONTH)+1;
                  
                  File file=new File("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+request.getParameter("nombre")+".pdf");
                            if(file.exists()){
                        response.sendRedirect("http://localhost:8080/HospitalProject/operador/indexoperador.jsp?id=4&&error=error");
                            }else{
                            
                switch(request.getParameter("codreporte")){
                
                        case "Generar reporte 1":
                       if(!request.getParameter("parametro1").equals("")){
                            Map parametros=new HashMap();
                            parametros.put("idcola", Integer.toString(año)+""+Integer.toString(mes));
                            parametros.put("clave", request.getParameter("parametro1"));
                            reporte report=new reporte();
                            
                          
                           report.reporteOperador(request.getParameter("nombre"), "medicamento", parametros, true);
                            
                        
                        }else{
                           Map parametros=new HashMap();
                            parametros.put("idcola", Integer.toString(año)+""+Integer.toString(mes));
                            reporte report=new reporte();
                            
                          
                           report.reporteOperador(request.getParameter("nombre"), "medicamentotipo2", parametros, false);
                         
                        }
                        break;
                
                          case "Generar reporte 2":
                            
                            if(!request.getParameter("parametro2").equals("")){
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                        
                        java.util.Date date = null;
                        try {
                        date = sdf1.parse(request.getParameter("fecha1"));
                         } catch (ParseException ex) {
                  
                         
                         }
                         
                        java.util.Date date2 = null;
                        try {
                        date2 = sdf2.parse(request.getParameter("fecha2"));
                         } catch (ParseException ex) {
                               s.print("entr");
                         }
                            Map parametroS=new HashMap();
                            parametroS.put("fecha1",date);
                            parametroS.put("fecha2",date2);
                            parametroS.put("clave", request.getParameter("parametro2"));
                             reporte report=new reporte();
                          
             
                String dato=report.reporteOperador(request.getParameter("nombre"), "ganaciamedicamentosv1", parametroS, true);
                s.print(dato+"aca");
      
                        }else{
                           Map parametros=new HashMap();
                            parametros.put("idcola", Integer.toString(año)+""+Integer.toString(mes));
                            reporte report=new reporte();
                            s.print("here");
                          
                        report.reporteOperador(request.getParameter("nombre"), "ganaciamedicamentosv2", parametros, false);
                         
                        }
                              
                              
                        break;
                        
                          case "Generar reporte 3":
                              Map parametroS=new HashMap();
                                reporte report=new reporte();
                                String dato="";
                                request.getParameter("parametro3");
                               try{ 
                            int valor=  returns(  request.getParameter("parametro3"));
                                parametroS.put("cui",valor);
                              
                             dato= report.reporteOperador(request.getParameter("nombre"), "ventamedicametoporempleadov2", parametroS, true);
                               s.print(dato);
                               }catch(NumberFormatException e){
                                  parametroS.put("nombreclave", request.getParameter("parametro3"));
                               
                            dato=report.reporteOperador(request.getParameter("nombre"), "ventamedicametoporempleadov1", parametroS, true);
                             s.print(dato);
                          
                               }
                           response.sendRedirect("http://localhost:8080/HospitalProject/operador/indexoperador.jsp?id=4&&error=erro");
         
                        break;
                }
                                    
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
    public int returns(String a){
    
    return Integer.parseInt(a);}
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
