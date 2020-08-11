/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.RolControlador;
import com.bitlab.controladores.UsuarioControlador;
import com.bitlab.entidades.Rol;
import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.EncriptacionTexto;
import com.bitlab.utilidades.Utilidades;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Aguilar
 */
@ManagedBean
@ViewScoped
public class UsuarioManejador extends ManejadorAbstracto<Usuario> {

    private UsuarioControlador usuarioControlador;
    private RolControlador rolControlador;
    private Rol rol;
    private List<Rol> rolLista;
    private List<Usuario> listUsuarios;
    private String pass; // modelo pivote para comprobar las contrasenas
    private boolean selectEstado; //modelo pivite para comprobar el estado
    private Usuario usuario; //variable pivote

    public UsuarioManejador() {
        super(Usuario.class);
        usuarioControlador = new UsuarioControlador();
        rolControlador = new RolControlador();
        rolLista = rolControlador.encontrarEntidades();
        listUsuarios = usuarioControlador.encontrarEntidades();
    }

    //metodo re-estructurado para guardar o modificar un suario
    @Override
    public void guardarEntidad() {
        rol = getEntidadSeleccionada().getRolIdFk();
        getEntidadSeleccionada().setRolIdFk(rol); // cuando el rol viene del formulario

        System.out.println("id de la entidad: " + getEntidadSeleccionada().getUsuIdPk());
        if (getEntidadSeleccionada().getUsuIdPk() != null) {
            //la entidad ya existe: actualiza los datos
            try {
                usuario = usuarioControlador.encontrar(getEntidadSeleccionada().getUsuIdPk());
                pass = usuario.getUsuContrasena();

            } catch (Exception ex) {
                Logger.getLogger(UsuarioManejador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //es una nueva entidad: se asigna propiedades a la nueva entidad
            pass = "";
            getEntidadSeleccionada().setUsuEstatus(true);
            getEntidadSeleccionada().setUsuFechaCreacion(new Date());
            getEntidadSeleccionada().setUsuFechaConexion(new Date());

        }

        String contra = getEntidadSeleccionada().getUsuContrasena(); //contrasena obtenida del formulario
        //verifica si la contrasena del input del formulario esta vacia
        if (contra.isEmpty()) {
            getEntidadSeleccionada().setUsuContrasena(pass);
        } else if (!(getEntidadSeleccionada().getUsuContrasena().equals(pass))) {
            EncriptacionTexto encriptacionTexto = new EncriptacionTexto();
            getEntidadSeleccionada().setUsuContrasena(encriptacionTexto.getTextoEncriptado(contra));
        }

        super.guardarEntidad(); //guardar la entidad

    }
    
    //metodo para obtener el controlador de la entidad
    @Override
    public UsuarioControlador obtenerControlador() {
        return usuarioControlador;
    }

    //metodo para cambiar el estado del usuario
    public void obtenerEstado(Usuario usuario) {
        setEntidadSeleccionada(usuario);
        this.selectEstado = getEntidadSeleccionada().getUsuEstatus(); // se obtiene el estado del input
        getEntidadSeleccionada().setUsuEstatus(selectEstado);
        if (getEntidadSeleccionada().getUsuEstatus() == selectEstado) {
            super.guardarEntidad();
        } else {
            Utilidades.lanzarMensajeError("Error al procesar Estado ", "Estado no modificado");
        }

    }

    //metodos getter y setter
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isSelectEstado() {
        return selectEstado;
    }

    public void setSelectEstado(boolean selectEstado) {
        this.selectEstado = selectEstado;
    }

    public RolControlador getRolControlador() {
        return rolControlador;
    }

    public void setRolControlador(RolControlador rolControlador) {
        this.rolControlador = rolControlador;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRolLista() {
        return rolLista;
    }

    public void setRolLista(List<Rol> rolLista) {
        this.rolLista = rolLista;
    }

}
