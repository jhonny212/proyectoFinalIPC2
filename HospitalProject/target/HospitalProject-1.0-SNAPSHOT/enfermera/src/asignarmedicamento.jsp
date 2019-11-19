<%-- 
    Document   : asignarmedicamento
    Created on : 29/10/2019, 08:56:25 PM
    Author     : jhonny
--%>


<%@page import="servletenfermera.colamedicamento"%>
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
        <style>
        .cst:hover{
            cursor: none;


        }
        </style>
        
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Nuevo ingreso de medicamentos
        </h2>
          <br>
          <form class="fc1" style="width: 1000px;" action="/HospitalProject/servletenfermera" method="GET" autocomplete="off">
            <table>
                <tr>
                     <td>
                <input type="number" required name="cantidad" placeholder="cantidad" id="">
               </td>
              
                </tr>
            </table>
            <table class="c1" style="width: 1000px; ">
         <thead>
              <input type="text" name="ids" value="4" style="opacity: 0; height: 0; width: 0;">
    
                <tr>
                 <th>Descripcion</th>
                 <th>Costo</th>
                 <th>Cantidad</th>
                 <th>minimo</th>
                 <th>Nombre</th>
                 
                    
                </tr>
            </thead>
             
             <tr>
             
             </tr>
                 <%
                       if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
                       LinkedList<colamedicamento> me=colamedicamento.lista();
                         for(int i=0; i<me.size();i++){
                 out.print("<tr> <td><h2>"+me.get(i).getDescripcion()+"</h2></td>");
                 out.print("<td><h2>"+me.get(i).getCosto()+"</h2></td>");
                 if(me.get(i).getMinimo()<me.get(i).getCantidad()){
                 out.print("<td><h2>"+me.get(i).getCantidad()+"</h2></td>");
                }else{
                 out.print("<td><h2 style='color: red; '>"+me.get(i).getCantidad()+"</h2></td>");
                 
                 }
                    out.print("<td><h2>"+me.get(i).getMinimo()+"</h2></td>");
               
                 out.print("<td><input type='submit' name='valor' value='"+me.get(i).getNombre()+"'></td>");
                 out.print("</tr>");
                 } 
                 %>
                 
        
        </table >
        </form  >
        
       </div>
    </body>
</html>