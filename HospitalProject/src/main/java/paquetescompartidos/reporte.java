/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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

 public   String reporteOperador2(String nombre,String jasper, Map parametro, boolean validar){
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
}
