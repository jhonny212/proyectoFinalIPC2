<%-- 
    Document   : registro
    Created on : 23/10/2019, 09:17:03 AM
    Author     : jhonny
--%>

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
            Bievenido al ingreso de medicamentos
        </h2>
          <br>
        <form class="fc1" style="width: 1000px;" action="/HospitalProject/Operator" method="GET" autocomplete="off">
            <input type="text" name="ids" value="1" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 1000px; ">
            <thead>
                <tr>
                   <th>Nombre de medicamento</th>
                   <th>Fecha de ingreso </th>
                   <th>Costo unitario</th>
                   
                   
                </tr>
            </thead>
            <tr>

                <td>
                    <input type="text" required name="nombre" placeholder="nombre de medicamento" id="">
                </td>
                <td>
                    <input type="date" name="fecha" id="" required>
                </td>    
                <td>
                    <input type="text" name="costo" id="" required>
                </td>
               
              
            </tr>
            <tr>
                <td>
                    <h2>Descripcion</h2>
                    <textarea name="descripcion" placeholder="descripcion" id="" cols="30" rows="50"></textarea>
                </td>
                <td>
                    <h2>cantidad minima</h2>
                    <input type="number" name="minimo" placeholder="cantidad minima" id="">
                </td>
                <td><h2>Registrar</h2>
                    <input type="submit" value="Registrar">
                </td>
            </tr>
        </table>
        </form>
       </div>
    </body>
</html>