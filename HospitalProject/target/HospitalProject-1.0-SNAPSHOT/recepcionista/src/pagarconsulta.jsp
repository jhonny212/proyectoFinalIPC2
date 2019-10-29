<%-- 
    Document   : pagarconsulta
    Created on : 27/10/2019, 11:30:14 AM
    Author     : jhonny
--%>

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
        <form action="/HospitalProject/recepcionista/indexrecepcion.jsp?id=1">
            <table>
                    <input type="text" name="id" value="2" style="opacity: 0; height: 0; width: 0;">
           
                <tr>
                    <td><h2>Cui</h2></td>
                </tr>
                <tr>
                    <td> 
                        <input type="number" required name="cui" id="">
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
                    <tr>
      
    </tr>
   
            </table>
        </form>
          <form class="fc1" style="width: 900px; " id="formget" action="/HospitalProject/recepcion" method="GET" autocomplete="off">
          <input type="text" name="ids" value="2" style="opacity: 0; height: 0; width: 0;">
                         
             
            <table class="c1" style="width: 900px; ">
         <thead>
                <tr>
                    <th>Paciente</th>
                    <th>Hora de consulta</th>
                    <th>Habitacion</th>
                    <th>id consulta</th>
                 
                </tr>
            </thead>
                <tr>
                    <%if(request.getParameter("cui")!=null){
                    consulta pago=consulta.consulta(Integer.parseInt(request.getParameter("cui")));
                    if(pago.getHora()!=null){
                   %>
                   <td>
                       <h2><%out.print(pago.getValid()); %></h2>
                      <input type="number"  value<%out.print("='"+pago.getId2()+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
 
                   </td>
                     <td>
                       <h2><%out.print(pago.getHora()+":00"); %></h2>
                       <input type="number" name="hora" value<%out.print("='"+pago.getHora()+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
 
                   </td>
                     <td>
                       <h2><%out.print(pago.getId2()); %></h2>
                       <input type="number" name="habitacion" value<%out.print("='"+pago.getId2()+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
 
                   </td>
                     <td>
                      <input type="submit" name="idconsulta" value<%out.print("='"+pago.getId()+"'");%>>
                       <input type="number"  value<%out.print("='"+pago.getId2()+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
 
                     </td>
                   <%}
                    } %>
                </tr>
        </table>
       
        </form>
       </div>
    </body>
</html>