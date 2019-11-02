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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class colamedicamento {
    public static boolean colamedicamento(HttpServletRequest request){
    int cantidad=Integer.parseInt(request.getParameter("cantidad"));
    boolean validar=true;    
    Calendar fecha=Calendar.getInstance();
    int año=fecha.get(Calendar.YEAR);
    int mes=fecha.get(Calendar.MONTH)+1;
       HttpSession sesion=request.getSession();
    int    cui=Integer.parseInt(sesion.getAttribute("cui").toString());
      
    String fechA=Integer.toString(año)+""+Integer.toString(mes);
    String sql="SELECT a.cantidad FROM colamedicamento a WHERE idcola=?";
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
        try {
            PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(sql);
            prepared.setString(1, fechA);
            ResultSet res=prepared.executeQuery();
            if(res.next()){
            if(res.getInt("a.cantidad")>=cantidad){
            sql="INSERT INTO medicamentosUsados (idinternado, nombre, costo, cantidad) select a.idinternado,e.nombre, e.costo*"+request.getParameter("cantidad")+" ,"+request.getParameter("cantidad")+" from medicosDestinados a join contratoEmpleado b join medicamento e  join internado c on a.idcontratoEmpleado=b.idcontratoEmpleado where b.cui=? && c.estado='No' && e.nombre=?; ";
            PreparedStatement p=iniciarconeccion.coneccion.prepareStatement(sql);
            p.setInt(1, cui);
            p.setString(2, request.getParameter("valor"));
            p.executeUpdate();
            sql="UPDATE colamedicamento a, colamedicamento b SET a.cantidad='"+request.getParameter("cantidad")+"' WHERE b.idcola=? && b.nombre=? && a.idcola=? && a.nombre=?";
            PreparedStatement act=iniciarconeccion.coneccion.prepareStatement(sql);
            act.setString(1, fechA);
            act.setString(2, request.getParameter("valor"));
            act.setString(3, fechA);
            act.setString(4, request.getParameter("valor"));
            act.executeUpdate();
            }else{validar=false;}
            }
        } catch (SQLException ex) {
            validar=false;
        }
    
   return validar; }
}
