/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.DepartamentoControlador;
import com.bitlab.entidades.Departamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Aguilar
 */

@ManagedBean
@ViewScoped
public class DeptoManejador extends ManejadorAbstracto<Departamento>{
    
    private DepartamentoControlador departamentoControlador;
    private int numeroDepartamentos;

    public DeptoManejador() {
        super(Departamento.class);
        departamentoControlador = new DepartamentoControlador();
        numeroDepartamentos = departamentoControlador.encontrarEntidades().size();
    }

    @Override
    public DepartamentoControlador obtenerControlador() {
        return departamentoControlador;
    }

    public int getNumeroDepartamentos() {
        return numeroDepartamentos;
    }

    public void setNumeroDepartamentos(int numeroDepartamentos) {
        this.numeroDepartamentos = numeroDepartamentos;
    }
    
    
    
}
