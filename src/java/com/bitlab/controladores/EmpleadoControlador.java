/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controladores;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aguilar
 */
public class EmpleadoControlador extends FabricaControladorAbstracto<Empleado>{

    public EmpleadoControlador() {
        super(Empleado.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return FabricaConexion.getInstancia().getManejadorEntidades().createEntityManager();
    }
    
    //buscar campos por estado
    public List<Empleado> encontrarEmpleadoEstado(Boolean estado) {
        EntityManager em = obtenerManejadorEntidades();
        try {
            Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.empEstado = :estado"); //codigo en jpql
            q.setParameter("estado", estado);
            return q.getResultList();
        } finally {
           if (em.isOpen()) {
                em.close();
            }
        }
    }
    
}
