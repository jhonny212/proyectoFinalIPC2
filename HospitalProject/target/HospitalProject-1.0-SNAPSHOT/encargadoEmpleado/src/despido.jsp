<%-- 
    Document   : despido
    Created on : 22/10/2019, 10:00:16 AM
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
          <h2>Escriba el cui</h2>
                    <form action="./principalEncargado.jsp">
                        <input type="text" name="id" value="3" style="opacity: 0; height: 0; width: 0;">
           
                         <input required style="height: 40px; color: white; background: none; border: 1px solid white; border-radius: 20px; " type="number" placeholder="cui" name="cui" >
                            <input type="submit" value="ok">
                        </form>
        <form class="fc1" action="/HospitalProject/encargado" method="GET" autocomplete="off">
            <input type="text" name="ids" value="3" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1" style="width: 500px;">
            <thead>
                <tr>
                    <th>Descripcion</th>
                   <th>Nombre</th>
                    <th>Vacaciones</th>
                    <th>Telefono</th>
                    <th>Cui</th>
                </tr>
            </thead>
            <td>
                <textarea style="color: white;" name="descripcion" placeholder="descripcion" id="" cols="30" rows="10"></textarea>
            </td>
            <%
                   if(request.getParameter("cui")!=null){
                       try{
                       
                             char as='"';    
               String c=Character.toString(as);
               encargadoEmpleado tmp=new encargadoEmpleado();
               Integer.parseInt(request.getParameter("cui"));
               tmp=tmp.asignarVacaciones(request.getParameter("cui"),"1");
                   if(tmp.getNombre()!=null){
                      
                     out.print(" <tr><td><input required  type="+c+"date"+c+"name="+c+"fecha"+c+"></td>");
                     out.print("<td><h2>"+tmp.getNombre()+"</h2></td>");
                     out.print("<td><h2>"+tmp.getDireccion()+"</h2></td>");
                     out.print("<td><h2>"+tmp.getTelefono()+"</h2></td>");
                     out.print("<td><h2 name="+c+"cui"+c+">"+tmp.getCui()+"</h2></td>    </tr>");
                     out.print("<input type="+c+"text"+c+"name="+c+"cui"+c+"value="+c+tmp.getTelefono()+c+""
                             + "style="+c+"opacity:0;height:0;width:0;"+c);
                     out.print("<tr><td><input type="+c+"submit"+c+"></td></tr>");
                           
               
                   
                   }else{
             
                   }
                     }catch(Exception e){
                     out.print(e.getMessage());
                     }
               }
               %>
              
        
        </table>
        </form>
       </div>
    </body>
</html>