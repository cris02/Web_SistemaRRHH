
package com.bitlab.manejadores;

import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.utilidades.Utilidades;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;

/**
 *
 * @author henry
 */
public abstract class ManejadorAbstracto<T>{
    private T entidadSeleccionada;
    private List<T> entidadLista;
    private final Class<T> claseEntidad;
    
    public ManejadorAbstracto(Class<T> entidad){
        claseEntidad = entidad;
    }
    
    @PostConstruct
    public void cargarInformacion(){
        entidadLista = obtenerControlador().encontrarEntidades();
    }
    
    @PreDestroy
    public void destruir(){
        entidadLista = null;
        entidadSeleccionada = null;
    }
    
    public void nuevaEntidad(){
        try {
            entidadSeleccionada = claseEntidad.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarEntidad(){
        try {
            System.out.println("Ingresando a guardar " +claseEntidad.getSimpleName());
            obtenerControlador().editar(entidadSeleccionada);
            cargarInformacion();
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", claseEntidad.getSimpleName() +" ha sido guardado...");
        } catch (Exception ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEntidad(){
        try {
            System.out.println("Ingresando a eliminar " +claseEntidad.getSimpleName());
            obtenerControlador().destruir(entidadSeleccionada);
            cargarInformacion();
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", claseEntidad.getSimpleName() +" ha sido guardado...");
        } catch (Exception ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    public void setEntidadSeleccionada(T entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    public List<T> getEntidadLista() {
        return entidadLista;
    }

    public void setEntidadLista(List<T> entidadLista) {
        this.entidadLista = entidadLista;
    }
    
    
    public abstract FabricaControladorAbstracto<T> obtenerControlador();
}
