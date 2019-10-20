/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEncargadoEmpleado;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class encargadoEmpleado {
    private String error;
     public boolean actualizarTarifario(HttpServletRequest request){
    boolean validar=true;
    return validar;}
     
      public boolean actualizarVacaciones(HttpServletRequest request){
    boolean validar=true;
    
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
            sql="UPDATE operaciones (SET tarifa=?) WHERE nombreOperacion=?";
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion.setInt(1,Integer.parseInt(request.getParameter("precio")));
           iniciarSesion.executeUpdate();
     
       } catch (SQLException ex) {
            this.error=ex.getMessage();
            }
    
    return validar;}
}
