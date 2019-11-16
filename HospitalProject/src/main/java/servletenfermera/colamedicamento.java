/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletenfermera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import paquetescompartidos.iniciarconeccion;
import servletoperador.medicamento;

/**
 *
 * @author jhonny
 */
public class colamedicamento {
    public static boolean colamedicamento(HttpServletRequest request){
    int cantidad=Integer.parseInt(request.getParameter("cantidad"));
    boolean validar=true;   
    String d="";
    Calendar fecha=Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
       HttpSession sesion=request.getSession();
    int    cui=Integer.parseInt(sesion.getAttribute("cui").toString());
      
    String fechA=Integer.toString(año)+""+Integer.toString(mes);
    String sql="SELECT a.cantidad FROM colamedicamento a WHERE idcola=? && a.nombre=?";
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setString(1, fechA);
            prepared.setString(2, request.getParameter("valor"));
            
            ResultSet res=prepared.executeQuery();
            if(res.next()){
            if(res.getInt("a.cantidad")>=cantidad){
            sql="INSERT INTO medicamentosUsados (idinternado, nombre, costo, cantidad, cui) select a.idinternado,e.nombre, e.costo*"+request.getParameter("cantidad")+" ,"+request.getParameter("cantidad")+", "+sesion.getAttribute("cui").toString()+" from medicosDestinados a join contratoEmpleado b join medicamento e  join internado c on a.idcontratoEmpleado=b.idcontratoEmpleado where b.cui=? && c.estado='No' && e.nombre=?; ";
            PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
            p.setInt(1, cui);
            p.setString(2, request.getParameter("valor"));
            p.executeUpdate();
            sql="UPDATE colamedicamento a, colamedicamento b SET a.cantidad=a.cantidad-'"+request.getParameter("cantidad")+"' WHERE b.idcola=? && b.nombre=? && a.idcola=? && a.nombre=?";
            PreparedStatement act=iniciarconeccion.coneccion.prepareStatement(sql);
            act.setString(1, fechA);
            act.setString(2, request.getParameter("valor"));
            act.setString(3, fechA);
            act.setString(4, request.getParameter("valor"));
            act.executeUpdate();
            }else{validar=false;
            d="no";
            }
            }
        } catch (SQLException ex) {
            validar=false;
            d=ex.getMessage();
        }
    
   return validar; }
    
    private int cantidad;
    public static LinkedList lista(){
    LinkedList<colamedicamento> tmp=new LinkedList();
    Calendar fecha=Calendar.getInstance();
    
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
    String fechA=Integer.toString(año)+""+Integer.toString(mes);
   
    if(iniciarconeccion.coneccion ==null){
    iniciarconeccion.IniciarConeccion();}
       try {
            
            String sql="select a.costo, b.cantidad, a.descripcion, a.nombre from medicamento a join colamedicamento b on a.nombre=b.nombre where b.idcola=?;";
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setString(1, fechA);
            ResultSet ResultSet = prepared.executeQuery();
       
        while(ResultSet.next()){
        colamedicamento tm=new colamedicamento();
        tm.setCantidad(ResultSet.getInt("b.cantidad"));
        tm.setCosto(ResultSet.getInt("a.costo"));
        tm.setDescripcion(ResultSet.getString("a.descripcion"));
           tm.setNombre(ResultSet.getString("a.nombre"));
        tmp.add(tm);
        }
           
        } catch (SQLException ex) {
        }
    
 return tmp;}
    private int costo;
    private String descripcion;
    private String nombre;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
