<%-- 
    Document   : dardealta
    Created on : 29/10/2019, 08:56:50 PM
    Author     : jhonny
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servletrecepcion.consulta"%>
<%@page import="servletrecepcion.habitacioN"%>
<%@page import="servletrecepcion.paciente"%>
<%@page import="java.util.LinkedList"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="servletoperador.medicamento"%>
<%@page import="servletEncargadoEmpleado.encargadoEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/HospitalProject/Css/gerente.css">
      
        <title>JSP Page</title>
    </head>
                   <% 
    if(request.getParameter("error")!=null){
    if(request.getParameter("error").equals("error")){
      String alert="alert('"+"Erro al crear usuario, intente de nuevo"+"');";
                     out.print("<script>"+alert+"</script>");
    }else{
      String alert="alert('"+"Registro creado exitosamente"+"');";
                     out.print("<script>"+alert+"</script>");
    }
    }
    %>
    <body>
        
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Nuevo ingreso de medicamentos
        </h2>
          <br>
      
          <form class="fc1" style="width: 900px; " id="formget" action="/HospitalProject/servletenfermera" method="GET" autocomplete="off">
          <input type="text" name="ids" value="5" style="opacity: 0; height: 0; width: 0;">
                         
             
            <table class="c1" style="width: 900px; ">
         <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Fecha entrada</th>
                    <th>Id internado</th>
                 
                </tr>
            </thead>
        
               <% 
                   HttpSession sesioN=request.getSession();
               String SQL="select b.nombre, b.telefono, a.fechaEntrada, a.idinternado from internado a join paciente b join contratoEmpleado c where c.cui=? && a.estado='No' ; ";
               PreparedStatement prepared=iniciarconeccion.coneccion.prepareStatement(SQL);
               prepared.setInt(1, Integer.parseInt(sesioN.getAttribute("cui").toString()));
               ResultSet reS=prepared.executeQuery();
               if(reS.next()){
               out.print("<td><h2>"+reS.getString("b.nombre")+"</h2></td>");
               out.print("<td><h2>"+reS.getInt("b.telefono")+"</h2></td>");
               out.print("<td><h2>"+reS.getString("a.fechaEntrada")+"</h2></td>");
               out.print("<td><input type='submit' name='dato' value='"+reS.getInt("a.idinternado")+"' required ></td>");
               }
               %>
        </table>
       
        </form>
       </div>
    </body>
</html>