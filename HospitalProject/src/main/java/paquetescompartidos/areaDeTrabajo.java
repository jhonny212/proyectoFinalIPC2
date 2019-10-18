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
    
}
