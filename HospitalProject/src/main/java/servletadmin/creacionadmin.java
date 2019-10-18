/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletadmin;

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
public class creacionadmin extends administrador{
    
    public creacionadmin(HttpServletRequest request) {
        super(request);
    }
    public boolean crearAreaDeTrabajo(administrador tmp, HttpServletRequest request){
             String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
        double cst=0.0;
        cst=Double.parseDouble(request.getParameter("costo"));
        
    String sql="INSERT INTO areaDeTrabajo (nombre, costo, fechaDeCreacion,usuario,modulo) VALUES (?,?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, request.getParameter("nombre"));
            crearusuario.setDouble(2, cst); 
            crearusuario.setDate(3, sqlStartDate);
           // crearusuario.setString(4, tmp.getUsuario());
            crearusuario.setString(4, "f");
            crearusuario.setString(5, request.getParameter("modulo"));
            
           
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.localError=ex.getMessage();
    
        }
    
    return validar;}

    public boolean crearAreaHabitacion(administrador tmp, HttpServletRequest request){
        String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
        double cst=0.0;
        cst=Double.parseDouble(request.getParameter("costo"));
        
    String sql="INSERT INTO crearHabitacion (descripcion, costo, fecha,usuario,nombre) VALUES (?,?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, request.getParameter("descripcion") );
            crearusuario.setDouble(2, cst); 
            crearusuario.setDate(3, sqlStartDate);
         //   crearusuario.setString(4, tmp.getUsuario());
          crearusuario.setString(4, "f");
            crearusuario.setString(5, request.getParameter("area") );
           
           
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.localError=ex.getMessage();
    
        }
    
    return validar;
    }
    
        public boolean crearEmpleo(administrador tmp, HttpServletRequest request){
          String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
        double cst=0.0;
        cst=Double.parseDouble(request.getParameter("costo"));
        
    String sql="INSERT INTO crearEmpleo (nombreEmpleo,fecha, sueldo,nombre) VALUES (?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1,request.getParameter("nombre"));
            crearusuario.setDouble(3, cst); 
            crearusuario.setDate(2, sqlStartDate);
            crearusuario.setString(4,request.getParameter("area"));
          
            
           
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.localError=ex.getMessage();
    
        }
    
    return validar;}
    
            public boolean crearOperaciones(administrador tmp, HttpServletRequest request){
           String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
        double cst=0.0;
        cst=Double.parseDouble(request.getParameter("costo"));
        
    String sql="INSERT INTO operaciones (nombreOperacion,tarifa, fecha,tipo) VALUES (?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1,request.getParameter("nombre"));
            crearusuario.setDouble(2, cst); 
            crearusuario.setDate(3, sqlStartDate);
            crearusuario.setString(4,request.getParameter("tipo"));
          
            
           
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.localError=ex.getMessage();
    
        }
    
    return validar;}
    
    
}