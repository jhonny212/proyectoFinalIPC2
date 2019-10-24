/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetescompartidos;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jhonny
 */
public class usuario {
    private final String usuario;
    private final String contraseña;
    private final String nombre;
    public String error;
    private final int cui;

    public int getCui() {
        return cui;
    }
    public String getContraseña() {
        return contraseña;
    }
  private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public usuario(HttpServletRequest request){
        this.usuario=request.getParameter("usuario");
         this.contraseña=request.getParameter("contra");
          this.nombre=request.getParameter("nombre");
          this.cui=0;
    }
    public usuario(int cui, String contraseña)
    {
        usuario="";
        this.contraseña=contraseña;
        this.cui=cui;
        this.nombre="";
    }
    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public boolean  iniciarSesion(usuario tmp){
    boolean valid=false;    
    
    return valid;}
    
     public boolean  crearUsuario(usuario tmp){
    boolean valid=false;    
    
    return valid;}
    
     public String getError(){
     String tmp="";
     return tmp;}
}

