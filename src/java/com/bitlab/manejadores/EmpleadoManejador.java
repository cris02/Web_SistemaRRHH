/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.EmpleadoControlador;
import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.entidades.Empleado;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author henry
 */
@Named(value = "empleadoManejador")
@ViewScoped
public class EmpleadoManejador extends ManejadorAbstracto<Empleado>{
    private EmpleadoControlador empleadoControlado;

    public EmpleadoManejador() {
        super(Empleado.class);
        empleadoControlado = new EmpleadoControlador();
    }

    @Override
    public FabricaControladorAbstracto<Empleado> obtenerControlador() {
        return empleadoControlado;
    }
}
