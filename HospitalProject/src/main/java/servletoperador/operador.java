/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletoperador;

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
public class operador {
    public boolean registrar(HttpServletRequest request){
                    String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
     
      
    String sql="INSERT INTO medicamento (nombre,fecha,cantidad,minimo) VALUES (?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, request.getParameter("nombre"));
            crearusuario.setDate(2, sqlStartDate);
            crearusuario.setInt(3,Integer.parseInt(request.getParameter("catidad")));
           
            crearusuario.setInt(4,Integer.parseInt(request.getParameter("minimo")));
           
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;

        }

        
    return validar;}
     public boolean actulizar(HttpServletRequest request){
    boolean validar=true;
        
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           sql="UPDATE medicamento SET precio=? WHERE nombreDatos=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("costo")));
        
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            validar=false;
            
            }
    return validar;}
      public boolean actualizarMinimo(){
    boolean validar=true;
        
    return validar;}
}
