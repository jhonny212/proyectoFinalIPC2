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
           sql2="select * from contratoEmpleado";
         
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
}
