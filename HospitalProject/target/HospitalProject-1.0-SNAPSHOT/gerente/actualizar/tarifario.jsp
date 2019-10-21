<%-- 
    Document   : tarifario
    Created on : 20/10/2019, 10:04:03 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paquetescompartidos.operaciones"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/HospitalProject/Css/gerente.css">
      
        <title>JSP Page</title>
    </head>
                   <% 
                           
                char a='"';    
                String c=Character.toString(a);
    if(request.getParameter("error")!=null){
    if(request.getParameter("error").equals("error")){
      String alert="alert('"+"registro no actualizado, intente de nuevo"+"');";
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
            <input type="text" name="ids" value="1" style="opacity: 0; height: 0; width: 0;">
           
            <table class="c1">
              
                <thead>
                    <tr>
                        <th>Precio</th>
                         <th>costo</th>
                        <th>actualizar</th>
                    </tr>
                </thead>
               
                  <tr>
                      <td>
                          <input required type="text" name="precio" placeholder="costo de creacion">
          
                      </td>
                </tr>
                <%
                    LinkedList <operaciones> tmporal=operaciones.operaciones();
                    
                   
                for(int i=0;i<tmporal.size();i++){
                
                out.print("<tr>"
                        + "<td><h2>"+tmporal.get(i).getPrecio()+"</h2></td>"
                                + "<td><h2>"+tmporal.get(i).getTarifa()+"</h2></td>"
                                        + "<td><input name="+c+"id"+c+" type="+c+"submit"+c+" value="+c+tmporal.get(i).getNombre()+c+" ></td></tr> ");
                }    
                %>
                
                
                
           
        
        </table>
        </form>
       </div>
    </body>
</html>