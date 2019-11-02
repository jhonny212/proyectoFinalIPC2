/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author jhonny
 */
public class gastos {
    public static void gastosHabitacion(){
    Calendar fecha=Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String date=Integer.toString(año)+"-"+Integer.toString(mes)+"-28";
    if(dia>=28){
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
    String sql="insert into gastoHabitacion (idcrearHabitacion, gasto, fecha) select a.idcrearHabitacion, a.costo*30, '"+date+"' from crearHabitacion a ";
        try {
            PreparedStatement insert=iniciarconeccion.coneccion.prepareStatement(sql);
            insert.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    }
}
