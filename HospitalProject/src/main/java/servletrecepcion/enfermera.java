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
public class enfermera {
    public enfermera(){}
     private String nombre;
     private int id;
     private int cui;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }
    public  static LinkedList medico(String tipo){
   LinkedList<enfermera>  tmp=new LinkedList();
   
   if(iniciarconeccion.coneccion==null)
   {iniciarconeccion.IniciarConeccion();}
   
   String sql="SELECT * FROM contratoEmpleado WHERE estado2='activo' && estado='libre' && nombreEmpleo='enfermera' ";
   
       try {
           PreparedStatement getmedico=iniciarconeccion.coneccion.prepareStatement(sql);
           ResultSet res=getmedico.executeQuery();
           while(res.next()){
           enfermera tmpw=new enfermera();
          if(tipo.equals("")){
           tmpw.setNombre(res.getString("nombre"));
           
           }else{
           tmpw.setNombre(res.getString("nombre")+":"+Integer.toString(res.getInt("idcontratoEmpleado")));
          }
          tmpw.setCui(res.getInt("cui"));
          tmpw.setId(res.getInt("idcontratoEmpleado"));
          tmp.add(tmpw);
           }
           
       } catch (SQLException ex) {
       }
   
   
   
   return tmp;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static void asignarEmpleado(int id,int id2){
       if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}
       
    String sql="INSERT INTO medicosDestinados (idinternado, idcontratoEmpleado) VALUES (?,?)";
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.setInt(2, id2);
            actualizar(id2);
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
    public static int codigo(String codigo){
    int id=0;
    String array []=codigo.split(":");
    id=Integer.parseInt(array[1]);
    
    return id;}
    public static int id(HttpServletRequest request){
        internado tmp=new internado(request);
    int id=0;
    String sql="SELECT * FROM internado WHERE cui=?  ";
   
       try {
           PreparedStatement getmedico=iniciarconeccion.coneccion.prepareStatement(sql);
           getmedico.setInt(1, tmp.getCui());
           ResultSet res=getmedico.executeQuery();
           if(res.next()){
           id=res.getInt("idinternado");
           }
           
       } catch (SQLException ex) {
       }
    
    return id;}
    
    public static void actualizar(int id){
           if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();}
       
    String sql="UPDATE contratoEmpleado SET estado='ocupado' WHERE idcontratoEmpleado=?";
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
        prepared.setInt(1, id);
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
}
