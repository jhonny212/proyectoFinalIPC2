/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servletrecepcion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class internado {
    private final int cui;

    public int getCui() {
        return cui;
    }

    public int getId() {
        return id;
    }

    public Date getSqlStartDate() {
        return sqlStartDate;
    }
    private final int id;
      private final  java.sql.Date sqlStartDate;
    public internado(HttpServletRequest request){
          String startDate=request.getParameter("fecha");
     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
            
       
        }
    this.sqlStartDate = new java.sql.Date(date.getTime());
    this.cui=Integer.parseInt(request.getParameter("cui"));
    this.id=Integer.parseInt(request.getParameter("habitacion"));
    this.nombre=request.getParameter("nombre");
    }

    public String getNombre() {
        return nombre;
    }
    private final String nombre;
    public static boolean internar(internado tmp){
        boolean validar=true;
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}
    String sql="INSERT INTO internado (cui,fechaEntrada, idcrearHabitacion, nombre) VALUES (?,?,?,?)";
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setInt(1, tmp.getCui());
            prepared.setDate(2, tmp.getSqlStartDate());
            prepared.setInt(3, tmp.getId());
            prepared.setString(4, tmp.getNombre());
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
            validar=false;
        }
    return validar;
    }

}
