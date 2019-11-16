<%-- 
    Document   : firmar
    Created on : 1/11/2019, 10:41:06 PM
    Author     : jhonny
--%>
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
      String alert="alert('"+"Error al firmar, intente de nuevo"+"');";
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
            Firmar vacacion
        </h2>
          <br>
          <h2>Escriba el cui</h2>
                    <form action="./principalEncargado.jsp?id=1">
                        <input type="text" name="id" value="0" style="opacity: 0; height: 0; width: 0;">
           
                         <input required style="height: 40px; background: none; border: 1px solid white; border-radius: 20px; " id="numero" type="number" placeholder="cui" name="cui" >
                            <input type="submit" value="ok">
                        </form>
        <form class="fc1" action="/HospitalProject/encargado" method="GET" autocomplete="off">
            <input type="text" name="ids" value="0" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <thead>
                <tr>
                   <th>Nombre</th>
                    <th>Vacaciones</th>
                    <th>Telefono</th>
                    <th>Cui</th>
                </tr>
            </thead>
          
              
               <%
                   if(request.getParameter("cui")!=null){
                       try{
                       
                             char as='"';    
               String c=Character.toString(as);
               encargadoEmpleado tmp=new encargadoEmpleado();
               Integer.parseInt(request.getParameter("cui"));
               tmp=tmp.asignarVacaciones(request.getParameter("cui"),"1");
                   if(tmp.getNombre()!=null){
                      
                     out.print("<td><h2>"+tmp.getNombre()+"</h2></td>");
                     out.print("<td><h2>"+tmp.getDireccion()+"</h2></td>");
                     out.print("<td><h2>"+tmp.getTelefono()+"</h2></td>");
                     out.print("<td><h2 name="+c+"cui"+c+">"+tmp.getCui()+"</h2></td>    </tr>");
                     out.print("<input type="+c+"text"+c+"name="+c+"cui"+c+"value="+c+request.getParameter("cui")+c+""
                             + "style="+c+"opacity:0;height:0;width:0;"+c);
                     out.print("<tr><td><input type="+c+"submit"+c+"></td></tr>");
                           
               
                   
                   }
                     }catch(Exception e){}
               }
               %>
              
       
        
        </table>
        </form>
       </div>
       <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>