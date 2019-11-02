<%-- 
    Document   : solicitarconsulta
    Created on : 27/10/2019, 11:29:42 AM
    Author     : jhonny
--%>

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
            Nuevo ingreso de medicamentos
        </h2>
          <br>
        <form action="/HospitalProject/recepcionista/indexrecepcion.jsp?id=1">
            <table>
                    <input type="text" name="id" value="1" style="opacity: 0; height: 0; width: 0;">
           
                <tr>
                    <td><h2>Cui</h2></td>
                </tr>
                <tr>
                    <td> 
                        <input type="number" required name="cui" id="">
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
                    <tr>
        <td>
            <h2 >Seleccione una habitacion</h2>
        </td>
    </tr>
    <tr>
        <td><select name="seleccion" id="">
                <% 
                LinkedList<String> habitacion=habitacioN.habitaciones("Consulta","");
                for(int i=0;i<habitacion.size();i++){
                %>
                <option ><% 
                    out.print(habitacion.get(i));
                    %></option>
                <% }%>
        </select>
        </td>
    </tr>
            </table>
        </form>
          <form class="fc1" style="width: 1000px; " id="formget" action="/HospitalProject/recepcion" method="GET" autocomplete="off">
            <input type="text" name="ids" value="1" style="opacity: 0; height: 0; width: 0;">
            <td><input type="number" name="cui" value<%out.print("='"+request.getParameter("cui")+"'"); %> style="opacity: 0; height: 0px; width: 0px;">
                <input type="text" name="seleccion" value<%out.print("='"+request.getParameter("seleccion")+"'"); %> style="opacity: 0; height: 0; width: 0;">
              
             
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
    LinkedList <String> lis=new LinkedList();
      LinkedList <String> lis2=new LinkedList();
    for(int i=8;i<=18;i++){
    lis.add(Integer.toString(i));
    }
    habitacioN prueba =new habitacioN();
    LinkedList<consulta> consul=prueba.disponibilidad(Integer.parseInt(request.getParameter("seleccion")));
    out.print("<tr> <td> <h2> Horas de consulta disponible </h2></td></tr>");
   // out.print("holaaaaaaaa"+habitacioN.disponibilidad(Integer.parseInt(request.getParameter("seleccion"))).size());
   if(consul.size()==0){
        int contador=5;
         
     for(int i=0;i<lis.size();i++){
       if(contador==5){
           out.print("<tr>");
       contador=0;
       }
       out.print("<td>");
       %>
       <input type="submit" name="time" value<%out.print("='"+lis.get(i)+":00'"); %>>
       <%
        out.print("</td>");
        contador++;
          if(contador==5){
           out.print("<tr>");
       contador=0;
       }
    }
      
        
    }else{
LinkedList<String >hora =new LinkedList();
 int contadoR=5;
int count=0;
boolean validaR=true;
    for(int i=0;i<lis.size();i++){
 validaR=true;
   for(int j=0;j<consul.size();j++){
   
    if(lis.get(i).equals(consul.get(j).getHora())){
    validaR=false;
   
    break;
}


}
  if(validaR){
 if(contadoR==5){
           out.print("<tr>");
       contadoR=0;
       }
       out.print("<td>");
       %>
       <input type="submit" name="time" value<%out.print("='"+lis.get(i)+":00'"); %>>
       <%
        out.print("</td>");
        contadoR++;
          if(contadoR==5){
           out.print("<tr>");
       contadoR=0;
       }
}
    
}
      
    }
    }
          %>
        </table>
        <br>
        </form>
       </div>
    </body>
</html>