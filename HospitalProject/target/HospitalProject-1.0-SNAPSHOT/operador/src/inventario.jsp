<%-- 
    Document   : inventario
    Created on : 18/11/2019, 12:35:50 PM
    Author     : jhonny
--%>

<%@page import="servletoperador.inventario"%>
<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="net.sf.jasperreports.export.SimpleOutputStreamExporterOutput"%>
<%@page import="net.sf.jasperreports.export.SimpleExporterInput"%>
<%@page import="net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@page import="net.sf.jasperreports.export.SimplePdfExporterConfiguration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%    
                  Calendar fechas=Calendar.getInstance();
                   int añoSs=fechas.get(Calendar.YEAR);
                   int mesSs=fechas.get(Calendar.MONTH)+1;
                   int diaSs=fechas.get(Calendar.DAY_OF_MONTH);
                   Random aleatorio = new Random(System.currentTimeMillis());
// Producir nuevo int aleatorio entre 0 y 99
int intAletorio = aleatorio.nextInt(1000);
String date=Integer.toString(añoSs)+""+Integer.toString(mesSs);
                   String nombre="";
          if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
          
try {
            JasperPrint jasperPrint2=null;
           
                jasperPrint2=JasperFillManager.fillReport(
                   getClass().getResourceAsStream("/Reporteadmin/"+"inventario"+".jasper"), null,
                    new JRBeanCollectionDataSource(inventario.lista(date)));
          
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/jhonny/Escritorio/Proga1/ProyectoFinalIPC2/reportes/"+intAletorio+añoSs+".pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
          
        } catch (JRException ex) {
            out.print(ex.getMessage());
        }
      
      %>
    </body>
</html>
