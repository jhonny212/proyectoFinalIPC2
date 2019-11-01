<%-- 
    Document   : asignarenfermera
    Created on : 29/10/2019, 08:55:47 PM
    Author     : jhonny
--%>

<%@page import="servletrecepcion.enfermera"%>
<%@page import="servletrecepcion.medico"%>
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
            Registro de enfermeras
        </h2>
          <br>
    
          <form class="fc1" style="width: 1000px; " id="formget" action="/HospitalProject/servletenfermera" method="GET" autocomplete="off">
           
             
            <table class="c1" style="width: 1000px; ">
         <thead>
                <tr>
                 <th></th>
                 <th></th>
                 <th></th>
                 <th></th>
                 </tr>
            </thead>
  
 <tr>
   <td><input type="date" name="fecha" required id=""></td>
    <td><input type="submit" value="ok"></td>
    <%  LinkedList<enfermera> ListadO=enfermera.medico("");%>
 </tr>
          
                   <% for(int i=0;i<ListadO.size();i++){ 
                  out.print("<tr> <td>");
                  %>
                  <%out.print("<td><h2>"+ListadO.get(i).getCui()+"</h2></td>"); %>
                  <%out.print("<td><h2>"+ListadO.get(i).getNombre()+"</h2></td>"); %>
                   <%out.print("<td><input type='submit' value='"+ListadO.get(i).getId()+"'></td>"); %>
                  <%
                   out.print("</td></tr>");
                  } %>
 >
        </table>
        <br>
        </form>
       </div>
    </body>
</html>