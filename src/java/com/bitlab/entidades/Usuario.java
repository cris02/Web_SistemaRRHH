/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "BIT_USUARIO", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuIdPk", query = "SELECT u FROM Usuario u WHERE u.usuIdPk = :usuIdPk")
    , @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre")
    , @NamedQuery(name = "Usuario.findByUsuCorreo", query = "SELECT u FROM Usuario u WHERE u.usuCorreo = :usuCorreo")
    , @NamedQuery(name = "Usuario.findByUsuContrasena", query = "SELECT u FROM Usuario u WHERE u.usuContrasena = :usuContrasena")
    , @NamedQuery(name = "Usuario.findByUsuEstatus", query = "SELECT u FROM Usuario u WHERE u.usuEstatus = :usuEstatus")
    , @NamedQuery(name = "Usuario.findByUsuFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaCreacion = :usuFechaCreacion")
    , @NamedQuery(name = "Usuario.findByUsuFechaConexion", query = "SELECT u FROM Usuario u WHERE u.usuFechaConexion = :usuFechaConexion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ID_PK", nullable = false)
    private Integer usuIdPk;
    @Size(max = 20)
    @Column(name = "USU_NOMBRE", length = 20)
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_CORREO", nullable = false, length = 50)
    private String usuCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_CONTRASENA", nullable = false, length = 30)
    private String usuContrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ESTATUS", nullable = false)
    private boolean usuEstatus;
    @Column(name = "USU_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date usuFechaCreacion;
    @Column(name = "USU_FECHA_CONEXION")
    @Temporal(TemporalType.DATE)
    private Date usuFechaConexion;
    @JoinColumn(name = "ROL_ID_FK", referencedColumnName = "ROL_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolIdFk;

    public Usuario() {
    }

    public Usuario(Integer usuIdPk) {
        this.usuIdPk = usuIdPk;
    }

    public Usuario(Integer usuIdPk, String usuCorreo, String usuContrasena, boolean usuEstatus) {
        this.usuIdPk = usuIdPk;
        this.usuCorreo = usuCorreo;
        this.usuContrasena = usuContrasena;
        this.usuEstatus = usuEstatus;
    }

    public Integer getUsuIdPk() {
        return usuIdPk;
    }

    public void setUsuIdPk(Integer usuIdPk) {
        this.usuIdPk = usuIdPk;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public boolean getUsuEstatus() {
        return usuEstatus;
    }

    public void setUsuEstatus(boolean usuEstatus) {
        this.usuEstatus = usuEstatus;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaConexion() {
        return usuFechaConexion;
    }

    public void setUsuFechaConexion(Date usuFechaConexion) {
        this.usuFechaConexion = usuFechaConexion;
    }

    public Rol getRolIdFk() {
        return rolIdFk;
    }

    public void setRolIdFk(Rol rolIdFk) {
        this.rolIdFk = rolIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdPk != null ? usuIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuIdPk == null && other.usuIdPk != null) || (this.usuIdPk != null && !this.usuIdPk.equals(other.usuIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Usuario[ usuIdPk=" + usuIdPk + " ]";
    }
    
}
