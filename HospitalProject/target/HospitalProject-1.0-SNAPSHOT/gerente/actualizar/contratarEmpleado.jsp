<%-- 
    Document   : contratarEmpleado
    Created on : 20/10/2019, 10:04:28 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paquetescompartidos.empleado"%>
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
            Bievenido a la contratacion de empleados
        </h2>
          <br>
        <form class="fc1" action="/HospitalProject/servletgerente" method="GET" autocomplete="off">
            <input type="text" name="ids" value="3" style="opacity: 0; height: 0; width: 0;">
           
            <table >
            <thead>
                <tr>
                    <th></th><th></th><th></th>
                </tr>
            </thead>
            <tr>
                <td><input type="number" name="cui" placeholder="cui" id=""></td>
                <td><input type="number" name="telefono" placeholder="telefono" id=""></td>
                <td><input type="text" name="nombre" placeholder="nombre" id=""></td>
            </tr>
            
            <tr>
               
                
                <td><input type="number" name="horas" placeholder="horas de trabajo" id=""></td>
                
                <td><input type="number" name="sueldo" placeholder="sueldo" id=""></td>
                <td><input type="text" name="direccion" placeholder="direccion" id=""></td>
           
            </tr>
            <tr>
                <td><input type="date" name="fecha" id=""></td>
                <td>  
            <select name="empleo"  id="">
                    <% 
                        LinkedList<String> tm=empleado.empleos();
                    for(int i=0; i<tm.size();i++){
                    out.print("<option>"+tm.get(i)+"</option>");
                    }
                  
                    %>
            </select></td>
            <td>
                <input type="submit" value="registrar">
            </td>
            </tr>
               
            
        </table>
        </form>
       </div>
    </body>
</html>
