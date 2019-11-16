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
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public operaciones(){
     this.nombre="";
    this.precio=0;
    this.tarifa=0;
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

            
         public void actualizarVacaciones(){
                   Calendar fecha = new GregorianCalendar();
                 
      
    if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
            }
        try {
           String sql=null;
           String sql2;
           sql2="select * from contratoEmpleado where estado3='activo'";
         
           PreparedStatement iniciarSesion=iniciarconeccion.coneccion.prepareStatement(sql2);
           
          
          
           ResultSet res=iniciarSesion.executeQuery();
           
           while(res.next())
           {
           if(res.getDate("vacaciones")==null){
                int año = fecha.get(Calendar.YEAR);
                  Random aleatorio = new Random();
                  int dia=aleatorio.nextInt(28)+1;
                  int mes=aleatorio.nextInt(8)+2;
                String startDate=año+"-"+mes+"-"+dia;
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
       
        }
 java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
            sql="UPDATE contratoEmpleado SET vacaciones=? WHERE cui=?";
            
           PreparedStatement iniciarSesion2=iniciarconeccion.coneccion.prepareStatement(sql);
           iniciarSesion2.setDate(1, sqlStartDate);
           iniciarSesion2.setInt(2, res.getInt("cui"));
             iniciarSesion2.executeUpdate();
           }
           }           
          
       } catch (SQLException ex) {
            }
    
   }     
            
            
    public String getNombre() {
        return nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public int getPrecio() {
        return precio;
    }
    
    public static LinkedList  Updateemployee(){
       LinkedList <String> tmp=new LinkedList();
    Calendar fechA=Calendar.getInstance();
    int año=fechA.get(Calendar.YEAR);
    int mes=fechA.get(Calendar.MONTH)+1;
    int dia=fechA.get(Calendar.DAY_OF_MONTH);
    String fecha=Integer.toString(año)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia);
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
        String sql="select a.precio, interval a.precio day +b.vacaciones as fechados,datediff(interval a.precio day +b.vacaciones,'"+fecha+"') as diferencia,b.idcontratoEmpleado, b.vacaciones, b.idcontratoEmpleado as id from contratoEmpleado b join datosGlobales a where a.nombreDatos='dias de vacaciones' && b.estado3='activo';";
        try {
            PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
            ResultSet r=p.executeQuery();
            String sql2="";
            while(r.next()){
            
               tmp.add(fecha);
                 //tmp.add(r.getFloat("diferencia"));
            if(r.getFloat("diferencia")>=0 && r.getFloat("diferencia")<=r.getInt("a.precio") ){
            sql2="UPDATE contratoEmpleado SET estado2='desactivo' WHERE idcontratoEmpleado=?";
            PreparedStatement p2=iniciarconeccion.coneccion.prepareStatement(sql2);
            p2.setInt(1, r.getInt("b.idcontratoEmpleado"));
            p2.executeUpdate();
           
            }else{
             sql2="UPDATE contratoEmpleado SET estado2='activo' WHERE idcontratoEmpleado=?";
            PreparedStatement p2=iniciarconeccion.coneccion.prepareStatement(sql2);
            p2.setInt(1, r.getInt("b.idcontratoEmpleado"));
            p2.executeUpdate();
            }
            }
        } catch (SQLException ex) {
        
        }
    return tmp;} 
}
