/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controladores;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aguilar
 */
public class UsuarioControlador extends FabricaControladorAbstracto<Usuario>{

    public UsuarioControlador() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return FabricaConexion.getInstancia().getManejadorEntidades().createEntityManager();
    }
    
    //encontrar una entidad por Usuario
    public Usuario encontrarPorUsuario(String usuario, String pass) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        Usuario us;
        
        try {
            Query query = em.createQuery("SELECT u from Usuario u WHERE u.usuNombre = :usuNombre AND u.usuContrasena = :usuContrasena");
            query.setParameter("usuNombre", usuario);
            query.setParameter("usuContrasena", pass);
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                us = lista.get(0);
                return us;
            }
        } catch (Exception e) {
            //posible error en la busqueda
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return null;
    }
}
