<%-- 
    Document   : asignarespecialista
    Created on : 29/10/2019, 08:56:02 PM
    Author     : jhonny
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servletrecepcion.enfermera"%>
<%@page import="servletrecepcion.medico"%>
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
            Registro de enfermeras
        </h2>
          <br>
    
          <form class="fc1" style="width: 1000px; " id="formget" action="/HospitalProject/servletenfermera" method="GET" autocomplete="off">
           
             
            <table class="c1" style="width: 1000px; ">
         <thead>
                <tr>
                 <th></th>
                 <th></th>
                 <th></th>
                 <th></th>
                 </tr>
            </thead>
  
 <tr>
     <input type="text" name="ids" value="3" style="opacity: 0; height: 0; width: 0;">
     
     <%
     String sql="select b.tipo from internado a join operaciones b  join contratoEmpleado d  on a.nombre=b.nombreOperacion WHERE a.estado='No' && d.cui=?;";
     PreparedStatement state=iniciarconeccion.coneccion.prepareStatement(sql);
       HttpSession sesiOn=request.getSession();
       int cui=Integer.parseInt(sesiOn.getAttribute("cui").toString());
       
     state.setInt(1, cui);
     ResultSet res=state.executeQuery();
     String tipo="";
if(res.next()){
tipo=res.getString("b.tipo");
}
     %>
  <%
     
      if(tipo.equals("Ambos") || tipo.equals("Especialista") ){
      LinkedList<medico> Listad=medico.medicoEspecialista("3");
                 %>
 </tr>
          
                   <% for(int i=0;i<Listad.size();i++){ 
                  out.print("<tr> ");
                  %>
                  <%out.print("<td><h2>"+Listad.get(i).getDireccion()+"</h2></td>"); %>
                  <%out.print("<td><h2>"+Listad.get(i).getNombre()+"</h2></td>"); %>
                  <%out.print("<td><input type='submit' name='seleccion1' value='"+Listad.get(i).getCui()+"'></td>"); %>
                
                  <%
                   out.print("</tr></td>");
                  } }%>

        </table>
        <br>
        </form>
       </div>
    </body>
</html>
