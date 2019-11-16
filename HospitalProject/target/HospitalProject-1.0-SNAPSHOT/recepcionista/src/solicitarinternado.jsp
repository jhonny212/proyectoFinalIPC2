<%-- 
    Document   : solicitarinternado
    Created on : 27/10/2019, 11:29:54 AM
    Author     : jhonny
--%>

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
                Solicitud de cirugias
        </h2>
          <br>
        <form action="/HospitalProject/recepcionista/indexrecepcion.jsp?id=1">
            <table>
                    <input type="text" name="id" value="3" style="opacity: 0; height: 0; width: 0;">
           
                <tr>
                    <td><h2>Cui</h2></td>
                </tr>
                <tr>
                    <td> 
                        <input type="number" required name="cui" id="numero">
                    </td>
                    <td>
                        <input type="text" required name="operacion" placeholder="operacion solicitada" id="">
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
            </table>
        </form>
          <form class="fc1" style="width: 1000px; " id="formget" action="/HospitalProject/recepcion" method="GET" autocomplete="off">
            <input type="text" name="ids" value="3" style="opacity: 0; height: 0; width: 0;">
            <td><input type="number" name="cui" value<%out.print("='"+request.getParameter("cui")+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
                <input type="text" name="nombre" value<%out.print("='"+request.getParameter("operacion")+"'"); %> style="opacity: 0; height: 0; width: 0;">
              
             
            <table class="c1" style="width: 1000px; ">
         <thead>
                <tr>
                 <th></th>
                 <th></th>
                 <th></th>
                 <th></th>
                 </tr>
            </thead>
            <% 
                try{
            if(request.getParameter("cui")!=null){
                paciente tmp=paciente.paciente(Integer.parseInt(request.getParameter("cui")));
               if(tmp.getCui()!=0){
            %>
     
            
            <%
            }else
{    
        %>
        <tr>
            <td></td>
            <td></td>
            <td><h2>Telefono</h2></td>
            <td></td>
        </tr>
            <tr>
                <td><input type="text" name="nombre" placeholder="nombre" id="">
                    </td>
                <td><input type="text" name="direccion" placeholder="direccion" id="">
                </td>
                <td><input type="number" name="telefono" id="">
                </td>
            </td>
          
            </tr>

        <%
        }
    %>
       
    
    <%
        LinkedList<String> habitaciones=habitacioN.habitaciones("operacion",request.getParameter("operacion"));
        String letra="";
        try{
       letra =habitaciones.get(0);
        }catch(IndexOutOfBoundsException e){}

%>
    <tr>
          
           <td><h2>Asignar enfermera</h2></td>
            <td><h2>Habitaciones</h2></td>
           <%if(letra.equals("Empleado")){ %>
           <td><h2>Medicos(Empleados)</h2></td> <%} %>
              <%if(letra.equals("Especialista")){ %>
           <td><h2>Medicos(Especialistas)</h2></td> <%} %>
              <%if(letra.equals("Ambos")){ %>
           <td><h2>Medicos(Empleados)</h2></td> 
           <td><h2>Medicos(Especialista)</h2></td> 
           
           <%} %>
    </tr>  
               <tr>
                       <td><select name="enfermera" id="">
                <% 
                LinkedList<enfermera> ListadO=enfermera.medico("s");
                for(int i=0;i<ListadO.size();i++){ 
                %>
                <option ><% 
                    out.print(ListadO.get(i).getNombre());
                    %></option>
                <% }%>
        </select>
</td> 
       
                           <td><select name="habitacion" id="">
                <% 
                for(int i=1;i<habitaciones.size();i++){ 
                %>
                <option ><% 
                    out.print(habitaciones.get(i));
                    %></option>
                <% }%>
        </select>
        </td>
    
  
        <%
            try{
            if(habitaciones.get(0).equals("Empleado")){

%>

<td><select name="seleccion1" id="">
                <% 
                LinkedList<medico> Listado=medico.medico(habitaciones.get(0));
                for(int i=0;i<Listado.size();i++){ 
                %>
                <option ><% 
                    out.print(Listado.get(i).getNombre());
                    %></option>
                <% }%>
        </select>
</td>   

<td><select name="seleccion2" style="opacity: 0;"   ><option >No</option></select></td>
<% }

}catch(IndexOutOfBoundsException e){}
%>    
        <%try{
            if(habitaciones.get(0).equals("Especialista")){

%>
<td><select name="seleccion2" id="">
  
                <% 
                LinkedList<medico> Listado=medico.medicoEspecialista("3");
                for(int i=0;i<Listado.size();i++){ 
                %>
                <option ><% 
                    out.print(Listado.get(i).getNombre());
                    %></option>
                <% }%>
        </select>
</td>  
<td><select name="seleccion1" style="opacity: 0;"   ><option >No</option></select></td>
<% }

}catch(IndexOutOfBoundsException e){}
%>  
    <%try{
        if(habitaciones.get(0).equals("Ambos")){

%>
<td><select name="seleccion1" id="">
        <option>No</option>
                <% 
                LinkedList<medico> Listado=medico.medicoEspecialista("1");
                for(int i=0;i<Listado.size();i++){ 
                %>
                <option ><% 
                    out.print(Listado.get(i).getNombre());
                    %></option>
                <% }%>
        </select>
</td>    
<td><select name="seleccion2" id="">
        <option>No</option>
                <% 
                LinkedList<medico> Listado2=medico.medicoEspecialista("3");
                for(int i=0;i<Listado2.size();i++){ 
                %>
                <option ><% 
                    out.print(Listado2.get(i).getNombre());
                    %></option>
                <% }%>
        </select>
</td>  
<% }
}catch(IndexOutOfBoundsException e){}%> 
 </tr> 
 <tr>
   <td><input type="date" name="fecha" required id=""></td>
    <td><input type="submit" value="ok"></td>
   
 </tr>
          
    <%
  }}catch(NumberFormatException e){
                response.sendRedirect("http://localhost:8080/HospitalProject/recepcionista/indexrecepcion.jsp?id=3");
                }
          %>
        </table>
        <br>
        </form>
       </div>
       <script src="http://localhost:8080/HospitalProject/Js/archivos.js"> </script>
   
    </body>
</html>