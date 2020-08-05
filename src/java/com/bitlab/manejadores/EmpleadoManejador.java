/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.manejadores;

import com.bitlab.controladores.DepartamentoControlador;
import com.bitlab.controladores.EmpleadoControlador;
import com.bitlab.controladores.FabricaControladorAbstracto;
import com.bitlab.controladores.RolControlador;
import com.bitlab.entidades.Departamento;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Rol;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author henry
 */
@Named(value = "empleadoManejador")
@SessionScoped
public class EmpleadoManejador extends ManejadorAbstracto<Empleado> implements Serializable{
    private EmpleadoControlador empleadoControlado;
    private RolControlador rolControlador;
    private DepartamentoControlador deptControlador;
    private Rol rol;
    private Departamento departamento;
    private List<Rol> rolLista;
    private List<Departamento> departamentoLista;
    
    

    public EmpleadoManejador() {
        super(Empleado.class);
        empleadoControlado = new EmpleadoControlador();
        rolControlador = new RolControlador();
        deptControlador = new DepartamentoControlador();
        rolLista = rolControlador.encontrarEntidades();
        departamentoLista = deptControlador.encontrarEntidades();
    }

    @Override
    public void nuevaEntidad() {
        super.nuevaEntidad(); //To change body of generated methods, choose Tools | Templates.
        getEntidadSeleccionada().setEmpEstado(true);
    }
    
    

    @Override
    public FabricaControladorAbstracto<Empleado> obtenerControlador() {
        return empleadoControlado;
    }

    public EmpleadoControlador getEmpleadoControlado() {
        return empleadoControlado;
    }

    public void setEmpleadoControlado(EmpleadoControlador empleadoControlado) {
        this.empleadoControlado = empleadoControlado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public RolControlador getRolControlador() {
        return rolControlador;
    }

    public void setRolControlador(RolControlador rolControlador) {
        this.rolControlador = rolControlador;
    }

    public DepartamentoControlador getDeptControlador() {
        return deptControlador;
    }

    public void setDeptControlador(DepartamentoControlador deptControlador) {
        this.deptControlador = deptControlador;
    }

    public List<Rol> getRolLista() {
        return rolLista;
    }

    public void setRolLista(List<Rol> rolLista) {
        this.rolLista = rolLista;
    }

    public List<Departamento> getDepartamentoLista() {
        return departamentoLista;
    }

    public void setDepartamentoLista(List<Departamento> departamentoLista) {
        this.departamentoLista = departamentoLista;
    }

    
    
    
    
    
}
