<%-- 
    Document   : datos
    Created on : 20/10/2019, 10:04:12 AM
    Author     : jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Bievenido a la actualizacion de tarifario
        </h2>
          <br>
        <form class="fc1" action="/HospitalProject/servletgerente" method="GET" autocomplete="off">
            <input type="text" name="ids" value="2" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <thead>
                <tr>
                    <th>Actualizar Dato global</th>
                   
                </tr>
            </thead>
                <tr>
                      <td>
                          <input required type="text" name="costo" placeholder="numero ">
          
                      </td>
                </tr>
                
                <tr >
               
                
                <td><input type="submit" value="consulta" name="iddato" style="margin: auto;"></td>
                
            </tr>
            <tr >
               
                
                <td><input type="submit" value="dias de vacaciones" name="iddato" style="margin: auto;"></td>
                
            </tr>
        
              <tr >
               
                
                <td><input type="submit" value="iggs" name="iddato" style="margin: auto;"></td>
                
            </tr>
        </table>
        </form>
       </div>
    </body>
</html>