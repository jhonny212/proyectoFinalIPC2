<%-- 
    Document   : habiliarHabitacion
    Created on : 21/10/2019, 10:14:59 AM
    Author     : jhonny
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="paquetescompartidos.areaDeTrabajo"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="/HospitalProject/Css/gerente.css">
      
        <title>JSP Page</title>
    </head>
    <body>    
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
    
     
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Bievenido a la contratacion de empleados
        </h2>
          <br>
          <form action="/HospitalProject/gerente/principalManager.jsp">
               <input type="text" name="id" value="6" style="opacity: 0; height: 0; width: 0;">
            <h2>Seleccionar area de trabajo</h2>
            <select name="select" >
                   <% 
                          if(iniciarconeccion.coneccion==null){
                        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo T=new areaDeTrabajo();
                        for(int i=0;i<T.areas().size();i++){
                        out.print("<option required>"+T.areas().get(i)+"</option>");
                        }
                   %>
            </select>
            <input type="submit" value="ok">
          </form>
             <form class="fc1" action="/HospitalProject/servletgerente" method="GET" autocomplete="off">
            <input type="text" name="ids" value="6" style="opacity: 0; height: 0; width: 0;">
           
            <table >
            <thead>
                <tr>
                    <th></th><th></th><th></th>
                </tr>
            </thead>
            <tr>
                <td>    <h2>Fecha de renovacion</h2>
                            <input type="date" required name="fecha" id="">
                
                </td>
            </tr>
                        <%
                           char asS='"';    
          String cadenaS=Character.toString(asS);
         
                if(request.getParameter("select")!=null){
                   if(iniciarconeccion.coneccion==null){
                        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo tKK=new areaDeTrabajo();
                        LinkedList<areaDeTrabajo> KSs=tKK.habitacioN(request.getParameter("select"));
                                                for(int i=0;i<KSs.size();i++){
                        out.print("<tr><td><h2>"+KSs.get(i).getDescripcion()+"</h2></td>"
                                + "<td><h2>"+KSs.get(i).getEstado()+"</h2></td>"
                                + "<td> <input type="+cadenaS+"submit"+cadenaS+"name="+cadenaS+"btn"+cadenaS+"     value="+cadenaS+KSs.get(i).getId()+cadenaS+"></td></tr>");
                        }

                }    
                %>
                    
             
        
          
            
        </table>
        </form>
       </div>
    </body>
    
</html>
