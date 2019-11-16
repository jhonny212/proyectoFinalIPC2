<%-- 
    Document   : pagarinternado
    Created on : 27/10/2019, 11:30:40 AM
    Author     : jhonny
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servletrecepcion.consulta"%>
<%@page import="servletrecepcion.habitacioN"%>
<%@page import="servletrecepcion.paciente"%>
<%@page import="java.util.LinkedList"%>
<%@page import="paquetescompartidos.iniciarconeccion"%>
<%@page import="servletoperador.medicamento"%>
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
      String alert="alert('"+"Error al pagar"+"');";
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
            Nuevo ingreso de medicamentos
        </h2>
          <br>
        <form action="/HospitalProject/recepcionista/indexrecepcion.jsp">
            <table>
                    <input type="text" name="id" value="4" style="opacity: 0; height: 0; width: 0;">
           
                <tr>
                    <td><h2>Ingresar cui</h2></td>
                </tr>
                <tr>
                    <td> 
                        <input type="number" required name="cui" id="numero">
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
                    <tr>
      
    </tr>
   
            </table>
        </form>
          <form class="fc1" style="width: 900px; " id="formget" action="/HospitalProject/recepcion" method="GET" autocomplete="off">
          <input type="text" name="ids" value="4" style="opacity: 0; height: 0; width: 0;">
                         
             
            <table class="c1" style="width: 900px; ">
         <thead>
                <tr>
                    <th>Paciente</th>
                    <th>Tarifario de operacion </th>
                    <th>Gastos de medicamenot</th>
                    <th>Total</th>
                       <th>Pagar</th>
                 <% 
                 if(request.getParameter("cui")!=null){    
                   
                 String sql=" select a.cui, b.precio, sum(c.costo) as suma,  b.precio+ sum(c.costo) as total,  a.idinternado from internado a   join operaciones b on b.nombreOperacion=a.nombre  join medicamentosUsados c on c.idinternado=a.idinternado where a.cui=? && a.estado='Si' group by(a.idinternado) ;";
                 if(iniciarconeccion.coneccion==null){iniciarconeccion.IniciarConeccion();}
                 try{
                 PreparedStatement select=iniciarconeccion.coneccion.prepareStatement(sql);
                 select.setInt(1,Integer.parseInt(request.getParameter("cui")));
                 ResultSet resultado=select.executeQuery();
                
                 while(resultado.next()){
                 out.print("<tr><td><h2>"+resultado.getInt("a.cui")+"</h2></td>");
                 out.print("<td><h2>"+resultado.getDouble("b.precio")+"</h2></td>");
                 out.print("<td><h2>"+resultado.getDouble("suma")+"</h2></td>");
                 out.print("<td><h2>"+resultado.getDouble("total")+"</h2></td>");
                 out.print("<td><input type='submit' name='valor' value='"+resultado.getInt("a.idinternado")+"' ></td></tr>");
                 }
                 }catch (SQLException ex) {
                out.print(ex.getMessage()+"aca");
            }
               }else{
               
                 }
                 %>
                </tr>
            </thead>
             </table>
       
        </form>
       </div>
       <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>