/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
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
@Table(name = "BIT_ROL", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByRolIdPk", query = "SELECT r FROM Rol r WHERE r.rolIdPk = :rolIdPk")
    , @NamedQuery(name = "Rol.findByRolNombrerol", query = "SELECT r FROM Rol r WHERE r.rolNombrerol = :rolNombrerol")
    , @NamedQuery(name = "Rol.findByRolDescripcion", query = "SELECT r FROM Rol r WHERE r.rolDescripcion = :rolDescripcion")
    , @NamedQuery(name = "Rol.findByRolEstatus", query = "SELECT r FROM Rol r WHERE r.rolEstatus = :rolEstatus")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROL_ID_PK", nullable = false)
    private Integer rolIdPk;
    @Size(max = 50)
    @Column(name = "ROL_NOMBREROL", length = 50)
    private String rolNombrerol;
    @Size(max = 150)
    @Column(name = "ROL_DESCRIPCION", length = 150)
    private String rolDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ESTATUS", nullable = false)
    private boolean rolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdFk", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdFk", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    public Rol() {
    }

    public Rol(Integer rolIdPk) {
        this.rolIdPk = rolIdPk;
    }

    public Rol(Integer rolIdPk, boolean rolEstatus) {
        this.rolIdPk = rolIdPk;
        this.rolEstatus = rolEstatus;
    }

    public Integer getRolIdPk() {
        return rolIdPk;
    }

    public void setRolIdPk(Integer rolIdPk) {
        this.rolIdPk = rolIdPk;
    }

    public String getRolNombrerol() {
        return rolNombrerol;
    }

    public void setRolNombrerol(String rolNombrerol) {
        this.rolNombrerol = rolNombrerol;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public boolean getRolEstatus() {
        return rolEstatus;
    }

    public void setRolEstatus(boolean rolEstatus) {
        this.rolEstatus = rolEstatus;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (rolIdPk != null ? rolIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolIdPk == null && other.rolIdPk != null) || (this.rolIdPk != null && !this.rolIdPk.equals(other.rolIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Rol[ rolIdPk=" + rolIdPk + " ]";
    }
    
}
