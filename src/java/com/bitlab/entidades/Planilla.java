/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "BIT_PLANILLA", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p")
    , @NamedQuery(name = "Planilla.findByPlaIdPk", query = "SELECT p FROM Planilla p WHERE p.plaIdPk = :plaIdPk")
    , @NamedQuery(name = "Planilla.findByPlaNombre", query = "SELECT p FROM Planilla p WHERE p.plaNombre = :plaNombre")
    , @NamedQuery(name = "Planilla.findByPlaObservacion", query = "SELECT p FROM Planilla p WHERE p.plaObservacion = :plaObservacion")
    , @NamedQuery(name = "Planilla.findByPlaFechaInicio", query = "SELECT p FROM Planilla p WHERE p.plaFechaInicio = :plaFechaInicio")
    , @NamedQuery(name = "Planilla.findByPlaFechaFin", query = "SELECT p FROM Planilla p WHERE p.plaFechaFin = :plaFechaFin")
    , @NamedQuery(name = "Planilla.findByPlaResponsable", query = "SELECT p FROM Planilla p WHERE p.plaResponsable = :plaResponsable")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLA_ID_PK", nullable = false)
    private Integer plaIdPk;
    @Size(max = 50)
    @Column(name = "PLA_NOMBRE", length = 50)
    private String plaNombre;
    @Size(max = 200)
    @Column(name = "PLA_OBSERVACION", length = 200)
    private String plaObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLA_FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLA_FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaFin;
    @Size(max = 50)
    @Column(name = "PLA_RESPONSABLE", length = 50)
    private String plaResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaIdFk", fetch = FetchType.EAGER)
    private List<Detalleplanilla> detalleplanillaList;

    public Planilla() {
    }

    public Planilla(Integer plaIdPk) {
        this.plaIdPk = plaIdPk;
    }

    public Planilla(Integer plaIdPk, Date plaFechaInicio, Date plaFechaFin) {
        this.plaIdPk = plaIdPk;
        this.plaFechaInicio = plaFechaInicio;
        this.plaFechaFin = plaFechaFin;
    }

    public Integer getPlaIdPk() {
        return plaIdPk;
    }

    public void setPlaIdPk(Integer plaIdPk) {
        this.plaIdPk = plaIdPk;
    }

    public String getPlaNombre() {
        return plaNombre;
    }

    public void setPlaNombre(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    public String getPlaObservacion() {
        return plaObservacion;
    }

    public void setPlaObservacion(String plaObservacion) {
        this.plaObservacion = plaObservacion;
    }

    public Date getPlaFechaInicio() {
        return plaFechaInicio;
    }

    public void setPlaFechaInicio(Date plaFechaInicio) {
        this.plaFechaInicio = plaFechaInicio;
    }

    public Date getPlaFechaFin() {
        return plaFechaFin;
    }

    public void setPlaFechaFin(Date plaFechaFin) {
        this.plaFechaFin = plaFechaFin;
    }

    public String getPlaResponsable() {
        return plaResponsable;
    }

    public void setPlaResponsable(String plaResponsable) {
        this.plaResponsable = plaResponsable;
    }

    public List<Detalleplanilla> getDetalleplanillaList() {
        return detalleplanillaList;
    }

    public void setDetalleplanillaList(List<Detalleplanilla> detalleplanillaList) {
        this.detalleplanillaList = detalleplanillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaIdPk != null ? plaIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.plaIdPk == null && other.plaIdPk != null) || (this.plaIdPk != null && !this.plaIdPk.equals(other.plaIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Planilla[ plaIdPk=" + plaIdPk + " ]";
    }
    
}
