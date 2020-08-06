/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.principal;

import com.bitlab.controladores.DepartamentoControlador;
import com.bitlab.controladores.EmpleadoControlador;
import com.bitlab.entidades.Departamento;
import com.bitlab.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
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
//            DepartamentoControlador controlador = new DepartamentoControlador();
//            Departamento departamento = controlador.encontrar(1);
//            for (Empleado empleado : departamento.getEmpleadoList()) {
//                System.out.println("Nombre: " + empleado.getEmpNombres() + " Apellido: " + empleado.getEmpApellidos() + " Depto: " +
//                        empleado.getDeptIdFk().getDeptNombre());

            //obtener los empleados por estado activo
            EmpleadoControlador empleadoControlador = new EmpleadoControlador();
            List<Empleado> listEmpleado = new ArrayList<>();
            listEmpleado = empleadoControlador.encontrarEmpleadoEstado(true);
            
            for (Empleado empleado : listEmpleado) {
                System.out.println(empleado);
            }
        }

    
    catch (Exception ex

    
        ) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
