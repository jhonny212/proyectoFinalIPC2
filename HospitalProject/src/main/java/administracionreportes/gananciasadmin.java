/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionreportes;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import paquetescompartidos.iniciarconeccion;

/**
 *
 * @author jhonny
 */
public class gananciasadmin {
    public static List<ingresos> ganancias(HttpServletRequest res){
        if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
    List<ingresos> lista=new LinkedList();
   
    List<ingresos> gastos;
            gastos=gastosadmin.gastos(res);
             List<ingresos> ingresoS;
            ingresoS=ingresos.ingresos(res);
    boolean validar=false;
   
    int a1=11000;
    LinkedList<Integer> cod=new LinkedList();
    double totalfinal=0;
    for(int i=0; i<ingresoS.size();i++){
    if(ingresoS.get(i).getTota()!=0 ){
  
    cod.add(i);
    }
    }
    
    
    for(int i=0; i<gastos.size();i++){
        try{
        if(!gastos.get(i).getArea().equals("")){
       
        for(int j=i; j<gastos.size();j++){
         if(gastos.get(j).getIngresosfinal()!=0.0){
       
         if(gastos.get(i).getArea().equals("operacion") || gastos.get(i).getArea().equals("recepcion") || gastos.get(i).getArea().equals("consulta")        ){
      if(gastos.get(i).getArea().equals("consulta")){
                ingresos t=new ingresos();
       t.setTota(-gastos.get(j).getIngresosfinal()+ingresoS.get(cod.get(0)).getTota());
        t.setArea(gastos.get(i).getArea());
        lista.add(t); 
         }
         if(gastos.get(i).getArea().equals("recepcion")){
                  ingresos t=new ingresos();
        t.setTota(-gastos.get(j).getIngresosfinal()+ingresoS.get(cod.get(2)).getTota());
        t.setArea(gastos.get(i).getArea());
        lista.add(t); 
         }
         if(gastos.get(i).getArea().equals("operacion")){
                  ingresos t=new ingresos();
        t.setTota(-gastos.get(j).getIngresosfinal()+ingresoS.get(cod.get(1)).getTota());
        t.setArea(gastos.get(i).getArea());
        lista.add(t); 
         }
         }else{
                ingresos t=new ingresos();
        t.setTota(-gastos.get(j).getIngresosfinal());
        t.setArea(gastos.get(i).getArea());
        lista.add(t);
          
         }
     
        break;
        }
        }
        }
        }catch(NullPointerException e){
        
        }
       
    
    }
  
    return lista;}
}
