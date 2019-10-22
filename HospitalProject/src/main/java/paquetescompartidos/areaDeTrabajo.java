/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author jhonny
 */
public class areaDeTrabajo {
    public areaDeTrabajo(){}
    private  int id;
    private String descripcion;
    private String estado;
    public areaDeTrabajo(int id, String descripcion){
    this.descripcion=descripcion;
    this.id=id;
    }
    public areaDeTrabajo(int id, String descripcion, String estado){
    this.descripcion=descripcion;
    this.id=id;
    this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public LinkedList areas(){
    LinkedList <String> tmp=new LinkedList();
    String sql="SELECT * FROM areaDeTrabajo ";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
          
          ResultSet res=crearusuario.executeQuery();
          while(res.next()){
          tmp.add(res.getString("nombre"));
          }
        } catch (SQLException ex) {
          
        }
    
    return tmp;}
    
        public LinkedList habitacion(String area){
    LinkedList <areaDeTrabajo> tmp=new LinkedList();
    String sql="SELECT idcrearHabitacion, descripcion FROM crearHabitacion WHERE nombre=? && estado=? ";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
           crearusuario.setString(1, area);
                 crearusuario.setString(2,"habilitado");
          ResultSet res=crearusuario.executeQuery();
          while(res.next()){
          areaDeTrabajo k=new areaDeTrabajo(res.getInt("idcrearHabitacion"),res.getString("descripcion"));
          tmp.add(k);
          }
        } catch (SQLException ex) {
          
        }
    
    return tmp;}
        
          public LinkedList habitacioN(String area){
    LinkedList <areaDeTrabajo> tmp=new LinkedList();
    String sql="SELECT idcrearHabitacion, descripcion, estado FROM crearHabitacion WHERE nombre=? && estado=? ";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
           crearusuario.setString(1, area);
            crearusuario.setString(2, "deshabilitado");
          ResultSet res=crearusuario.executeQuery();
          while(res.next()){
          areaDeTrabajo k=new areaDeTrabajo(res.getInt("idcrearHabitacion"),res.getString("descripcion"),res.getString("estado"));
          tmp.add(k);
          }
        } catch (SQLException ex) {
          
        }
    
    return tmp;}
    
    
    
}
