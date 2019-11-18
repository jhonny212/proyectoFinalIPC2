/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionreportes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class ingresos {
private String area;
private double pago;
private double tota;
private Date id;
private String medicamento;
public double ingresosfinal;

    public double getIngresosfinal() {
        return ingresosfinal;
    }

    public void setIngresosfinal(double ingresosfinal) {
        this.ingresosfinal = ingresosfinal;
    }

   

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    public ingresos(String area, double pago, double tota, Date id) {
        this.area = area;
        this.pago = pago;
        this.tota = tota;
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public double getPago() {
        return pago;
    }

    public double getTota() {
        return tota;
    }

    public Date getId() {
        return id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public void setTota(double tota) {
        this.tota = tota;
    }

    public void setId(Date id) {
        this.id = id;
    }
  
  public ingresos(){}


 
public static List<ingresos> ingresos(HttpServletRequest res){
LinkedList<ingresos> list=new LinkedList();
 

String dat1=res.getParameter("fecha1");
String dat2=res.getParameter("fecha2");
if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}    
String sql="select * from pagoconsulta where idconsulta between '"+dat1+"' and '"+dat2+"'";
    try {
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
        ingresos j=new ingresos();
        j.setArea("consulta");
        list.add(j);
        while(Res.next()){
        total+=Res.getDouble("pago");
        ingresos tmp=new ingresos();
        tmp.setId(Res.getDate("idconsulta"));
        tmp.setPago(Res.getDouble("pago"));
        list.add(tmp);
        }
     
        ingresos a=new ingresos();
        a.setTota(total);
        list.add(a);
      
       
    } catch (SQLException ex) {
  
    }
  
  sql="select * from pagointernado where fecha between '"+dat1+"' and '"+dat2+"'";

   try {
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
        ingresos j=new ingresos();
        j.setArea("operaciones");
        list.add(j);
        while(Res.next()){
        total+=Res.getDouble("total");
        ingresos tmp=new ingresos();
        tmp.setId(Res.getDate("fecha"));
        tmp.setPago(Res.getDouble("total"));
        
        list.add(tmp);
        }
     
        ingresos a=new ingresos();
        a.setTota(total);
        list.add(a);
      
       
    } catch (SQLException ex) {
  
    }
   
     sql="select * from pagomedicamento where fecha between '"+dat1+"' and '"+dat2+"'";

   try {
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
        ingresos j=new ingresos();
        j.setArea("recepcion");
        list.add(j);
        while(Res.next()){
        total+=Res.getDouble("total");
        ingresos tmp=new ingresos();
        tmp.setId(Res.getDate("fecha"));
        tmp.setPago(Res.getDouble("total"));
        tmp.setMedicamento(Res.getString("nombre"));
        list.add(tmp);
        }
     
        ingresos a=new ingresos();
        a.setTota(total);
        list.add(a);
      
       
    } catch (SQLException ex) {
  
    }
 

return list;}    
}
