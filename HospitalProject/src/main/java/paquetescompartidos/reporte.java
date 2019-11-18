/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import administracionreportes.gananciasadmin;
import administracionreportes.gastosadmin;
import administracionreportes.ingresos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jhonny
 */
public class reporte {

 public   String reporteOperador(String nombre,String jasper, Map parametro, boolean validar){
 String v="si error";
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
try {
            JasperPrint jasperPrint2=null;
            
            if(validar){
            jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/reportesfarmacia/"+jasper+".jasper"), parametro,
                    iniciarconeccion.coneccion);
            }else{
            jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/reportesfarmacia/"+jasper+".jasper"), parametro,
                    iniciarconeccion.coneccion);
            }
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+nombre+".pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
          
        } catch (JRException ex) {
      
          v=ex.getMessage();
        }
return "a"; } 

 public   String administrador(String nombre,String jasper, HttpServletRequest res, boolean validar){
 String v="ok";
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
try {
            JasperPrint jasperPrint2=null;
              
            switch(res.getParameter("codreporte")){
                case "Generar reporte 1":
                    Map p=new HashMap();
                    p.put("cod", 1);
                     jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/Reporteadmin/ingresosadmin.jasper"), p,
                    new JRBeanCollectionDataSource(ingresos.ingresos(res)));
                    break;
                case "Generar reporte 2":
                     Map p2=new HashMap();
                    p2.put("cod", 2);
                     jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/Reporteadmin/ingresosadmin.jasper"), p2,
                    new JRBeanCollectionDataSource(gastosadmin.gastos(res)));
                    break;
                case "Generar reporte 3":
                     Map p3=new HashMap();
                    p3.put("cod", 3);
                     jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/Reporteadmin/ingresosadmin.jasper"), p3,
                    new JRBeanCollectionDataSource(gananciasadmin.ganancias(res)));
                    break;
                      
            }
           
          
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+nombre+".pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
          
        } catch (JRException ex) {
      
          v=ex.getMessage();
        }
return v; }
  public   String encargado(String nombre,String jasper, Map parametro, boolean validar){
 String v="si error";
    if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
try {
            JasperPrint jasperPrint2=null;
           
            jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/reportesempleados/"+jasper+".jasper"), parametro,
                    iniciarconeccion.coneccion);
          
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+nombre+".pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
          
        } catch (JRException ex) {
      
          v=ex.getMessage();
        }
return v; } 

}
