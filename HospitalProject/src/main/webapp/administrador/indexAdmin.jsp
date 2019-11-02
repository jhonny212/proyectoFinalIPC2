<%-- 
    Document   : indexAdmin
    Created on : 16/10/2019, 12:13:10 PM
    Author     : jhonny
--%>

<%@page import="paquetescompartidos.gastos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paquetescompartidos.iniciarconeccion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/index-admin.css">
        <title>Administrador</title>
    </head>
    <body>
         <% gastos.gastosHabitacion(); %>
       
        <% iniciarconeccion.IniciarConeccion();%>
                   <% 
    if(request.getParameter("error")!=null){
    if(request.getParameter("error").equals("error")){
      String alert="alert('"+"Los datos no coinciden intente de nuevo"+"');";
                     out.print("<script>"+alert+"</script>");
                     
    }
    }
    %>
        <header >
            <div class="navegacion">
             <nav>
                   <a class="crearcuenta" target="blank" href="./registrar-administrador.jsp" >Registrar</a>
            </nav>
            </div> 
        </header>
        <div style="width: 300px; margin: auto;padding: 30px 10px;">
                <form autocomplete="off" class="from1" action="/HospitalProject/adminsesion?id=2" method="POST" >
                        <h2>Iniciar sesion</h2>
                        <input type ="text" id="usuario" name="usuario" placeholder="&#128272; usuario " required/> 
                        <input type ="password" id="contraseña" name="contra" required placeholder="&#128272; contraseña "/>
                        <input type="submit" name ="btn" value="ingresar">
                </form>
        </div>
      
          
    </body>
</html>
