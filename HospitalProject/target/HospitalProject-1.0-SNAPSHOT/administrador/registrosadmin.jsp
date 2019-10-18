<%-- 
    Document   : registrosadmin
    Created on : 17/10/2019, 03:13:23 PM
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
                <li><a href="./paginaadmin.jsp">Creacion de datos</a></li>
                <li><a href="./actualizaradmin.jsp">actualizar datos</a></li>
                <li><a href="./empleadoadmin.jsp">datos empleado</a></li>
                <li><a href="registrosadmin.jsp">Registros</a></li>
                <li><a href="registrosadmin.jsp?id=1">realizar renuncia</a></li>
                <li><a href="registrosadmin.jsp?id=2">realizar despido</a></li>
                <li><a href="registrosadmin.jsp?id=3">registrar medico especialista</a></li>
           


            </ul>
        </div>
        
        <div class="contenido">
              <img src="" alt="s"  class="menu-bar">
        </div>
              <script src="../Js/abrir.js"></script>
    </body>
</html>
