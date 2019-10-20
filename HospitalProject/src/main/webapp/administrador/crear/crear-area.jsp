<%-- 
    Document   : crear-area
    Created on : 17/10/2019, 03:52:35 PM
    Author     : jhonny
--%>

<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="paquetescompartidos.areaDeTrabajo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/HospitalProject/Css/creacion-admin.css">
      
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
            Bievenido a la creacion de areas
        </h2>
          <br>
        <form class="fc1" action="/HospitalProject/adminsesion?id=1" method="GET" autocomplete="off">
            <input type="text" name="id" value="1" style="opacity: 0; height: 0; width: 0;">
            <table class="c1" style="width: 500px;">
              
                <tr>
                <td>
                    <h2 style="height: 0px;">seleccionar modulo</h2>
                    <select required name="modulo" class="styled-select" id="">
                       <option   >Farmacia</option>
                            <option   >Administracion</option>
                                 <option   >Empleado</option>
                    </select>
                </td>
                <td>
                    <h2>Fecha de creacion</h2>
                    <br>
                    <input required type="date" name="fecha" id="">
                </td>

            </tr>
            <tr>
                <td>
                    <input required type="text" name="costo" placeholder="costo de creacion">
                </td>
                <td>
                    <input required type="text" name="nombre" placeholder="nombre del area" placeholder="descripcion" id="">
                </td>
            </tr>
            <tr> <td><input type="submit" value="crear" style="margin: auto; width: 460px;"></td> </tr>
        </table>
        </form>
       </div>
    </body>
</html>
