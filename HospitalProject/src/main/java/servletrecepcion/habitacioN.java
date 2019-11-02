/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletrecepcion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */

public class habitacioN {
 private String tipo;

    public String getTipo() {
        return tipo;
    }
    
    public static LinkedList<String> habitaciones(String letra, String le){
    LinkedList <String> lista=new LinkedList();
   if(iniciarconeccion.coneccion==null){
   iniciarconeccion.IniciarConeccion();}
      
   int count=0;
   try {
            String sql="";
            if(!le.equals("")){
                sql="SELECT * FROM crearHabitacion join operaciones b WHERE nombre='"+letra+"' && estado='habilitado'  && b.nombreOperacion='"+le+"'";
            }else{
                sql="SELECT * FROM crearHabitacion WHERE nombre='"+letra+"' && estado='habilitado'";
            }
            PreparedStatement res=iniciarconeccion.coneccion.prepareStatement(sql);
            ResultSet r=res.executeQuery();
            while(r.next()){
                if(count==0 && !le.equals("")){
            lista.add(r.getString("b.tipo"));
                count++;
                }
            lista.add(Integer.toString(r.getInt("idcrearHabitacion")));
            
            }
        } catch (SQLException ex) {
            lista.add(ex.getMessage());
        }
     
        
    return lista;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setError(String error) {
        this.error = error;
    }
      
     private String error;

    public  String getError() {
        return error;
    }
     public LinkedList disponibilidad(int id){
    LinkedList <consulta> lista=new LinkedList();
     Calendar fecha = new GregorianCalendar();    
            String date=Integer.toString(fecha.get(Calendar.YEAR)+fecha.get(Calendar.MONTH)+fecha.get(Calendar.DAY_OF_MONTH));
       
   if(iniciarconeccion.coneccion==null){
   iniciarconeccion.IniciarConeccion();}
        try {
            PreparedStatement res=iniciarconeccion.coneccion.prepareStatement("SELECT * FROM consulta WHERE idcrearhabitacion=? && idconsulta=? order by (hora) asc");
            res.setInt(1, id);
            res.setString(2, date);
            ResultSet r=res.executeQuery();
            while(r.next()){
            consulta tmp=new consulta();
            tmp.setHora(r.getString("hora"));
            lista.add(tmp);
           }
        } catch (SQLException ex) {
        this.error=ex.getMessage();
        }
    return lista;
    }
          public void disponibilidadOperacion(){
              
    }
    
    
}
