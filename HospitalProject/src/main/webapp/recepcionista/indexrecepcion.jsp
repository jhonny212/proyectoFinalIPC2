<%-- 
    Document   : indexrecepcion
    Created on : 27/10/2019, 11:29:25 AM
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
                <li><a href="./indexrecepcion.jsp?id=1">Solicitar consulta</a></li>
               
                <li><a href="./indexrecepcion.jsp?id=2">Pagar consulta</a></li>
                <li><a href="./indexrecepcion.jsp?id=3">Solicitar internado</a></li>
             
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
                      <%@include file="./src/solicitarconsulta.jsp" %>
                       <%   
                      break;
                       case "3":
                      %>
                       <%@include file="./src/solicitarinternado.jsp" %>
                     
                      <%   

                      break;
                       case "2":
                      %>
                       <%@include file="./src/pagarconsulta.jsp" %>
                     
                      <%   
                      
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