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
import com.bitlab.utilidades.Utilidades;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author henry
 */
@ManagedBean
@ViewScoped
public class EmpleadoManejador extends ManejadorAbstracto<Empleado> {

    private EmpleadoControlador empleadoControlado;
    private RolControlador rolControlador;
    private DepartamentoControlador deptControlador;
    private Rol rol;
    private Departamento departamento;
    private List<Rol> rolLista;
    private List<Departamento> departamentoLista;
    private List<Empleado> listaEmpleados;
    private boolean selectEstado;
    private String numeroEmpleados;
    private String numeroEmpleadosInactivos;
    private int inactivos;

    public EmpleadoManejador() {
        super(Empleado.class);
        empleadoControlado = new EmpleadoControlador();
        rolControlador = new RolControlador();
        deptControlador = new DepartamentoControlador();
        rolLista = rolControlador.encontrarEntidades();
        departamentoLista = deptControlador.encontrarEntidades();
        listaEmpleados = empleadoControlado.encontrarEmpleadoEstado(true);
        numeroEmpleados = String.valueOf(listaEmpleados.size());
    }

    public String getNumeroEmpleadosInactivos() {
        return numeroEmpleadosInactivos;
    }

    public void setNumeroEmpleadosInactivos(String numeroEmpleadosInactivos) {
        this.numeroEmpleadosInactivos = numeroEmpleadosInactivos;
    }
    

    public String getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(String numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    
    public void cambiarEstado(Empleado empleado) {
        setEntidadSeleccionada(empleado);
        this.selectEstado = getEntidadSeleccionada().getEmpEstado();
        getEntidadSeleccionada().setEmpEstado(selectEstado);
        super.guardarEntidad();
        String estado = this.getEntidadSeleccionada().getEmpEstado() ? "true" : "false";
        Utilidades.lanzarMensajeInfo("Estado cambiado ", "Estado cambiado a " +estado);
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

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public boolean isSelectEstado() {
        return selectEstado;
    }

    public void setSelectEstado(boolean selectEstado) {
        this.selectEstado = selectEstado;
    }

    

}
