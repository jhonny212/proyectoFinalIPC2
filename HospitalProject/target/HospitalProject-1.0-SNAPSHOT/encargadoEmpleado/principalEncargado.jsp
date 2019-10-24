<%-- 
    Document   : principalEncargado
    Created on : 22/10/2019, 10:26:59 AM
    Author     : jhonny
--%>


<%@page import="paquetescompartidos.operaciones"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-1.11.3.min.js" ></script>
        <link rel="stylesheet" href="../Css/principal-admin.css">

        <title>JSP Page</title>
         <script>
    function My_onLoad(){
       
        var alto= $(".sidebar").height();
             console.log(alto);
           
             if(alto>637){
                $(".contenido").height(alto);
             }else{
                $(".contenido").height(637);
                console.log("sa");
                $(".sidebar").height(637);
                 
             }

             
    }
    </script>
    </head>
    <body onload="My_onLoad()">
          <div class="sidebar">
            <h2>MENU</h2>
            <ul>
                <li><a href="">Cerrar sesion</a></li>
                <li><a href="./principalEncargado.jsp">Cerrar sesion</a></li>
                <li><a href="./principalEncargado.jsp?id=1">Asignar vacaciones</a></li>
                <li><a href="./principalEncargado.jsp?id=2">Actualizar vacaciones</a></li>
                <li><a href="./principalEncargado.jsp?id=3">Despido</a></li>
                <li><a href="./principalEncargado.jsp?id=4">Renuncia</a></li>
                <li><a href="./principalEncargado.jsp?id=5">pago empleo</a></li>
                    <li><a href="./principalEncargado.jsp?id=6">crear usuario</a></li>
            
                    <li><a href="./principalEncargado.jsp">pago especialista</a></li>
                <li><a href="./principalEncargado.jsp">aumento salarial</a></li>
            
                 
            </ul>
        </div>
        
        <div class="contenido">
              <img src="" alt="s"  class="menu-bar">
              <div class="contenedor-crear" style="width: 90%;">
                  <% 
                  boolean validar=false;
                  if(request.getParameter("id")!=null){
                      validar=true;
                  }
                  %>
                  <% 
                  if(validar){
                  %>
                  <% 
                  switch (request.getParameter("id")){
                  
                      case "1":
                  Calendar fecha = new GregorianCalendar();
                   int dia = fecha.get(Calendar.DAY_OF_MONTH);
                   int mes=fecha.get(Calendar.MONTH);
                   
                    if(mes<1 && dia<29){
                    
                    
                    %>
                      <%@include file="./src/asignarVacaciones.jsp" %>
                       <%   }
                        else{
                           String alert="alert('"+"El mes de asignacion ha pasado"+"');";
                     out.print("<script>"+alert+"</script>");
                        operaciones op =new operaciones();
                        op.actualizarVacaciones();
                        }
                      break;
                       case "2":
                      %>
                        <%@include file="./src/actualizarVacaciones.jsp" %>
                     <%   
                      break;
                       case "3":
                      %>
                       <%@include file="./src/despido.jsp" %>
                     <%   
                      break;
                       case "4":
                      %>
                   <%@include file="./src/renuncia.jsp" %>
                             
                  <%   
                      break;
                      case "6":
                      
                      %>
                       <%@include file="./src/crearUsuario.jsp" %>
                         <%   
                      break;
                      case "7":
                      
                      %>
                       <%@include file="./src/pagoEspecialista.jsp" %>
                         <%   
                      break;
                      case "8":
                      
                      %>
                       <%@include file="./src/aumentoSalarial.jsp" %>
                  <%
                          break;
                       case "5":
                       
                      %>  
                         <%@include file="./src/pagoEmpleado.jsp" %>
                
                      <%   
                      break;}
                     %>
                  <% 
                 }
                %>
                  
              </div>
        </div>
              <script src="../Js/abrir.js"></script>
    </body>
</html>