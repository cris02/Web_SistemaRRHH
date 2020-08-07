/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controladores;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Departamento;
import javax.persistence.EntityManager;

/**
 *
 * @author Aguilar
 */
public class DepartamentoControlador extends FabricaControladorAbstracto<Departamento>{

    public DepartamentoControlador() {
        super(Departamento.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return FabricaConexion.getInstancia().getManejadorEntidades().createEntityManager();
    }
    
    
}
