<%-- 
    Document   : reportes
    Created on : 17/11/2019, 11:39:53 PM
    Author     : jhonny
--%>


<%@page import="java.util.Calendar"%>
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
        <form class="fc1" style="width: 1200px;" action="/HospitalProject/encargado" method="GET" autocomplete="off">
            <%
                   Calendar fechas=Calendar.getInstance();
                   int años=fechas.get(Calendar.YEAR);
                   int mess=fechas.get(Calendar.MONTH)+1;
                   int dias=fechas.get(Calendar.DAY_OF_MONTH);
                 
                   %>
            <input type="text" name="ids" value="9" style="opacity: 0; height: 0; width: 0;">
          
            <table class="c1" style="width: 1200px; ">
            <thead>
                <tr>
                   <th>Nombre de reporte</th>
                   
                   <th>Descripcion</th>
                   <th>intervalo</th>
                   <th>Texto de filtro</th>
                   <th>Generar reporte</th>
                   
                </tr>
            </thead>
            <tr>
                    <td>
                         <input type="text" required name="nombre" placeholder="nombre de archivo" id="">
            
                    </td>
                    
                   
                       <td>
                <input type="date"  name="fecha1"  <%out.print("value='"+años+"-"+mess+"-"+dias+"'"); %> >
            
            </td>
            
            <td>
                <input type="date" name="fecha2"  <%out.print("value='"+años+"-"+mess+"-"+dias+"'"); %> >
            
            </td>
            <td>
                <textarea name="area" placeholder="Area de trabajo" id="" cols="30" rows="10"></textarea>
            </td>
                 
                </tr>
           <tr>
               <td>
                   <h2>Reporte de empleados</h2>
               </td>
               <td>
                   <h2>
                    Este reporte consiste de un listado
                    de empleados, incluyendo información pertinente <br> (nombre, salario, etc)
                   </h2>
               </td>
           
               <td></td>
               <td></td>  
               <td>
                     <input type="submit" value="Generar reporte 1" name="codreporte">
                 </td>
               </tr>

               <tr>
                <td>
                    <h2>Reporte de empleados retirados</h2>
                </td>
                <td>
                    <h2>
                           Este reporte consiste de un listado de
                            empleados, incluyendo información pertinente (nombre, salario, etc), <br> que fueron despedidos o
                que renunciaron
                    </h2>
                </td>
            
                  <td></td>
              <td></td>
                  <td>
                      <input type="submit" value="Generar reporte 2" name="codreporte">
                  </td>
                </tr>
                <tr>
                    <td>
                        <h2>Reporte de médicos</h2>
                    </td>
                    <td>
                        <h2>
                            Este reporte consiste de un listado de médicos, incluyendo información<br>
pertinente (nombre, salario, etc) que trabajan en la institución
                        </h2>
                    </td>
                
                      <td></td>
                  <td></td>
                      <td>
                          <input type="submit" value="Generar reporte 3" name="codreporte">
                      </td>
                    </tr>

              

        </table>
        </form>
       </div>
    </body>
</html>
