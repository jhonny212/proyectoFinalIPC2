<%-- 
    Document   : pagarmedicamento
    Created on : 27/10/2019, 11:30:31 AM
    Author     : jhonny
--%>
<%@page import="servletenfermera.colamedicamento"%>
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
                    <input type="text" name="id" value="5" style="opacity: 0; height: 0; width: 0;">
           
                <tr>
                    <td><h2>Cui</h2></td>
                </tr>
                <tr>
                    <td> 
                        <input type="number" required name="cui" id="numero">
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
       
  
            </table>
        </form>
          <form class="fc1" style="width: 1000px; " id="formget" action="/HospitalProject/recepcion" method="GET" autocomplete="off">
            <input type="text" name="ids" value="5" style="opacity: 0; height: 0; width: 0;">
            <td><input type="number" name="cui" value<%out.print("='"+request.getParameter("cui")+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
                <input type="text" name="seleccion" value<%out.print("='"+request.getParameter("seleccion")+"'"); %> style="opacity: 0; height: 0; width: 0;">
              
             
            <table class="c1" style="width: 1000px; ">
         <thead>
                <tr>
                 <th></th>
                 <th></th>
                 <th></th>
                 <th></th>
                 </tr>
            </thead>
            <% 
            if(request.getParameter("cui")!=null){
            try{
                paciente tmp=paciente.paciente(Integer.parseInt(request.getParameter("cui")));
                
               if(tmp.getCui()!=0){
                   
            %>
           
            
            <%
            }else
{    
        %>
        <tr>
            <td></td>
            <td></td>
            <td><h2>Telefono</h2></td>
            <td></td>
        </tr>
            <tr>
                <td><input type="text" name="nombre" placeholder="nombre" id="">
                    </td>
                <td><input type="text" name="direccion" placeholder="direccion" id="">
                </td>
                <td><input type="number" name="telefono" id="">
                </td>
            </td>
          
            </tr>

        <%
        }
%>
<tr>
    <td><input type="number" name="cantidad" value="0"  placeholder="cantidad de medicamento"  required >
                </td>
            
</tr>
<%
          
                       if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
                       LinkedList<colamedicamento> me=colamedicamento.lista();
                 out.print("<tr>"
                         + "<td></td>"
                         + "<td><h2>costo</h2></td>"
                         + "<td><h2>Cantidad existente</h2></td></tr>");
                         for(int i=0; i<me.size();i++){
                 out.print("<tr> <td><h2>"+me.get(i).getDescripcion()+"</h2></td>");
                 out.print("<td><h2>"+me.get(i).getCosto()+"</h2></td>");
                 out.print("<td><h2>"+me.get(i).getCantidad()+"</h2></td>");
                 
                        out.print("</td>");
                 out.print("<td><input type='submit' name='valor' value='"+me.get(i).getNombre()+"'></td>");
                 out.print("</tr>");
                 } 
                 
  }catch(NumberFormatException e){
response.sendRedirect("http://localhost:8080/HospitalProject/recepcionista/indexrecepcion.jsp?id=5");
}
    }
          %>
        </table>
        <br>
        </form>
       </div>
       <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>