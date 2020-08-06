/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.ContratoControlador;
import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.entidades.Contrato;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author henry
 */
@Named(value = "contratoManejador")
@SessionScoped
public class ContratoManejador extends ManejadorAbstracto<Contrato> implements Serializable{
    private ContratoControlador contratoControlador;
//    private List<Contrato> listaContrato;
    /**
     * Creates a new instance of ContratoManejador
     */
    public ContratoManejador() {
        super(Contrato.class);
        contratoControlador = new ContratoControlador();
//        listaContrato = contratoControlador.encontrarEntidades();
    }

    @Override
    public FabricaControladorAbstracto<Contrato> obtenerControlador() {
        return contratoControlador;
    }

    public ContratoControlador getContratoControlador() {
        return contratoControlador;
    }

    public void setContratoControlador(ContratoControlador contratoControlador) {
        this.contratoControlador = contratoControlador;
    }

//    public List<Contrato> getListaContrato() {
//        return listaContrato;
//    }
//
//    public void setListaContrato(List<Contrato> listaContrato) {
//        this.listaContrato = listaContrato;
//    }
    
    
    
}
