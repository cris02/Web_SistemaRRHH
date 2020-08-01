/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.principal;

import com.bitlab.controladores.DepartamentoControlador;
import com.bitlab.entidades.Departamento;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class Main {
    public static void main(String[] args) {
        try {
            //buscar el depto con el id 1
              DepartamentoControlador controlador = new DepartamentoControlador();
            Departamento departamento = controlador.encontrar(1);
            System.out.println(departamento.getDeptVacanteDisponible());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
