<%-- 
    Document   : reportes
    Created on : 16/11/2019, 09:25:00 PM
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
        <form class="fc1" style="width: 1200px;" action="/HospitalProject/adminsesion" method="POST" autocomplete="off">
            <%
                   Calendar fecha=Calendar.getInstance();
                   int año=fecha.get(Calendar.YEAR);
                   int mes=fecha.get(Calendar.MONTH)+1;
                   int dia=fecha.get(Calendar.DAY_OF_MONTH);
                 
                   %>
            <input type="text" name="id" value="8" style="opacity: 0; height: 0; width: 0;">
          
            <table class="c1" style="width: 1200px; ">
            <thead>
                <tr>
                   <th>Nombre de reporte</th>
                   
                   <th>Descripcion</th>
                   <th>intervalo</th>
                   <th></th>
                   <th>Generar reporte</th>
                   
                </tr>
            </thead>
            <tr>
                    <td>
                         <input type="text" required name="nombre" placeholder="nombre de archivo" id="">
            
                    </td>
                    <td></td>
                    <td>
                        <input type="date" required name="fecha1"  <%out.print("value='"+año+"-"+mes+"-"+dia+"'"); %> >
                    
                    </td>
                    
                    <td>
                        <input type="date" required name="fecha2"  <%out.print("value='"+año+"-"+mes+"-"+dia+"'"); %> >
                    
                    </td>
                </tr>
           <tr>
               <td>
                   <h2>Reporte de ingresos</h2>
               </td>
               <td>
                   <h2>
                       Por cada area se muestra los ingresos producidos
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
                    <h2>Reporte de gastos</h2>
                </td>
                <td>
                    <h2>
                        Por cada area se muestra los los gastos
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
                        <h2>Reporte de ganancias</h2>
                    </td>
                    <td>
                        <h2>
                            Por cada area se muestra las ganancias
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