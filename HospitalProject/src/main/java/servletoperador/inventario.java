/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletoperador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class inventario {
static List<inventario> listas;
private String medicamento;
private int inicial;
private int cantidad;
private int diferencia;
static int total;
static int totalinicial;
private float puerba;

    public float getPuerba() {
        return puerba;
    }

    public void setPuerba(float puerba) {
        this.puerba = puerba;
    }
    public static List<inventario> getListas() {
        return listas;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public int getInicial() {
        return inicial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDiferencia() {
        return diferencia;
    }

   

  
    private static void internado(ResultSet res, String date) {
        Calendar fechas=Calendar.getInstance();
                   int añoSs=fechas.get(Calendar.YEAR);
                   int mesSs=fechas.get(Calendar.MONTH)+1;
                 
                   String fecha1=Integer.toString(añoSs-4)+"-"+Integer.toString(mesSs)+"-01";
                   String fecha2=Integer.toString(añoSs+5)+"-"+Integer.toString(mesSs)+"-28";
    try {
          String sql="select sum(cantidad) as total from pagomedicamento where nombre='"+res.getString("nombre")+"'  && fecha between  '"+fecha1+"' and '"+fecha2+"'";
  
         PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
         ResultSet res2=p.executeQuery();
         while (res2.next()){
             
         inventario tmp=new inventario();
        tmp.setTipo("medicamentos de venta");
        tmp.setCantidad(res2.getInt("total"));
     
       
        listas.add(tmp);
        total+=res2.getInt("total");
        
         }
     } catch (SQLException ex) {
     inventario t=new inventario();
     t.setMedicamento(ex.getMessage());
     listas.add(t);
     }
    }

    private static void venta(ResultSet res, String date) {
         Calendar fechas=Calendar.getInstance();
                   int añoSs=fechas.get(Calendar.YEAR);
                   int mesSs=fechas.get(Calendar.MONTH)+1;
                   String fecha1=Integer.toString(añoSs-4)+"-"+Integer.toString(mesSs)+"-01";
                   String fecha2=Integer.toString(añoSs+5)+"-"+Integer.toString(mesSs)+"-28";
    
                 
    try {
          String sql="select sum(a.cantidad) as total from medicamentosUsados a left join internado b on a.idinternado=b.idinternado where a.fecha between '"+fecha1+"' and '"+fecha2+"' && a.nombre='"+res.getString("nombre")+"' && b.estado='Cancelado';";
  
         PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
         ResultSet res2=p.executeQuery();
         while (res2.next()){
        inventario tmp=new inventario();
        tmp.setTipo("medicamentos en internado ");
        tmp.setCantidad(res2.getInt("total"));
        listas.add(tmp);
        total+=res2.getInt("total");
         }
     } catch (SQLException ex) {
     
     }
    }
   
 public static List <inventario> lista(String date){
     listas=new LinkedList();

 String sql="SELECT * FROM colamedicamento WHERE idcola='"+date+"'";
     try {
         PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
         ResultSet res=p.executeQuery();
         while (res.next()){
          totalinicial=0;
          total=0;
          totalinicial=res.getInt("inicial");
          inventario tmp=new inventario();
          tmp.setMedicamento(res.getString("nombre"));
          tmp.setInicial(res.getInt("inicial"));
          listas.add(tmp);
          venta(res,date);
          internado(res,date);
          inventario tmp2=new inventario();
          tmp2.setDiferencia(totalinicial-total);
          tmp2.setPuerba(-2);
          listas.add(tmp2);
          
         }
     } catch (SQLException ex) {
     
     }
 
 return listas;}   
private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }
 public inventario(){}
}
