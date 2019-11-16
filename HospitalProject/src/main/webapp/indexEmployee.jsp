<%-- 
    Document   : indexEmployee
    Created on : 1/11/2019, 10:46:33 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="paquetescompartidos.operaciones"%>
<%@page import="paquetescompartidos.gastos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Css/employee.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% gastos.gastosHabitacion();
        operaciones a=new operaciones();
        a.actualizarVacaciones();
        LinkedList<String> tmp=operaciones.Updateemployee();
        
        
    %>
        <section>
     <div>
         <h1>Iniciar sesion</h1>
         <form action="/HospitalProject/servletemployee" method="POST" autocomplete="off">
             <input type="number" required name="cui" placeholder="cui " id="numero">
             <input type="password" required name="contra" placeholder="contraseña" id="">
             <input type="submit" value="Iniciar sesion">
         </form>
     </div>
        </section>
        <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>
