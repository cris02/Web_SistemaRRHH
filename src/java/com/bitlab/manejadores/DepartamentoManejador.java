/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.DepartamentoControlador;
import com.bitlab.entidades.Departamento;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Aguilar
 */

@Named(value = "departamentoManejador")
@ViewScoped
public class DepartamentoManejador extends ManejadorAbstracto<Departamento>{
    //instanciar el controlador
    private DepartamentoControlador departamentoControlador;

    public DepartamentoManejador() {
        super(Departamento.class);
        departamentoControlador =  new DepartamentoControlador();
    }

    @Override
    public DepartamentoControlador obtenerControlador() {
        return departamentoControlador;
    }
    
}
