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
@Table(name = "BIT_CONTRATO", catalog = "BITLAB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByContIdPk", query = "SELECT c FROM Contrato c WHERE c.contIdPk = :contIdPk")
    , @NamedQuery(name = "Contrato.findByContNombre", query = "SELECT c FROM Contrato c WHERE c.contNombre = :contNombre")
    , @NamedQuery(name = "Contrato.findByContSalario", query = "SELECT c FROM Contrato c WHERE c.contSalario = :contSalario")
    , @NamedQuery(name = "Contrato.findByContFechaInicioContrato", query = "SELECT c FROM Contrato c WHERE c.contFechaInicioContrato = :contFechaInicioContrato")
    , @NamedQuery(name = "Contrato.findByContFechaFinContrato", query = "SELECT c FROM Contrato c WHERE c.contFechaFinContrato = :contFechaFinContrato")
    , @NamedQuery(name = "Contrato.findByContObservacion", query = "SELECT c FROM Contrato c WHERE c.contObservacion = :contObservacion")
    , @NamedQuery(name = "Contrato.findByContEstatus", query = "SELECT c FROM Contrato c WHERE c.contEstatus = :contEstatus")
    , @NamedQuery(name = "Contrato.findByContHorario", query = "SELECT c FROM Contrato c WHERE c.contHorario = :contHorario")
    , @NamedQuery(name = "Contrato.findByContHorasDia", query = "SELECT c FROM Contrato c WHERE c.contHorasDia = :contHorasDia")
    , @NamedQuery(name = "Contrato.findByContDiasLaborados", query = "SELECT c FROM Contrato c WHERE c.contDiasLaborados = :contDiasLaborados")
    , @NamedQuery(name = "Contrato.findByContTipoPago", query = "SELECT c FROM Contrato c WHERE c.contTipoPago = :contTipoPago")
    , @NamedQuery(name = "Contrato.findByContPeriodoPago", query = "SELECT c FROM Contrato c WHERE c.contPeriodoPago = :contPeriodoPago")
    , @NamedQuery(name = "Contrato.findByContTipoplaza", query = "SELECT c FROM Contrato c WHERE c.contTipoplaza = :contTipoplaza")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONT_ID_PK", nullable = false)
    private Integer contIdPk;
    @Size(max = 50)
    @Column(name = "CONT_NOMBRE", length = 50)
    private String contNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_SALARIO", nullable = false, precision = 10, scale = 2)
    private BigDecimal contSalario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_FECHA_INICIO_CONTRATO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date contFechaInicioContrato;
    @Column(name = "CONT_FECHA_FIN_CONTRATO")
    @Temporal(TemporalType.DATE)
    private Date contFechaFinContrato;
    @Size(max = 200)
    @Column(name = "CONT_OBSERVACION", length = 200)
    private String contObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_ESTATUS", nullable = false)
    private boolean contEstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONT_HORARIO", nullable = false, length = 20)
    private String contHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_HORAS_DIA", nullable = false)
    private short contHorasDia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_DIAS_LABORADOS", nullable = false)
    private short contDiasLaborados;
    @Size(max = 50)
    @Column(name = "CONT_TIPO_PAGO", length = 50)
    private String contTipoPago;
    @Size(max = 50)
    @Column(name = "CONT_PERIODO_PAGO", length = 50)
    private String contPeriodoPago;
    @Size(max = 100)
    @Column(name = "CONT_TIPOPLAZA", length = 100)
    private String contTipoplaza;
    @JoinColumn(name = "EMP_ID_FK", referencedColumnName = "EMP_ID_PK", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empIdFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contIdPk", fetch = FetchType.EAGER)
    private List<Detalleplanilla> detalleplanillaList;

    public Contrato() {
    }

    public Contrato(Integer contIdPk) {
        this.contIdPk = contIdPk;
    }

    public Contrato(Integer contIdPk, BigDecimal contSalario, Date contFechaInicioContrato, boolean contEstatus, String contHorario, short contHorasDia, short contDiasLaborados) {
        this.contIdPk = contIdPk;
        this.contSalario = contSalario;
        this.contFechaInicioContrato = contFechaInicioContrato;
        this.contEstatus = contEstatus;
        this.contHorario = contHorario;
        this.contHorasDia = contHorasDia;
        this.contDiasLaborados = contDiasLaborados;
    }

    public Integer getContIdPk() {
        return contIdPk;
    }

    public void setContIdPk(Integer contIdPk) {
        this.contIdPk = contIdPk;
    }

    public String getContNombre() {
        return contNombre;
    }

    public void setContNombre(String contNombre) {
        this.contNombre = contNombre;
    }

    public BigDecimal getContSalario() {
        return contSalario;
    }

    public void setContSalario(BigDecimal contSalario) {
        this.contSalario = contSalario;
    }

    public Date getContFechaInicioContrato() {
        return contFechaInicioContrato;
    }

    public void setContFechaInicioContrato(Date contFechaInicioContrato) {
        this.contFechaInicioContrato = contFechaInicioContrato;
    }

    public Date getContFechaFinContrato() {
        return contFechaFinContrato;
    }

    public void setContFechaFinContrato(Date contFechaFinContrato) {
        this.contFechaFinContrato = contFechaFinContrato;
    }

    public String getContObservacion() {
        return contObservacion;
    }

    public void setContObservacion(String contObservacion) {
        this.contObservacion = contObservacion;
    }

    public boolean getContEstatus() {
        return contEstatus;
    }

    public void setContEstatus(boolean contEstatus) {
        this.contEstatus = contEstatus;
    }

    public String getContHorario() {
        return contHorario;
    }

    public void setContHorario(String contHorario) {
        this.contHorario = contHorario;
    }

    public short getContHorasDia() {
        return contHorasDia;
    }

    public void setContHorasDia(short contHorasDia) {
        this.contHorasDia = contHorasDia;
    }

    public short getContDiasLaborados() {
        return contDiasLaborados;
    }

    public void setContDiasLaborados(short contDiasLaborados) {
        this.contDiasLaborados = contDiasLaborados;
    }

    public String getContTipoPago() {
        return contTipoPago;
    }

    public void setContTipoPago(String contTipoPago) {
        this.contTipoPago = contTipoPago;
    }

    public String getContPeriodoPago() {
        return contPeriodoPago;
    }

    public void setContPeriodoPago(String contPeriodoPago) {
        this.contPeriodoPago = contPeriodoPago;
    }

    public String getContTipoplaza() {
        return contTipoplaza;
    }

    public void setContTipoplaza(String contTipoplaza) {
        this.contTipoplaza = contTipoplaza;
    }

    public Empleado getEmpIdFk() {
        return empIdFk;
    }

    public void setEmpIdFk(Empleado empIdFk) {
        this.empIdFk = empIdFk;
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
        hash += (contIdPk != null ? contIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contIdPk == null && other.contIdPk != null) || (this.contIdPk != null && !this.contIdPk.equals(other.contIdPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Contrato[ contIdPk=" + contIdPk + " ]";
    }
    
}
