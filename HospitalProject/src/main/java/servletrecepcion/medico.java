/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletrecepcion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class medico {
   private int cui;
   private int id;

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   private String nombre;
    public  static LinkedList medico(String tipo){
   LinkedList<medico>  tmp=new LinkedList();
   
   if(iniciarconeccion.coneccion==null)
   {iniciarconeccion.IniciarConeccion();}
   
   String sql="SELECT * FROM contratoEmpleado WHERE estado2='activo' && estado='libre' && nombreEmpleo='medico' ";
   
       try {
           PreparedStatement getmedico=iniciarconeccion.coneccion.prepareStatement(sql);
           ResultSet res=getmedico.executeQuery();
           while(res.next()){
           medico tmpw=new medico();
           tmpw.setCui(res.getInt("cui"));
           if(tipo.equals("")){
           tmpw.setNombre(res.getString("nombre"));
           
           }else{
           tmpw.setNombre(res.getString("nombre")+":"+Integer.toString(res.getInt("idcontratoEmpleado")));
           }tmpw.setId(res.getInt("idcontratoEmpleado"));
           tmp.add(tmpw);
           }
           
       } catch (SQLException ex) {
       }
   
   
   
   return tmp;} 
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        public  static LinkedList medicoEspecialista(String tipo){
   LinkedList<medico>  tmp=new LinkedList();
   
   if(iniciarconeccion.coneccion==null)
   {iniciarconeccion.IniciarConeccion();}
   
   String sql="";
   if(tipo.equals("3")){
   sql="select * from especialista where estado='libre' ";}else{
       
   sql="SELECT * FROM contratoEmpleado WHERE estado2='activo' && estado='libre' && nombreEmpleo='medico' ";}
    
       try {
           PreparedStatement getmedico=iniciarconeccion.coneccion.prepareStatement(sql);
           ResultSet res=getmedico.executeQuery();
           while(res.next()){
           medico tmpw=new medico();
           if(tipo.equals("3")){
           tmpw.setCui(res.getInt("cui"));
          tmpw.setDireccion(res.getString("direccion"));
           tmpw.setNombre(res.getString("nombre")+":"+Integer.toString(res.getInt("cui")));
           tmp.add(tmpw);}else{
           tmpw.setNombre(res.getString("nombre")+":"+Integer.toString(res.getInt("idcontratoEmpleado")));
           tmp.add(tmpw);
           }
           }
           
       } catch (SQLException ex) {
       }
   
   
   
   return tmp;} 
            public static void asignarEmpleado(int id,int id2){
       if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}
       
    String sql="INSERT INTO especialistaDestinado (idinternado, cui) VALUES (?,?)";
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.setInt(2, id2);
            actualizar(id2);
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
               public static void actualizar(int id){
           if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}
       
    String sql="UPDATE especialista SET estado='ocupado' WHERE cui=?";
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
        prepared.setInt(1, id);
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
}
