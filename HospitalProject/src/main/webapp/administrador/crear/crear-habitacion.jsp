<%-- 
    Document   : crear-habitacion
    Created on : 17/10/2019, 04:49:55 PM
    Author     : jhonny
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.LinkedList"%>
<%@page import="paquetescompartidos.areaDeTrabajo"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
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
            Bievenido a la creacion de habitaciones
        </h2>
        <br>
       <form class="fc1" action="/HospitalProject/adminsesion" method="GET" autocomplete="off">
          <input type="text" name="id" value="2" style="opacity: 0; height: 0; width: 0;">
           
           <table class="c1" style="width: 500px;">
            <tr>
                <td>
                     <h2 style="height: 0px;">seleccionar area </h2>
                    <select required name="area" class="styled-select" id="">
                      <% 
                          if(iniciarconeccion.coneccion==null){
                        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo t=new areaDeTrabajo();
                        LinkedList<String> ss=t.areas();
                        for(int i=0;i<t.areas().size();i++){
                        out.print("<option required>"+t.areas().get(i)+"</option>");
                        }
                   %>
                   
                    </select>
                </td>
                <td>
                    <h2>Fecha de creacion </h2>
                    <br><br>
                    <input required type="date" name="fecha" id="">
                </td>

            </tr>
            <tr>
                <td>
                    <input required type="text" name="costo" placeholder="costo de mantenimiento">
                </td>
                <td>
                    <textarea name="descripcion" placeholder="descripcion" id="" cols="30" rows="10"></textarea>
                </td>
            </tr>
            
            <tr> <td><input type="submit" value="crear" style="margin: auto; width: 460px;"></td> </tr>
        </table>
        </form>
       </div>
    </body>
</html>