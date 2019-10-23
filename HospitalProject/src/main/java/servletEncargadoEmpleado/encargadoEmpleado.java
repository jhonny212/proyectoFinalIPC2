/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEncargadoEmpleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class encargadoEmpleado {
    private String error;
 /*    public boolean actualizarTarifario(HttpServletRequest request){
    boolean validar=true;
    return validar;}*/
     
    private String nombre;
    private int cui;
    private String direccion;
    private int telefono;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
      public boolean actualizarVacaciones(HttpServletRequest request){
    boolean validar=true;
                String startDate=request.getParameter("fecha");
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
      
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
            sql="UPDATE contratoEmpleado SET vacaciones=? WHERE cui=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setDate(1, sqlStartDate);
           iniciarSesion.setInt(2,Integer.parseInt(request.getParameter("cui")));
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            }
    
    return validar;}
      
      
            public encargadoEmpleado asignarVacaciones(String cui,String d){
    encargadoEmpleado tmp=new encargadoEmpleado();
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
            sql="select * from contratoEmpleado where cui=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(cui));
            ResultSet res=iniciarSesion.executeQuery();
            if(d!="1"){
            if(res.next()){
            if(res.getDate("vacaciones")==null){
            tmp.setCui(res.getInt("cui"));
            tmp.setDireccion(res.getString("direccion"));
            tmp.setNombre(res.getString("nombre"));
            tmp.setTelefono(res.getInt("telefono"));
            }
            }}else{
               if(res.next()){
            tmp.setCui(res.getInt("cui"));
            tmp.setDireccion(res.getString("direccion"));
            tmp.setNombre(res.getString("nombre"));
            tmp.setTelefono(res.getInt("idcontratoEmpleado"));
            
            }
            }
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            tmp=null;
        
            }catch(NumberFormatException e){
            tmp=null;
            }catch(NullPointerException es){
            }
    
    return tmp;}

}
