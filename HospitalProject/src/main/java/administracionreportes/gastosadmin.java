/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionreportes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class gastosadmin {

    public static void setTotalfinal(double totalfinal) {
        gastosadmin.totalfinal = totalfinal;
    }

    public static LinkedList<ingresos> getList() {
        return list;
    }

    public static void setList(LinkedList<ingresos> list) {
        gastosadmin.list = list;
    }
    
public static LinkedList<ingresos> list;   
public static double totalfinal;
public static List<ingresos> gastos(HttpServletRequest res){
list=new LinkedList();
String dat1=res.getParameter("fecha1");
String dat2=res.getParameter("fecha2");
if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}    
String sql="select nombre from areaDeTrabajo ";
    try {
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
      
        while(Res.next()){
            totalfinal=0;
            ingresos tmp=new ingresos();
            tmp.setArea(Res.getString("nombre"));
            list.add(tmp);
            gastohabitacion(Res.getString("nombre"),dat1,dat2);
            pagohabitacion(Res.getString("nombre"),dat1,dat2);
           pagoempleado(Res.getString("nombre"),dat1,dat2);
            if(Res.getString("nombre").equals("gerencia") ){
            especialistas(Res.getString("nombre"),dat1,dat2);    
            }else if(Res.getString("nombre").equals("recepcion")){
            compramedicamentos(Res.getString("nombre"),dat1,dat2);
          
            }
        ingresos tmps=new ingresos();
        tmps.setTota(totalfinal);
        tmps.setIngresosfinal(totalfinal);
        list.add(tmps);
        
      
   
        }
   
      
       
    } catch (SQLException ex) {
  
    }
  
 
return list;}   

    public static double getTotalfinal() {
        return totalfinal;
    }

    private static void gastohabitacion(String string, String f1, String f2) {
    try {
        String sql="select a.gasto, a.fecha, b.nombre from gastoHabitacion a join crearHabitacion b on a.idcrearHabitacion=b.idcrearHabitacion where b.nombre='"+string+"' && a.fecha between '"+f1+"' and '"+f2+"';";
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
       
        while(Res.next()){
          ingresos tmp=new ingresos();
          tmp.setMedicamento("Gasto de mantenimiento");
          tmp.setId(Res.getDate("a.fecha"));
          tmp.setPago(Res.getDouble("a.gasto"));
          total+=Res.getDouble("a.gasto");
          list.add(tmp);
        }
        ingresos tmp=new ingresos();
        totalfinal+=total;
        tmp.setTota(total);
        list.add(tmp);
   
      
       
    } catch (SQLException ex) {
  
    }
    }

    private static void pagoempleado(String string, String f1, String f2) {
         try {
        String sql="select a.costo, a.fecha1, b.nombre from pagoHabitacion a join crearHabitacion b on a.idcrearHabitacion=b.idcrearHabitacion where b.nombre='"+string+"' && a.fecha1 between '"+f1+"' and '"+f2+"';";
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
       
        while(Res.next()){
          ingresos tmp=new ingresos();
          tmp.setMedicamento("Gasto de reparacion");
          tmp.setId(Res.getDate("a.fecha1"));
          tmp.setPago(Res.getDouble("a.costo"));
          total+=Res.getDouble("a.costo");
          list.add(tmp);
        }
        ingresos tmp=new ingresos();
        tmp.setTota(total);
          totalfinal+=total;
        list.add(tmp);
   
      
       
    } catch (SQLException ex) {
  
    }
    }

    private static void pagohabitacion(String string, String f1, String f2) {
             try {
        String sql="select a.pago, a.fecha from pagoempleado a left join contratoEmpleado b on a.idcontratoEmpleado=b.idcontratoEmpleado left join crearEmpleo c on c.nombreEmpleo=b.nombreEmpleo where c.nombre='"+string+"' && a.fecha between '"+f1+"' and '"+f2+"' ";
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
       
        while(Res.next()){
          ingresos tmp=new ingresos();
          tmp.setMedicamento("Pago a empleados");
          tmp.setId(Res.getDate("a.fecha"));
          tmp.setPago(Res.getDouble("a.pago"));
          total+=Res.getDouble("a.pago");
          list.add(tmp);
        }
        ingresos tmp=new ingresos();
        tmp.setTota(total);
          totalfinal+=total;
        list.add(tmp);
   
      
       
    } catch (SQLException ex) {
  
    }
    }

    private static void compramedicamentos(String string, String f1, String f2) {
       try {
        String sql="select a.nombre, a.inicial*b.cantidad as pago from colamedicamento a left join medicamento b on a.nombre=b.nombre where a.fecha between '"+f1+"' and '"+f2+"'; ";
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
       
        while(Res.next()){
          ingresos tmp=new ingresos();
      
          tmp.setMedicamento(Res.getString("a.nombre"));
        
          tmp.setPago(Res.getDouble("pago"));
          total+=Res.getDouble("pago");
          list.add(tmp);
        }
        
        ingresos tmp=new ingresos();
        tmp.setTota(total);
          totalfinal+=total;
        if(total!=0){
        list.add(tmp);
   }
      
       
    } catch (SQLException ex) {
  
    }
    }

    private static void especialistas(String string, String f1, String f2) {
     try {
        String sql="select * from pagoespecialista where fecha between '"+f1+"' and '"+f2+"'; ";
        PreparedStatement i1=iniciarconeccion.coneccion.prepareStatement(sql);
        ResultSet Res=i1.executeQuery();
        double total=0;
       
        while(Res.next()){
          ingresos tmp=new ingresos();
          tmp.setMedicamento("Pago a especialista");
          tmp.setId(Res.getDate("fecha"));
          tmp.setPago(Res.getDouble("pago"));
          total+=Res.getDouble("pago");
          list.add(tmp);
        }
        
        ingresos tmp=new ingresos();
        tmp.setTota(total);
          totalfinal+=total;
        if(total!=0){
        list.add(tmp);
   }
      
       
    } catch (SQLException ex) {
  
    }
    }

  

 
}
