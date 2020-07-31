/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controladores;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Planilla;
import javax.persistence.EntityManager;

/**
 *
 * @author Aguilar
 */
public class PlanillaControlador extends FabricaControladorAbstracto<Planilla>{

    public PlanillaControlador() {
        super(Planilla.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return FabricaConexion.getInstancia().getManejadorEntidades().createEntityManager();
    }
    
}
