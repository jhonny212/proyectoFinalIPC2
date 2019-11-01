<%-- 
    Document   : crear-empleo
    Created on : 17/10/2019, 05:17:45 PM
    Author     : jhonny
--%>

<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paquetescompartidos.areaDeTrabajo" %>
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
        <% 
         char a='"';    
                String c=Character.toString(a);
                
        %>
          <h2 style="margin: auto;color: white; width: 550px;">
            Bievenido a la creacion de empleos
        </h2>
        <br>
        <form class="fc1" action="/HospitalProject/adminsesion?id=3" method="GET" autocomplete="off">
         <input type="text" name="id" value="3" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <tr>
                <td>
                      <h2 style="height: 0px;">seleccionar area </h2>
                   
                    <select required name="area" class="styled-select" id="">
                     
                         <% 
                          if(iniciarconeccion.coneccion==null){
        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo tmps=new areaDeTrabajo();
                        for(int i=0;i<tmps.areas().size();i++){
                        out.print("<option required>"+tmps.areas().get(i)+"</option>");
                        }
                        %>
                    </select>
                </td>
                <td>
                    <h2>Fecha de creacion</h2><br><br>
                    <input required type="date" name="fecha" id="">
                </td>

            </tr>
            <tr>
                <td>
                    <input required type="text" name="costo" placeholder="sueldo">
                </td>
                <td>
                    <input required type="text" name="nombre" placeholder="nombre del empleo" placeholder="descripcion" id="">
                </td>
            </tr>
          
            <tr> <td><input type="submit" value="crear" style="margin: auto; width: 460px;"></td> </tr>
        </table>
        </form>
       </div>
    </body>
</html>