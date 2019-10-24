<%-- 
    Document   : crearUsuario
    Created on : 22/10/2019, 10:11:53 AM
    Author     : jhonny
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Css/form-registro.css">
        <title>Administrador</title>
    </head>

    
    <body>
            <% 
    if(request.getParameter("error")!=null){
    if(request.getParameter("error").equals("error")){
        
      String alert="alert('"+"Erro al crear usuario, intente de nuevo"+"');";
                     out.print("<script>"+alert+"</script>");
                     
    }else{
      String alert="alert('"+"Usuario creado exitosamente"+"');";
                     out.print("<script>"+alert+"</script>");
    }
    }
    %>
        <br>
         <form autocomplete="off" class="formbox" action="/HospitalProject/encargado" method="POST">
                <h1 id="titulo">REGISTRAR</h1>
                <input type ="number" id="nombre" name="cui" placeholder="cui" required /> 
                <input type ="password" id="contraseña" name="contra" placeholder=" contraseña " required/>
            
                
                <button type="submit" name="btn" >Registrar</button>
              
               
          </form>  
      
          
    </body>
</html>
