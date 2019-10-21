<%-- 
    Document   : registrarmedico
    Created on : 18/10/2019, 10:50:56 PM
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
        
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Bievenido al registro de medicos especialistas
        </h2>
         <br>
        <form class="fc1" action="/HospitalProject/adminsesion?id=1" method="GET" autocomplete="off">
            <input type="text" name="id" value="5" style="opacity: 0; height: 0; width: 0;">
            <table class="c1" style="width: 500px;">
              
                <tr>
                <td>
                  
                    <br>
                    <br><br><br>
                    <input required type="text" placeholder="nombre" name="nombre" id="">
                </td>
                <td>
                    <h2>Fecha de creacion</h2>
                   
                    <input required type="date" name="fecha" id="">
                </td>

            </tr>
            <tr>
                <td>
                    <input required type="text" name="direccion" placeholder="direccion">
                </td>
                <td>
                    <input required type="number" name="cui" placeholder="cui" >
                </td>
            </tr>
            <tr> <td><input type="submit" value="crear" style="margin: auto; width: 460px;"></td> </tr>
        </table>
        </form>
       </div>
    </body>
</html>
