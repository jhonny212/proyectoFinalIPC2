/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletoperador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;


import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class medicamento {
    private  String nombre;
    private  java.sql.Date sqlStartDate;
    private  double cantidad;
    private double costo;
    private int minimo;
    private String error;

    public String getError() {
        return error;
    }
    public medicamento(){}
    public medicamento(HttpServletRequest  request){
    this.nombre=request.getParameter("nombre");
     String startDate=request.getParameter("fecha");
     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
            this.error=ex.getMessage();
       
        }
    this.sqlStartDate = new java.sql.Date(date.getTime());
    this.costo=Double.parseDouble(request.getParameter("costo"));
    this.cantidad=Double.parseDouble(request.getParameter("cantidad"));
    this.minimo=Integer.parseInt(request.getParameter("minimo"));
    this.descripcion=request.getParameter("descripcion");
 }

    public String getNombre() {
        return nombre;
    }

    public Date getSqlStartDate() {
        return sqlStartDate;
    }

    public double getCantidad() {
        return cantidad;
    }

    public int getMinimo() {
        return minimo;
    }
  private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

public boolean actualizar(medicamento tmp){
boolean validar=true;
  if(iniciarconeccion.coneccion==null){
            iniciarconeccion.IniciarConeccion();
   }
  String sql="";
  sql ="INSERT INTO medicamento (nombre,fecha,costo,cantidad,minimo,descripcion) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement medicamento=iniciarconeccion.coneccion.prepareStatement(sql);
            medicamento.setString(1, tmp.getNombre());
            medicamento.setDate(2, tmp.getSqlStartDate());
            medicamento.setDouble(3, tmp.getCosto());
            medicamento.setDouble(4, tmp.getCantidad());
            medicamento.setInt(5, tmp.getMinimo());
            medicamento.setString(6, tmp.getDescripcion());
            medicamento.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
            this.error=ex.getMessage();
        
        }


return validar;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

public static LinkedList lista(){
    LinkedList<medicamento> tmp=new LinkedList();
    if(iniciarconeccion.coneccion ==null){
    iniciarconeccion.IniciarConeccion();}
       try {
            
            String sql="SELECT * FROM medicamento";
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet ResultSet = prepared.executeQuery();
       
        while(ResultSet.next()){
        medicamento medi=new medicamento();
        medi.setCosto(ResultSet.getDouble("costo"));
        medi.setDescripcion(ResultSet.getString("descripcion"));
        medi.setMinimo(ResultSet.getInt("minimo"));
        medi.setNombre(ResultSet.getString("nombre"));
        tmp.add(medi);
        }
           
        } catch (SQLException ex) {
        }
    
 return tmp;}


    public double getCosto() {
        return costo;
    }
    
    public boolean Colamedicamento(HttpServletRequest request, String id){
        
         boolean validar=true;
          String startDate=request.getParameter("fecha");
     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = null;
     java.sql.Date sqlDate=null;
        try {
            date = sdf1.parse(startDate);
        } catch (ParseException ex) {
        
        }
        
    sqlDate = new java.sql.Date(date.getTime());
         String sql="";
        try {
           
            sql="INSERT INTO colamedicamento (nombre,cantidad,idcola,fecha, inicial) VALUES (?,?,?,?,?)";
            PreparedStatement up=iniciarconeccion.coneccion.prepareStatement(sql);
            up.setString(1, request.getParameter("valor"));
            up.setInt(2, Integer.parseInt(request.getParameter("cantidad")));
            up.setString(3,id);
            up.setDate(4,sqlDate );
            up.setInt(5, Integer.parseInt(request.getParameter("cantidad")));
             up.executeUpdate();
             llenar(request,id);
        } catch (SQLException ex) {
             try {
                 sql="SELECT cantidad, inicial FROM colamedicamento WHERE idcola=? && nombre=?";
                 PreparedStatement get=iniciarconeccion.coneccion.prepareStatement(sql);
                 get.setString(1, id);
                 get.setString(2, request.getParameter("valor"));
                 ResultSet res=get.executeQuery();
                 if(res.next()){
                 sql="UPDATE colamedicamento SET cantidad=?, inicial=? WHERE idcola=? && nombre=?";
                 PreparedStatement cant=iniciarconeccion.coneccion.prepareStatement(sql);
                 cant.setInt(1, res.getInt("cantidad")+Integer.parseInt(request.getParameter("cantidad")));
                 cant.setInt(1, res.getInt("cantidad")+Integer.parseInt(request.getParameter("cantidad")));
                
                 cant.setString(3, id);
                 cant.setString(4, request.getParameter("valor"));
                 cant.executeUpdate();
                 }else{
                 validar=false;
                 }
             } catch (SQLException ex1) {
              validar=false;   
              this.error=ex1.getMessage()+"aca yes";
             }
            
        }
        return validar;
        }
    public boolean actualizarMedicamento(int id, HttpServletRequest request){
    boolean validar=true;
    String sql="";
     PreparedStatement cant=null;
          try {
                 switch(id){
                     case 1:
                          sql="UPDATE medicamento SET costo=? WHERE nombre=?";
                          cant=iniciarconeccion.coneccion.prepareStatement(sql);
                          cant.setDouble(1, Double.parseDouble(request.getParameter("costo")));
                          cant.setString(2, request.getParameter("valor"));
                          cant.executeUpdate();
                          
                          break;
                   
                     case 2:
                         sql="UPDATE medicamento SET minimo=? WHERE nombre=?";
                          cant=iniciarconeccion.coneccion.prepareStatement(sql);
                          cant.setInt(1, Integer.parseInt(request.getParameter("cantidad")));
                          cant.setString(2, request.getParameter("valor"));
                           cant.executeUpdate();
                         
                         break;
                     case 3:
                          sql="UPDATE medicamento SET minimo=?, costo=? WHERE nombre=?";
                          cant=iniciarconeccion.coneccion.prepareStatement(sql);
                          cant.setInt(1, Integer.parseInt(request.getParameter("cantidad")));
                          cant.setDouble(2, Double.parseDouble(request.getParameter("costo")));
                          cant.setString(3, request.getParameter("valor"));
                          
                          cant.executeUpdate();
                          
                         break;
                 
                 }
                
                 
               
                
             } catch (SQLException ex1) {
              validar=false;   
              this.error=ex1.getMessage();
             }catch(NumberFormatException es){
             validar=false;
             }
            
    return validar;}

public void llenar(HttpServletRequest  request, String id){
     Calendar fechA = Calendar.getInstance();
     String getFecha="";
     
     if(fechA.get(Calendar.MONTH)==0){
     getFecha=Integer.toString(fechA.get(Calendar.YEAR)-1);
     getFecha+="12";
     }else{
     getFecha=Integer.toString(fechA.get(Calendar.YEAR));
     getFecha+=Integer.toString(fechA.get(Calendar.MONTH));
     }
                   
   String sql="";
   sql="UPDATE colamedicamento a, colamedicamento b SET a.cantidad=b.cantidad+a.cantidad WHERE b.idcola=? && b.nombre=? && a.idcola=? && a.nombre=?";
        try {
            PreparedStatement get=iniciarconeccion.coneccion.prepareStatement(sql);
                 get.setString(1, getFecha);
                 get.setString(2, request.getParameter("valor"));
                 
                 get.setString(3, id);
                 get.setString(4, request.getParameter("valor"));
                 get.executeUpdate();
                 
        } catch (SQLException ex) {
       
        }
    
}
}
