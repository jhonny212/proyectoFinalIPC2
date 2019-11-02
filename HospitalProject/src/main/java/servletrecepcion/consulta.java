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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class consulta {
     private String hora;
    private String valid;
    private int cui;
    private int id;
    private int id2;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

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

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
    private String error;

    public String getError() {
        return error;
    }
    public consulta(){}
    public consulta(HttpServletRequest request){
    this.hora=request.getParameter("hora");
    try{
    this.id=Integer.parseInt(request.getParameter("idconsulta"));
     }catch(NumberFormatException e){}
    this.id2=Integer.parseInt(request.getParameter("habitacion"));
    }
    public void crearconsulta(HttpServletRequest request){
             String array[]=request.getParameter("time").split(":");
           
            Calendar fecha = new GregorianCalendar();    
               int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    int dia=fecha.get(Calendar.DAY_OF_MONTH);
    String date=Integer.toString(año)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia);
            if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
         try {
             PreparedStatement r=iniciarconeccion.coneccion.prepareStatement("INSERT INTO consulta (idconsulta, cui,idcrearhabitacion,idcontratoempleado,hora,cancelado) VALUES (?,?,?,?,?,?)");
            r.setString(1, date);
            r.setInt(2,Integer.parseInt(request.getParameter("cui")));
            r.setInt(3,Integer.parseInt(request.getParameter("seleccion")));
            r.setInt(4,Integer.parseInt(request.getParameter("seleccion")));
            
                r.setString(5, array[0]);
                r.setString(6, "no");
                r.executeUpdate();
         } catch (SQLException ex) {
             this.error=ex.getMessage();
         }
        
    }
    
    public consulta cancelarconsulta(HttpServletRequest request){
        consulta tmp=new consulta( request);
         String sql="insert into pagoconsulta (idconsulta, idcrearhabitacion, hora, pago ) select b.idconsulta , b.idcrearhabitacion, b.hora,  a.precio from datosGlobales a join consulta b where a.nombreDatos='consulta' && b.idconsulta=? && b.idcrearhabitacion=? && b.hora=?";   
        if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
         try {
             PreparedStatement r=iniciarconeccion.coneccion.prepareStatement(sql);
             r.setString(1,request.getParameter("idconsulta"));
             r.setInt(2, tmp.getId2());
               r.setString(3,tmp.getHora());
            r.executeUpdate();
            PreparedStatement cancel=iniciarconeccion.coneccion.prepareStatement("UPDATE consulta b SET cancelado='si' WHERE b.idconsulta=? && b.idcrearhabitacion=? && b.hora=?");
                cancel.setString(1, Integer.toString(tmp.getId()));
             cancel.setInt(2, tmp.getId2());
               cancel.setString(3,tmp.getHora());
               cancel.executeUpdate();
               update(request);
         } catch (SQLException ex) {
         this.error=ex.getMessage();
         }
       
   return tmp; }
    public void update(HttpServletRequest r){
    String sql="UPDATE consulta SET cancelado='SI' WHERE idconsulta=?";
         try {
             PreparedStatement up=iniciarconeccion.coneccion.prepareStatement(sql);
             up.setString(1,r.getParameter("idconsulta"));
             up.executeUpdate();
             
         } catch (SQLException ex) {
         
         }
    }
    public static consulta consulta(int cui){
    consulta tmp=new consulta();
      
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion(); }
         try {
             String sql="SELECT a.idcrearhabitacion, a.hora, a.idconsulta, b.nombre FROM consulta a join paciente b on a.cui=b.cui where a.cancelado='no' && a.cui=?";
             PreparedStatement get=iniciarconeccion.coneccion.prepareStatement(sql);
             get.setInt(1, cui);
             ResultSet res=get.executeQuery();
             if(res.next()){
             tmp.setHora(res.getString("a.hora"));
             tmp.setDate(res.getString("a.idconsulta"));
             tmp.setId2(res.getInt("a.idcrearhabitacion"));
             tmp.setValid(res.getString("b.nombre"));
             
             
             }else{
           
             }
         } catch (SQLException ex) {
             tmp.setValid(ex.getMessage());
       
         }
    return tmp;}
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
