/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "BIT_DEPARTAMENTO", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByDeptIdPk", query = "SELECT d FROM Departamento d WHERE d.deptIdPk = :deptIdPk")
    , @NamedQuery(name = "Departamento.findByDeptNombre", query = "SELECT d FROM Departamento d WHERE d.deptNombre = :deptNombre")
    , @NamedQuery(name = "Departamento.findByDeptDescripcion", query = "SELECT d FROM Departamento d WHERE d.deptDescripcion = :deptDescripcion")
    , @NamedQuery(name = "Departamento.findByDeptPresupuesto", query = "SELECT d FROM Departamento d WHERE d.deptPresupuesto = :deptPresupuesto")
    , @NamedQuery(name = "Departamento.findByDeptVacantesRequeridas", query = "SELECT d FROM Departamento d WHERE d.deptVacantesRequeridas = :deptVacantesRequeridas")
    , @NamedQuery(name = "Departamento.findByDeptVacanteDisponible", query = "SELECT d FROM Departamento d WHERE d.deptVacanteDisponible = :deptVacanteDisponible")
    , @NamedQuery(name = "Departamento.findByDeptEstado", query = "SELECT d FROM Departamento d WHERE d.deptEstado = :deptEstado")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEPT_ID_PK", nullable = false)
    private Integer deptIdPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEPT_NOMBRE", nullable = false, length = 50)
    private String deptNombre;
    @Size(max = 100)
    @Column(name = "DEPT_DESCRIPCION", length = 100)
    private String deptDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPT_PRESUPUESTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal deptPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPT_VACANTES_REQUERIDAS", nullable = false)
    private short deptVacantesRequeridas;
    @Column(name = "DEPT_VACANTE_DISPONIBLE")
    private Short deptVacanteDisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPT_ESTADO", nullable = false)
    private boolean deptEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptIdFk", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    public Departamento() {
    }

    public Departamento(Integer deptIdPk) {
        this.deptIdPk = deptIdPk;
    }

    public Departamento(Integer deptIdPk, String deptNombre, BigDecimal deptPresupuesto, short deptVacantesRequeridas, boolean deptEstado) {
        this.deptIdPk = deptIdPk;
        this.deptNombre = deptNombre;
        this.deptPresupuesto = deptPresupuesto;
        this.deptVacantesRequeridas = deptVacantesRequeridas;
        this.deptEstado = deptEstado;
    }

    public Integer getDeptIdPk() {
        return deptIdPk;
    }

    public void setDeptIdPk(Integer deptIdPk) {
        this.deptIdPk = deptIdPk;
    }

    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        this.deptNombre = deptNombre;
    }

    public String getDeptDescripcion() {
        return deptDescripcion;
    }

    public void setDeptDescripcion(String deptDescripcion) {
        this.deptDescripcion = deptDescripcion;
    }

    public BigDecimal getDeptPresupuesto() {
        return deptPresupuesto;
    }

    public void setDeptPresupuesto(BigDecimal deptPresupuesto) {
        this.deptPresupuesto = deptPresupuesto;
    }

    public short getDeptVacantesRequeridas() {
        return deptVacantesRequeridas;
    }

    public void setDeptVacantesRequeridas(short deptVacantesRequeridas) {
        this.deptVacantesRequeridas = deptVacantesRequeridas;
    }

    public Short getDeptVacanteDisponible() {
        return deptVacanteDisponible;
    }

    public void setDeptVacanteDisponible(Short deptVacanteDisponible) {
        this.deptVacanteDisponible = deptVacanteDisponible;
    }

    public boolean getDeptEstado() {
        return deptEstado;
    }

    public void setDeptEstado(boolean deptEstado) {
        this.deptEstado = deptEstado;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptIdPk != null ? deptIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.deptIdPk == null && other.deptIdPk != null) || (this.deptIdPk != null && !this.deptIdPk.equals(other.deptIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Departamento[ deptIdPk=" + deptIdPk + " ]";
    }
    
}
