/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jhonny
 */
public class empleado extends usuario {
    private int id;
    private final String Nombre;
    private final String Direccion;
    private final String NombreEmpleo;
    private final int cui;
    private final int telefono;
    private final int horas;
     private final int sueldo; 

    public empleado(int cui, String contraseña) {
        super(cui, contraseña);
        this.Nombre="";
        this.Direccion="";
        this.NombreEmpleo="";
        this.cui=cui;
        this.telefono=0;
        this.horas=0;
        this.sueldo=0;
    }

    @Override
    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getNombreEmpleo() {
        return NombreEmpleo;
    }

    public int getCui() {
        return cui;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getHoras() {
        return horas;
    }
    
    
    
   public empleado(HttpServletRequest request,HttpServletRequest request2) {
        super(request);
        this.Direccion=request2.getParameter("direccion");
       this.Nombre=request2.getParameter("nombre");
       this.NombreEmpleo=request2.getParameter("empleo");
       this.cui=Integer.parseInt(request2.getParameter("cui"));
       this.telefono=Integer.parseInt(request2.getParameter("telefono"));
       this.horas=Integer.parseInt(request2.getParameter("horas"));
        this.sueldo=Integer.parseInt(request2.getParameter("sueldo"));
    }
   
    public int getSueldo() {
        return sueldo;
    }
    
    
        public boolean  iniciarSesion(usuario tmp){
        boolean validar=true;  
    String sql="SELECT * FROM usuarioEmpleado WHERE cui=? && contraseña=?";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setInt(1, tmp.getCui());
            crearusuario.setString(2, tmp.getContraseña());
            crearusuario.execute();
        } catch (SQLException ex) {
            validar=false;
         
        }
    
    return validar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
        
           public boolean  crearUsuario(empleado tmp){
    boolean validar=true;  
    String sql="INSERT INTO usuarioEmpleado (cui, contraseña,idcontratoEmpleado) VALUES (?,?,?)";
    PreparedStatement crearusuario=null; 
        try {
            crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
            crearusuario.setInt(1, tmp.getCui());
            crearusuario.setString(2, tmp.getContraseña());
            crearusuario.setInt(3, tmp.getId());
            crearusuario.executeUpdate();
        } catch (SQLException ex) {
            validar=false;
    
        }
    
    return validar;
    }
               public static LinkedList empleos(){
    LinkedList <String> tmp=new LinkedList();
    String sql="SELECT nombreEmpleo FROM crearEmpleo ";
    PreparedStatement crearusuario=null; 
    if(iniciarconeccion.coneccion==null){
    iniciarconeccion.IniciarConeccion();
    }
        try {
          crearusuario=iniciarconeccion.coneccion.prepareStatement(sql);
          
          ResultSet res=crearusuario.executeQuery();
          while(res.next()){
         tmp.add(res.getString("nombreEmpleo"));
          }
        } catch (SQLException ex) {
          
        }
    
    return tmp;}
    
}
