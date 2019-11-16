<%-- 
    Document   : reportes
    Created on : 14/11/2019, 11:05:14 AM
    Author     : jhonny
--%>

<%@page import="java.util.Calendar"%>
<%@page import="servletEncargadoEmpleado.encargadoEmpleado"%>
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
            
          String alert="alert('"+"El archivo ya existe"+"');";
                         out.print("<script>"+alert+"</script>");
                         
        }else{
          String alert="alert('"+"Reporte creado exitosamente"+"');";
                         out.print("<script>"+alert+"</script>");
        }
        }
        %>
       <div style="width: 100%;">
      
   <br>
        <h2 style="margin: auto;color: white; width: 550px;">
           Seccion de reportes
        </h2>
          <br>
        <form class="fc1" style="width: 1200px;" action="/HospitalProject/Operator" method="GET" autocomplete="off">
            <%
                   Calendar fecha=Calendar.getInstance();
                   int año=fecha.get(Calendar.YEAR);
                   int mes=fecha.get(Calendar.MONTH)+1;
                   int dia=fecha.get(Calendar.DAY_OF_MONTH);
                 
                   %>
            <input type="text" name="ids" value="4" style="opacity: 0; height: 0; width: 0;">
          
            <table class="c1" style="width: 1200px; ">
            <thead>
                <tr>
                   <th>Nombre de reporte</th>
                   <th>Descripcion</th>
                   <th>Intervalo de tiempo</th>
                   <th></th>
                   <th>parametro a especificar</th>
                  
                   <th>Generar reporte</th>
                   
                </tr>
            </thead>
            <tr>
                    <td>
                         <input type="text" required name="nombre" placeholder="nombre de archivo" id="">
            
                    </td>
                </tr>
           <tr>
               <td>
                   <h2>Reporte de medicamentos</h2>
               </td>
               <td>
                   <h2>
                       Por cada medicamento, se muestra la  cantidad, precio, etc.
                       los medicamentos son del mes presente
                   </h2>
               </td>
               <td>
                   <h2>
                       <% out.print(año+"-"+mes+"-"+"-"+dia); %>
                   </h2>
               </td>
               <td></td>
                 <td>
                     <textarea name="parametro1" style="color: white;" placeholder="texto de filtro" id="" cols="20" rows="10"></textarea>
                 </td> 
             
                 <td>
                     <input type="submit" value="Generar reporte 1" name="codreporte">
                 </td>
               </tr>

               <tr>
                <td>
                    <h2>Reporte de ganancia de medicamentos</h2>
                </td>
                <td>
                    <h2>
                        Por cada medicamento, se lista los ingresos costo y ganancia generadas
                    </h2>
                </td>
                <td>
                    <h2>
                        <input type="date" name="fecha1"  <%out.print("value='"+año+"-"+mes+"-"+dia+"'"); %> >
                    </h2>
                </td>
                <td>
                    <h2>
                        <input type="date" name="fecha2"  <%out.print("value='"+año+"-"+mes+"-"+dia+"'"); %> >
                    </h2>
                </td>
                  <td>
                      <textarea name="parametro2" style="color: white;" placeholder="texto de filtro" id="" cols="20" rows="10"></textarea>
                  </td> 
 
                  <td>
                      <input type="submit" value="Generar reporte 2" name="codreporte">
                  </td>
                </tr>


                <tr>
                    <td>
                        <h2>Reporte de ventas por empleado</h2>
                    </td>
                    <td>
                        <h2>
                            Reporte de medicamentos vendidos describiendo ademas el empleado que lo vendio
                        </h2>
                    </td>
                    <td>
                        <h2>
                                <% out.print(año+"-"+mes+"-"+"-"+dia); %>
                        </h2>
                    </td>
                    <td></td>
                      <td>
                          <textarea name="parametro3" style="color: white;" placeholder="texto de filtro" id="" cols="20" rows="10"></textarea>
                      </td> 
     
                      <td>
                          <input type="submit" value="Generar reporte 3" name="codreporte">
                      </td>
                    </tr>

        </table>
        </form>
       </div>
    </body>
</html>