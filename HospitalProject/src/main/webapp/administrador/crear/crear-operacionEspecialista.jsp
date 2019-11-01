<%-- 
    Document   : crear-operacionEspecialista
    Created on : 17/10/2019, 05:23:49 PM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/HospitalProject/Css/creacion-admin.css">
      
        <title>JSP Page</title>
    </head>
    <body>
                        <% 
    if(request.getParameter("error")!=null){
    if(request.getParameter("error").equals("error")){
      String alert="alert('"+"Registro no creado"+"');";
                     out.print("<script>"+alert+"</script>");
    }else{
      String alert="alert('"+"Registro creado exitosamente"+"');";
                     out.print("<script>"+alert+"</script>");
    }
    }
    %>
       <div style="width: 100%;">
        <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Bievenido a la creacion de operaciones validas por el hospital
        </h2>
        <br>
        <form class="fc1" action="/HospitalProject/adminsesion?id=4" method="GET" autocomplete="off">
         <input type="text" name="id" value="4" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <tr>
                <td>
                    
                    <select required name="tipo" class="styled-select" id="">
                        <option  required  >Ambos</option>
                        <option  required  >Empleado</option>
                        <option  required  >Especialista</option>
                    </select>
                </td>
                <td>
                    <h2>Fecha de creacion</h2>
                    <input required type="date" name="fecha" id="">
                </td>

            </tr>
            <tr>
                <td>
                    <input required type="text" name="costo" placeholder="tarifario">
                </td>
                <td>
                    <input required type="text" name="nombre" placeholder="nombre de operacion" placeholder="descripcion" id="">
                </td>
            </tr>
              <tr>
                <td>
                         <input required type="text" name="precio" placeholder="costo de la operacion" placeholder="descripcion" id="">
               
                </td>
            </tr>
            <tr> <td><input type="submit" value="crear" style="margin: auto; width: 460px;"></td> </tr>
        </table>
        </form>
       </div>
    </body>
</html>