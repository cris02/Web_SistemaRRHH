/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.controladores.RolControlador;
import com.bitlab.entidades.Rol;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Aguilar
 */

@ManagedBean
@ViewScoped

public class RolManejador extends ManejadorAbstracto<Rol>{

    private RolControlador rolControlador;
    
    public RolManejador() {
        super(Rol.class);
        rolControlador = new RolControlador();
    }

    @Override
    public RolControlador obtenerControlador() {
        return rolControlador;
    }
    
}
