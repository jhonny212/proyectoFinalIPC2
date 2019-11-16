/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletGerente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.empleado;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class gerente    
{
private String error;

    public String getError() {
        return error;
    }
    public boolean actualizarTarifario(HttpServletRequest request){
    boolean validar=true;
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
            sql="UPDATE operaciones SET tarifa=? WHERE nombreOperacion=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("precio")));
           iniciarSesion.setString(2,request.getParameter("id"));
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            validar=false;
            }catch(NumberFormatException e){
            this.error=e.getMessage();
            validar=false;
            
            }
    
    return validar;}
     public boolean actualizarGlobal(HttpServletRequest request){
    boolean validar=true;
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
            String act=request.getParameter("iddato");
           String sql=null;
           sql="UPDATE datosGlobales SET precio=? WHERE nombreDatos=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("costo")));
           iniciarSesion.setString(2, act);
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            validar=false;
            }catch(NumberFormatException e){
            this.error=e.getMessage();
            validar=false;
            
            }
    
    return validar;}
     
      public boolean contratar(HttpServletRequest request,empleado tmp){
            String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
     
      
    String sql="INSERT INTO contratoEmpleado (estado,fecha,nombreEmpleo,cui,horas,sueldo,nombre,direccion,telefono,estado2,estado3) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, "libre");
            crearusuario.setDate(2, sqlStartDate);
           crearusuario.setString(3, tmp.getNombreEmpleo());
           crearusuario.setInt(4, tmp.getCui());
           crearusuario.setInt(5,tmp.getHoras());
           crearusuario.setInt(6, tmp.getSueldo());
           crearusuario.setString(7, tmp.getNombre());
           crearusuario.setString(8,tmp.getDireccion());
           crearusuario.setInt(9,tmp.getTelefono());
           crearusuario.setString(10,"activo"); 
            crearusuario.setString(11,"activo"); 
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
    this.error=ex.getMessage();
        }
    
    return validar;}
     
            public boolean contratarTemporal(HttpServletRequest request,empleado tmp){
            String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       this.error=ex.getMessage();
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
     
      
    String sql="INSERT INTO contratoTemporal(nombre,cui,direccion,telefono,estado,sueldo,meses,fecha) VALUES (?,?,?,?,?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            
          
           crearusuario.setString(1, tmp.getNombre());
            crearusuario.setInt(2, tmp.getCui());
           crearusuario.setString(3,tmp.getDireccion());
            crearusuario.setInt(4,tmp.getTelefono());
           crearusuario.setString(5, "libre");
           crearusuario.setInt(6, tmp.getSueldo());
           crearusuario.setInt(7,tmp.getHoras());
          crearusuario.setDate(8, sqlStartDate);
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
    this.error=ex.getMessage();
        }
    
    return validar;}
      
            public boolean generarPago(HttpServletRequest request){
            String startDate=request.getParameter("fecha");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       this.error=ex.getMessage();
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        boolean validar=true;
     
      
    String sql="INSERT INTO pagoHabitacion(descripcion,idcrearHabitacion,costo,fecha1) VALUES (?,?,?,?)";
    PreparedStatement crearusuario=null;
    
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
          crearusuario.setString(1, request.getParameter("descripcion"));
          crearusuario.setInt(2,Integer.parseInt(request.getParameter("btn")));
          crearusuario.setInt(3,Integer.parseInt(request.getParameter("costo")));
           crearusuario.setDate(4, sqlStartDate);
           crearusuario.executeUpdate();
           actualizarHabitacion(request,"deshabilitado");
        } catch (SQLException ex  ) {
            validar=false;
    this.error=ex.getMessage();
        }catch(NumberFormatException s){
        validar=false;
    this.error=s.getMessage();
        }
    
    return validar;}
     
 public boolean actualizarHabitacion(HttpServletRequest request, String c){
    boolean validar=true;
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           sql="UPDATE crearHabitacion SET estado=? WHERE idcrearHabitacion=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setString(1, c);
           iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("btn")) );
           
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            validar=false;
            }catch(NumberFormatException e){
            this.error=e.getMessage();
            validar=false;
            
            }
    
    return validar;}
 
  public boolean actualizarPAgo(HttpServletRequest request, String c){
    boolean validar=true;
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
     String startDate=request.getParameter("fecha");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       this.error=ex.getMessage();
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
        
        try {
           String sql=null;
           sql="UPDATE pagoHabitacion SET fecha2=? WHERE idcrearHabitacion=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setDate(1, sqlStartDate);
           iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("btn")) );
           
           iniciarSesion.executeUpdate();
           actualizarHabitacion(request,"habilitado");
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            validar=false;
            }catch(NumberFormatException e){
            this.error=e.getMessage();
            validar=false;
            
            }
    
    return validar;}
     
}
