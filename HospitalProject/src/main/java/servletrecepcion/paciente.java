/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletrecepcion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class paciente {
    private String nombre;
    private int telefono;
    private int cui;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getCui() {
        return cui;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public  void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public static paciente paciente(int cui){
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}    
    paciente tmp=new paciente();
  
 
    String sql="SELECT * FROM paciente WHERE cui=?";
        try {
           PreparedStatement get=iniciarconeccion.coneccion.prepareStatement(sql);
            get.setInt(1, cui);
            ResultSet res=get.executeQuery();
           if(res.next()){
           tmp.setCui(res.getInt("cui"));
           tmp.setDireccion(res.getString("direccion"));
           tmp.setNombre(res.getString("nombre"));
           tmp.setTelefono(res.getInt("telefono"));
           }
        } catch (SQLException ex) {
        }
    return tmp;}
    public static paciente registrar(HttpServletRequest request){
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}    
    paciente tmp=new paciente();
  
 
    String sql="INSERT INTO paciente (cui,nombre,direccion,telefono) VALUES (?,?,?,?)";
        try {
           PreparedStatement get=iniciarconeccion.coneccion.prepareStatement(sql);
           get.setInt(1, Integer.parseInt(request.getParameter("cui")));
           get.setString(2, request.getParameter("nombre"));
           get.setString(3, request.getParameter("direccion"));
           get.setInt(4, Integer.parseInt(request.getParameter("telefono")));
           get.executeUpdate();
           
        } catch (SQLException ex) {
        }
    return tmp;}
    
    
}
