/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.DetalleplanillaControlador;
import com.bitlab.entidades.Detalleplanilla;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author henry
 */
@Named(value = "detallePlanillaManejador")
@SessionScoped
public class DetallePlanillaManejador extends ManejadorAbstracto<Detalleplanilla> implements Serializable{
//instanciar el controlador
    private DetalleplanillaControlador detPlaControlador;
    private List<Detalleplanilla> listaPlanilla;
    private DetalleplanillaControlador detallePlaControlador;
    /**
     * Creates a new instance of DetallePlanillaManejador
     */
    public DetallePlanillaManejador() {
        super(Detalleplanilla.class);
        detPlaControlador =  new DetalleplanillaControlador();
        detallePlaControlador = new DetalleplanillaControlador();
        listaPlanilla = detallePlaControlador.encontrarEntidades();
    }
    
    

    @Override
    public DetalleplanillaControlador obtenerControlador() {
        return detPlaControlador;
    }

    public DetalleplanillaControlador getDetPlaControlador() {
        return detPlaControlador;
    }

    public void setDetPlaControlador(DetalleplanillaControlador detPlaControlador) {
        this.detPlaControlador = detPlaControlador;
    }

    public List<Detalleplanilla> getListaPlanilla() {
        return listaPlanilla;
    }

    public void setListaPlanilla(List<Detalleplanilla> listaPlanilla) {
        this.listaPlanilla = listaPlanilla;
    }

    public DetalleplanillaControlador getDetallePlaControlador() {
        return detallePlaControlador;
    }

    public void setDetallePlaControlador(DetalleplanillaControlador detallePlaControlador) {
        this.detallePlaControlador = detallePlaControlador;
    }
    
    
}
