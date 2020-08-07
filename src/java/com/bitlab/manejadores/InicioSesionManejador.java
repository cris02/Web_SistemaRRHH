/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.UsuarioControlador;
import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.Utilidades;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

/**
 *
 * @author henry
 */
@Named(value = "inicioSesionManejador")
@SessionScoped
public class InicioSesionManejador implements Serializable {
    private Usuario usuario;
    private UsuarioControlador usuarioControlador; //Mejor dejar la clase como UsuarioControlador
    private Usuario us;

    /**
     * Creates a new instance of InicioSesionManejador
     */
    public InicioSesionManejador() {
        usuario = new Usuario();
        us = new Usuario();
        usuarioControlador = new UsuarioControlador();
    }
    
    public void iniciarSesion(){
        try {
            us = usuarioControlador.encontrarPorUsuario(usuario.getUsuNombre(), usuario.getUsuContrasena());
            if(us != null){
                if(usuario.getUsuNombre().equals(us.getUsuNombre()) && usuario.getUsuContrasena().equals(us.getUsuContrasena())){
                System.out.println("Bienvenido " + us.getUsuNombre() + " usted es un usuario de tipo " + us.getRolIdFk().getRolNombrerol());
                if(us.getRolIdFk().getRolNombrerol().equals("RRHH")){
                    Utilidades.redireccionar("rrhh");
                }else if(us.getRolIdFk().getRolNombrerol().equals("ADMINISTRADOR SISTEMA")){
                    Utilidades.redireccionar("admin");
                }
                us.setUsuFechaConexion(new Date());
                    System.out.println("Fecha de sesion " + us.getUsuFechaConexion());
            }
            }else{
                Utilidades.lanzarMensaje(FacesMessage.SEVERITY_ERROR, "Usuario invalido", "Usuario o contrasena son invalidos");
                Utilidades.redireccionar("index");
            }
        } catch (Exception ex) {
            Logger.getLogger(InicioSesionManejador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioControlador getUsuarioControlador() {
        return usuarioControlador;
    }

    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    
    
}
