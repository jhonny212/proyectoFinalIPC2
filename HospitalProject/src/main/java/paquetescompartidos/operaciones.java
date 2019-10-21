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
public class operaciones {
    private final String nombre;
    private final int tarifa;
    private final int precio;
    public operaciones(String nombre,int tarifa,int precio){
    this.nombre=nombre;
    this.precio=precio;
    this.tarifa=tarifa;
    }
    
            public static LinkedList operaciones(){
    LinkedList <operaciones> tmp=new LinkedList();
    String sql="SELECT * FROM operaciones ";
    PreparedStatement crearusuario=null; 
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();
    }
        try {
          crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
          
          ResultSet res=crearusuario.executeQuery();
          while(res.next()){
         operaciones tmp2=null;
         tmp2=new operaciones(res.getString("nombreOperacion"),res.getInt("tarifa"),res.getInt("precio"));
          tmp.add(tmp2);
          
          }
        } catch (SQLException ex) {
          
        }
    
    return tmp;}

    public String getNombre() {
        return nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public int getPrecio() {
        return precio;
    }
}
