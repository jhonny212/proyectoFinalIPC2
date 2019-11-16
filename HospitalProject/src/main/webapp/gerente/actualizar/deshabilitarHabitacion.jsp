<%-- 
    Document   : deshabilitarHabitacion
    Created on : 21/10/2019, 10:15:11 AM
    Author     : jhonny
--%>

<%@page import="paquetescompartidos.areaDeTrabajo"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paquetescompartidos.empleado"%>
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
      String alert="alert('"+"Error al deshabilitar"+"');";
                     out.print("<script>"+alert+"</script>");
    }else{
      String alert="alert('"+"habitacion deshabilitada"+"');";
                     out.print("<script>"+alert+"</script>");
    }
    }
    %>
    <body>
        
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
            Bievenido a la contratacion de empleados
        </h2>
          <br>
          <form action="/HospitalProject/gerente/principalManager.jsp">
               <input type="text" name="id" value="5" style="opacity: 0; height: 0; width: 0;">
            <h2>Seleccionar area de trabajo</h2>
            <select name="select" >
                   <% 
                          if(iniciarconeccion.coneccion==null){
                        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo t=new areaDeTrabajo();
                        LinkedList<String> ss=t.areas();
                        for(int i=0;i<t.areas().size();i++){
                        out.print("<option required>"+t.areas().get(i)+"</option>");
                        }
                   %>
            </select>
            <input type="submit" value="ok">
          </form>
                  <form class="fc1" action="/HospitalProject/servletgerente" method="GET" autocomplete="off">
            <input type="text" name="ids" value="5" style="opacity: 0; height: 0; width: 0;">
           
            <table >
            <thead>
                <tr>
                    <th></th><th></th><th></th>
                </tr>
            </thead>
            <tr>
                <td>
                    <textarea name="descripcion" style="height: 100px; background: rgb(202, 198, 198); border: 1px solid white;" name="" id="" cols="30" placeholder="descripcion de deshabilitado" rows="10"></textarea>
                </td>
                <td>
                        <input type="date" name="fecha" id="">
                </td>
                <td>
                        <input type="text" name="costo" placeholder="costo que tendra" id="">
                </td>
            </tr>
                <%
                           char as='"';    
          String cadenas=Character.toString(as);
         
                if(request.getParameter("select")!=null){
                   if(iniciarconeccion.coneccion==null){
                        iniciarconeccion.IniciarConeccion();}
                        areaDeTrabajo tK=new areaDeTrabajo();
                        LinkedList<areaDeTrabajo> Ks=tK.habitacion(request.getParameter("select"));
                                                for(int i=0;i<Ks.size();i++){
                        out.print("<tr><td><h2>"+Ks.get(i).getDescripcion()+"</h2></td>"
                                + "<td> <input type="+cadenas+"submit"+cadenas+"name="+cadenas+"btn"+cadenas+"     value="+cadenas+Ks.get(i).getId()+cadenas+"></td></tr>");
                        }

                }    
                %>
          
            
        </table>
        </form>
       </div>
    </body>
</html>