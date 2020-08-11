/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.ContratoControlador;
import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.entidades.Contrato;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author henry
 */
@ManagedBean
@ViewScoped
public class ContratoManejador extends ManejadorAbstracto<Contrato>{
    private ContratoControlador contratoControlador;

    /**
     * Creates a new instance of ContratoManejador
     */
    public ContratoManejador() {
        super(Contrato.class);
        contratoControlador = new ContratoControlador();
    }

    @Override
    public FabricaControladorAbstracto<Contrato> obtenerControlador() {
        return contratoControlador;
    }
    
}
