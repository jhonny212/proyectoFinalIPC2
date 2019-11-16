<%-- 
    Document   : pagoEspecialista
    Created on : 22/10/2019, 10:12:07 AM
    Author     : jhonny
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="servletEncargadoEmpleado.encargadoEmpleado"%>
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
            Bievenido a pagos de especialista
        </h2>
          <br>
          <h2>Escriba el cui</h2>
                    <form action="./principalEncargado.jsp">
                        <input type="text" name="id" value="7" style="opacity: 0; height: 0; width: 0;">
           
                         <input required style="height: 40px; background: none; border: 1px solid white; border-radius: 20px; " type="number" id="numero" placeholder="cui" name="cui" >
                            <input type="submit" value="ok">
                        </form>
        <form class="fc1" action="/HospitalProject/encargado" method="GET" autocomplete="off">
            <input type="text" name="ids" value="7" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <thead>
                <tr>
                    <th>Operacion</th>
                   <th>Habitacion </th>
                    <th> id Operacion</th>
                   
                </tr>
            </thead>
          
              
               <%
                   if(request.getParameter("cui")!=null){
                     String sql="select a.idinternado, a.nombre, a.idcrearHabitacion from internado a join especialistaDestinado b on a.idinternado=b.idinternado where b.cui=? && a.estado='Cancelado' or a.estado='Si' ;";
                 if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
                 PreparedStatement select=iniciarconeccion.coneccion.prepareStatement(sql);
                 select.setInt(1,Integer.parseInt(request.getParameter("cui")));
                 ResultSet resultado=select.executeQuery();
                
                 while(resultado.next()){
                 out.print("<tr><td><h2>"+resultado.getString("a.nombre")+"</h2></td>");
                 out.print("<td><h2>"+resultado.getInt("a.idcrearHabitacion")+"</h2></td>");
                 out.print("<td><input type='submit' name='valor' value='"+resultado.getInt("a.idinternado")+"' ></td></tr>");
                 }
               }
               %>
              
       
        
        </table>
        </form>
       </div>
       <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>