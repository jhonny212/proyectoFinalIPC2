/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletadmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.usuario;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class administrador extends usuario {
    
  
    public String localError;
    @Override
    public String getError() {
      return this.localError; 
    }
    public administrador(HttpServletRequest request) {
        super(request);
    }
    
    @Override
    public boolean  iniciarSesion(usuario tmp){
        boolean validar=true;  
    String sql="SELECT * FROM administrador WHERE usuario=? && contraseña=?";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, tmp.getUsuario());
            crearusuario.setString(2, tmp.getContraseña());
            ResultSet res=crearusuario.executeQuery();
          if(res.next()){
        
           }else{
          validar=false;
          }
        } catch (SQLException ex) {
            validar=false;
             this.localError=ex.getMessage();
    
        }
    
    return validar;
    }
    
    @Override
       public boolean  crearUsuario(usuario tmp){
    boolean validar=true;  
    String sql="INSERT INTO administrador (nombre, usuario, contraseña) VALUES (?,?,?)";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setString(1, tmp.getNombre() );
            crearusuario.setString(2, tmp.getUsuario());
            crearusuario.setString(3, tmp.getContraseña());
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.localError=ex.getMessage();
    
        }
    
    return validar;
    }
}
