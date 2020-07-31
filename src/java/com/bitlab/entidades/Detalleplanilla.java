/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "BIT_DETALLEPLANILLA", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Detalleplanilla.findAll", query = "SELECT d FROM Detalleplanilla d")
    , @NamedQuery(name = "Detalleplanilla.findByDplaIdPk", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaIdPk = :dplaIdPk")
    , @NamedQuery(name = "Detalleplanilla.findByDplaIsss", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaIsss = :dplaIsss")
    , @NamedQuery(name = "Detalleplanilla.findByDplaAfp", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaAfp = :dplaAfp")
    , @NamedQuery(name = "Detalleplanilla.findByDplaImpRenta", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaImpRenta = :dplaImpRenta")
    , @NamedQuery(name = "Detalleplanilla.findByDplaTotPagar", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaTotPagar = :dplaTotPagar")
    , @NamedQuery(name = "Detalleplanilla.findByDplaDiasLaborados", query = "SELECT d FROM Detalleplanilla d WHERE d.dplaDiasLaborados = :dplaDiasLaborados")})
public class Detalleplanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DPLA_ID_PK", nullable = false)
    private Integer dplaIdPk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DPLA_ISSS", precision = 10, scale = 2)
    private BigDecimal dplaIsss;
    @Column(name = "DPLA_AFP", precision = 10, scale = 2)
    private BigDecimal dplaAfp;
    @Column(name = "DPLA_IMP_RENTA", precision = 10, scale = 2)
    private BigDecimal dplaImpRenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DPLA_TOT_PAGAR", nullable = false, precision = 10, scale = 2)
    private BigDecimal dplaTotPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DPLA_DIAS_LABORADOS", nullable = false)
    private short dplaDiasLaborados;
    @JoinColumn(name = "PLA_ID_FK", referencedColumnName = "PLA_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Planilla plaIdFk;
    @JoinColumn(name = "CONT_ID_PK", referencedColumnName = "CONT_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Contrato contIdPk;

    public Detalleplanilla() {
    }

    public Detalleplanilla(Integer dplaIdPk) {
        this.dplaIdPk = dplaIdPk;
    }

    public Detalleplanilla(Integer dplaIdPk, BigDecimal dplaTotPagar, short dplaDiasLaborados) {
        this.dplaIdPk = dplaIdPk;
        this.dplaTotPagar = dplaTotPagar;
        this.dplaDiasLaborados = dplaDiasLaborados;
    }

    public Integer getDplaIdPk() {
        return dplaIdPk;
    }

    public void setDplaIdPk(Integer dplaIdPk) {
        this.dplaIdPk = dplaIdPk;
    }

    public BigDecimal getDplaIsss() {
        return dplaIsss;
    }

    public void setDplaIsss(BigDecimal dplaIsss) {
        this.dplaIsss = dplaIsss;
    }

    public BigDecimal getDplaAfp() {
        return dplaAfp;
    }

    public void setDplaAfp(BigDecimal dplaAfp) {
        this.dplaAfp = dplaAfp;
    }

    public BigDecimal getDplaImpRenta() {
        return dplaImpRenta;
    }

    public void setDplaImpRenta(BigDecimal dplaImpRenta) {
        this.dplaImpRenta = dplaImpRenta;
    }

    public BigDecimal getDplaTotPagar() {
        return dplaTotPagar;
    }

    public void setDplaTotPagar(BigDecimal dplaTotPagar) {
        this.dplaTotPagar = dplaTotPagar;
    }

    public short getDplaDiasLaborados() {
        return dplaDiasLaborados;
    }

    public void setDplaDiasLaborados(short dplaDiasLaborados) {
        this.dplaDiasLaborados = dplaDiasLaborados;
    }

    public Planilla getPlaIdFk() {
        return plaIdFk;
    }

    public void setPlaIdFk(Planilla plaIdFk) {
        this.plaIdFk = plaIdFk;
    }

    public Contrato getContIdPk() {
        return contIdPk;
    }

    public void setContIdPk(Contrato contIdPk) {
        this.contIdPk = contIdPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dplaIdPk != null ? dplaIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleplanilla)) {
            return false;
        }
        Detalleplanilla other = (Detalleplanilla) object;
        if ((this.dplaIdPk == null && other.dplaIdPk != null) || (this.dplaIdPk != null && !this.dplaIdPk.equals(other.dplaIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Detalleplanilla[ dplaIdPk=" + dplaIdPk + " ]";
    }
    
}
