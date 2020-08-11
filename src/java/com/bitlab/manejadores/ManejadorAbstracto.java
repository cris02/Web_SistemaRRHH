
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
    private boolean esNuevaEntidad; //variable pivote para renderizar
    private static Logger log = Logger.getLogger(ManejadorAbstracto.class.getName());
    
    //metodo que retorna la instancia de la entidad
    public ManejadorAbstracto(Class<T> entidad){
        claseEntidad = entidad;
    }
    
    @PostConstruct //metodo que se carga cuando se crea la instancia del manejador abstracto
    public void cargarInformacion(){
        entidadLista = obtenerControlador().encontrarEntidades();
    }
    
    @PreDestroy // metodo para eliminar las instancia la finalizar el ScopeView
    public void destruir(){
        entidadLista = null;
        entidadSeleccionada = null;
    }
    
    //metodo para instanciar la entidad seleccionada
    public void nuevaEntidad(){
        try {
            log.info("Ingresando una nueva entidad");
            entidadSeleccionada = claseEntidad.getDeclaredConstructor().newInstance();
            setEsNuevaEntidad(true);
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_INFO, "Exito!!", claseEntidad.getSimpleName() +" ha sido guardado...");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_ERROR, "Error!!", claseEntidad.getSimpleName() +" no ha sido guardado...");
        }
    }
    
    //metodo para actualizar la entidad
    public void guardarEntidad(){
        try {
            log.info("Ingresando a guardar - " + claseEntidad.getSimpleName()); 
            obtenerControlador().editar(entidadSeleccionada);
            
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_INFO, "Exito!!", claseEntidad.getSimpleName() +" ha sido guardado...");
            cargarInformacion();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_ERROR, "Error!!", claseEntidad.getSimpleName() +" no ha sido guardado...");
            
        }
    }
    
    //metodo para eliminar la entidad
    public void eliminarEntidad(){
        try {
            log.info("Ingresando a eliminar - " +claseEntidad.getSimpleName());
            obtenerControlador().destruir(entidadSeleccionada);
            cargarInformacion();
            Utilidades.lanzarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", claseEntidad.getSimpleName() +" ha sido eliminado...");
        } catch (Exception ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        metodos Getter y Setter
    */
    public T getEntidadSeleccionada() {
        log.info("Entidad seleccionada para operar - " + entidadSeleccionada);
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

    public boolean isEsNuevaEntidad() {
        return esNuevaEntidad;
    }

    public void setEsNuevaEntidad(boolean esNuevaEntidad) {
        this.esNuevaEntidad = esNuevaEntidad;
    }

    
    public abstract FabricaControladorAbstracto<T> obtenerControlador();
}
