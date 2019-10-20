/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEncargadoArea;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class encargadoArea {
     public boolean deshabilitarHabitacion(HttpServletRequest request){
    boolean validar=true;
     String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
    String tmp="";
    String ct="deshabilitado";
    if(actualizarHabitacion(tmp,ct)){
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
       String sql="INSERT INTO pagoHabitacion (descripcion,idcrearHabitacion,costo,fecha1) VALUES (?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, request.getParameter("descripcion"));
            crearusuario.setInt(2, Integer.parseInt(tmp));
             crearusuario.setInt(3,Integer.parseInt(request.getParameter("costo")) );
            crearusuario.setDate(4, sqlStartDate);
             crearusuario.executeUpdate();
   
       } catch (SQLException ex) {
            }
    }else{
    validar=false;
    }
    
    return validar;}
    
    public boolean actualizarHabitacion(String tmps,String ct){
    boolean validar=true;
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
            sql="UPDATE crearHabitacion (SET estado=?) WHERE idcrearHabitacion=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1,ct);
              iniciarSesion.setInt(2,Integer.parseInt( tmps));
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            }
    return validar;}
    
     public boolean habilitarHabitacion(HttpServletRequest request){
    boolean validar=true;
     String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
    String tmp="";
    String ct="habilitado";
    if(actualizarHabitacion(tmp,ct)){
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
       String sql="";
         sql="UPDATE pagoHabitacion (SET fecha2=?) WHERE idpagoHabitacion=?";
          
               PreparedStatement crearusuario=null;
    
        try {
          
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            }
    }else{
    validar=false;
    }
    
    return validar;}
    
    
}
