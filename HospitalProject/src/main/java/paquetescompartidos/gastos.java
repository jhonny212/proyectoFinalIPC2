/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonny
 */
public class gastos {
    public static String  gastosHabitacion(){
        String error="";
        Calendar fecha=Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String date=Integer.toString(año)+"-"+Integer.toString(mes)+"-28";
    if(dia>=28){
    error= pagos(date);   
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
    String sql="insert into gastoHabitacion (idcrearHabitacion, gasto, fecha) select a.idcrearHabitacion, a.costo*30, '"+date+"' from crearHabitacion a ";
        try {
            PreparedStatement insert=iniciarconeccion.coneccion.prepareStatement(sql);
            insert.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
   return error; }
    public static String pagos(String dates){
        String error="";
    String sql="select a.sueldo, a.idcontratoEmpleado,b.precio, ( (a.sueldo*b.precio)/100) as descuento from contratoEmpleado a join datosGlobales b where (a.estado='libre' or a.estado='ocupado') && (b.nombreDatos='irtra' or b.nombreDatos='iggs' )order by(a.idcontratoEmpleado) ;";
    
    String startDate=dates;
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            ResultSet res=prepared.executeQuery();
            int count=1;
            double descuento=0;
            double sueldo=0;
            boolean validar=true;
            int cod=0;
            while(res.next()){
               descuento+=res.getDouble("descuento");
           
            
                if(count==2){
                     sql="INSERT INTO pagoempleado (fecha,pago,descuento, idcontratoEmpleado) values(?,?,?,?)";
                     PreparedStatement prepareD=iniciarconeccion.coneccion.prepareStatement(sql);
                     prepareD.setDate(1, sqlStartDate);
                     prepareD.setDouble(2, res.getDouble("a.sueldo"));
                     prepareD.setDouble(3, descuento);
                     prepareD.setInt(4, res.getInt("a.idcontratoEmpleado"));
                     prepareD.executeUpdate();
                    count=0;
                    descuento=0;
                    sueldo=0;
                    cod=0;
                }
            count++;
            }
        } catch (SQLException ex) {
        
        }
    
        sql="select datediff( '"+dates+"', a.fecha ) as diferencia, a.cui , a.sueldo*a.meses as total, a.meses*30 as days from contratoTemporal a where a.estado='libre'; ";
        try {
            PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
            ResultSet res=p.executeQuery();
            while(res.next()){
               error= res.getString("diferencia");
            if(res.getFloat("diferencia")>res.getInt("days"))
            {
            sql="INSERT INTO pagoempleadotemporal (cui, pago) values(?,?)";
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setInt(1, res.getInt("a.cui"));
            prepared.setDouble(2, res.getDouble("total"));
            prepared.executeUpdate();
            sql="update contratoTemporal set estado='away' where cui=?";
            PreparedStatement prepareD=iniciarconeccion.coneccion.prepareStatement(sql);
            prepareD.setInt(1, res.getInt("a.cui"));
           
            prepareD.executeUpdate();
            
            }            
            }
        } catch (SQLException ex) {
        error=ex.getMessage();
        }
   return error; }
}
