<%-- 
    Document   : indexnurse
    Created on : 29/10/2019, 08:54:58 PM
    Author     : jhonny
--%>
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
               
                <li><a href="./indexnurse.jsp?id=1">Asignar enfermera</a></li>
                <li><a href="./indexnurse.jsp?id=2">Asignar medico</a></li>
                <li><a href="./indexnurse.jsp?id=3">Asignar especialista</a></li>
                <li><a href="./indexnurse.jsp?id=4">Asignar medicamentos </a></li>
                <li><a href="./indexnurse.jsp?id=5">Dar de alta</a></li>
             
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
                  
                      case "1":%>
                      <%@include file="./src/asignarenfermera.jsp" %>
                       <%   
                      break;
                       case "2":
                      %>
                       <%@include file="./src/asignarmedico.jsp" %>
                     <%   
                      break;
                       case "3":
                      %>
                       <%@include file="./src/asignarespecialista.jsp" %>
                     <%   
                      break;
                       case "4":
                      %>
                    <%@include file="./src/asignarmedicamento.jsp" %>
                            
                  <%   
                      break;
                      case "5":
                      
                      %>
                       <%@include file="./src/dardealta.jsp" %>
                     <%
                          break;
                       case "6":
                       
                      %> 
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