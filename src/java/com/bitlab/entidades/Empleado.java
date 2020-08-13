/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "BIT_EMPLEADO", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpIdPk", query = "SELECT e FROM Empleado e WHERE e.empIdPk = :empIdPk")
    , @NamedQuery(name = "Empleado.findByEmpNombres", query = "SELECT e FROM Empleado e WHERE e.empNombres = :empNombres")
    , @NamedQuery(name = "Empleado.findByEmpApellidos", query = "SELECT e FROM Empleado e WHERE e.empApellidos = :empApellidos")
    , @NamedQuery(name = "Empleado.findByEmpGenero", query = "SELECT e FROM Empleado e WHERE e.empGenero = :empGenero")
    , @NamedQuery(name = "Empleado.findByEmpDocumento", query = "SELECT e FROM Empleado e WHERE e.empDocumento = :empDocumento")
    , @NamedQuery(name = "Empleado.findByEmpFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.empFechaNacimiento = :empFechaNacimiento")
    , @NamedQuery(name = "Empleado.findByEmpCorreo", query = "SELECT e FROM Empleado e WHERE e.empCorreo = :empCorreo")
    , @NamedQuery(name = "Empleado.findByEmpDireccion", query = "SELECT e FROM Empleado e WHERE e.empDireccion = :empDireccion")
    , @NamedQuery(name = "Empleado.findByEmpTelefono", query = "SELECT e FROM Empleado e WHERE e.empTelefono = :empTelefono")
    , @NamedQuery(name = "Empleado.findByEmpNif", query = "SELECT e FROM Empleado e WHERE e.empNif = :empNif")
    , @NamedQuery(name = "Empleado.findByEmpComision", query = "SELECT e FROM Empleado e WHERE e.empComision = :empComision")
    , @NamedQuery(name = "Empleado.findByEmpProfesion", query = "SELECT e FROM Empleado e WHERE e.empProfesion = :empProfesion")
    , @NamedQuery(name = "Empleado.findByEmpEstado", query = "SELECT e FROM Empleado e WHERE e.empEstado = :empEstado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMP_ID_PK", nullable = false)
    private Integer empIdPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMP_NOMBRES", nullable = false, length = 50)
    private String empNombres;
    @Size(max = 50)
    @Column(name = "EMP_APELLIDOS", length = 50)
    private String empApellidos;
    @Column(name = "EMP_GENERO")
    private Character empGenero;
    @Size(max = 10)
    @Column(name = "EMP_DOCUMENTO", length = 10)
    private String empDocumento;
    @Column(name = "EMP_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date empFechaNacimiento;
    @Size(max = 50)
    @Column(name = "EMP_CORREO", length = 50)
    private String empCorreo;
    @Size(max = 100)
    @Column(name = "EMP_DIRECCION", length = 100)
    private String empDireccion;
    @Size(max = 15)
    @Column(name = "EMP_TELEFONO", length = 15)
    private String empTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NIF", nullable = false, length = 20)
    private String empNif;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EMP_COMISION", precision = 10, scale = 2)
    private BigDecimal empComision;
    @Size(max = 50)
    @Column(name = "EMP_PROFESION", length = 50)
    private String empProfesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ESTADO", nullable = false)
    private boolean empEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empIdFk", fetch = FetchType.EAGER)
    private Set<Contrato> contratoList;
    @JoinColumn(name = "ROL_ID_FK", referencedColumnName = "ROL_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolIdFk;
    @JoinColumn(name = "DEPT_ID_FK", referencedColumnName = "DEPT_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Departamento deptIdFk;

    public Empleado() {
    }

    public Empleado(Integer empIdPk) {
        this.empIdPk = empIdPk;
    }

    public Empleado(Integer empIdPk, String empNombres, String empNif, boolean empEstado) {
        this.empIdPk = empIdPk;
        this.empNombres = empNombres;
        this.empNif = empNif;
        this.empEstado = empEstado;
    }

    public Integer getEmpIdPk() {
        return empIdPk;
    }

    public void setEmpIdPk(Integer empIdPk) {
        this.empIdPk = empIdPk;
    }

    public String getEmpNombres() {
        return empNombres;
    }

    public void setEmpNombres(String empNombres) {
        this.empNombres = empNombres;
    }

    public String getEmpApellidos() {
        return empApellidos;
    }

    public void setEmpApellidos(String empApellidos) {
        this.empApellidos = empApellidos;
    }

    public Character getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(Character empGenero) {
        this.empGenero = empGenero;
    }

    public String getEmpDocumento() {
        return empDocumento;
    }

    public void setEmpDocumento(String empDocumento) {
        this.empDocumento = empDocumento;
    }

    public Date getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(Date empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpCorreo() {
        return empCorreo;
    }

    public void setEmpCorreo(String empCorreo) {
        this.empCorreo = empCorreo;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpNif() {
        return empNif;
    }

    public void setEmpNif(String empNif) {
        this.empNif = empNif;
    }

    public BigDecimal getEmpComision() {
        return empComision;
    }

    public void setEmpComision(BigDecimal empComision) {
        this.empComision = empComision;
    }

    public String getEmpProfesion() {
        return empProfesion;
    }

    public void setEmpProfesion(String empProfesion) {
        this.empProfesion = empProfesion;
    }

    public boolean getEmpEstado() {
        return empEstado;
    }

    public void setEmpEstado(boolean empEstado) {
        this.empEstado = empEstado;
    }

    public Set<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(Set<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Rol getRolIdFk() {
        return rolIdFk;
    }

    public void setRolIdFk(Rol rolIdFk) {
        this.rolIdFk = rolIdFk;
    }

    public Departamento getDeptIdFk() {
        return deptIdFk;
    }

    public void setDeptIdFk(Departamento deptIdFk) {
        this.deptIdFk = deptIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empIdPk != null ? empIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empIdPk == null && other.empIdPk != null) || (this.empIdPk != null && !this.empIdPk.equals(other.empIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Empleado[ empIdPk=" + empIdPk + " ]";
    }
    
}
