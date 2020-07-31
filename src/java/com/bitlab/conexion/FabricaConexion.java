/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aguilar
 */
public class FabricaConexion {
     private static final FabricaConexion connectionFactory = new FabricaConexion(); //aplicando la instancia privada con el patron singleton
    private EntityManagerFactory emf; //creando la fabrica de manejador de entidades

    //aplicando el patron singleton

    private FabricaConexion() {
        emf = Persistence.createEntityManagerFactory("Web_SistemaRRHHPU"); // creando el contexto de la fabrica 
    }

    //retornando la instancia de la conexion
    public static FabricaConexion getInstancia() {
        return connectionFactory;
    }

    public  EntityManagerFactory getManejadorEntidades() {
        return emf;
    }
}
