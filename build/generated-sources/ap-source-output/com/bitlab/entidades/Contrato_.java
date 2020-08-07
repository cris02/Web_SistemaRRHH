package com.bitlab.entidades;

import com.bitlab.entidades.Detalleplanilla;
import com.bitlab.entidades.Empleado;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-06T18:54:20")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, String> contTipoPago;
    public static volatile SingularAttribute<Contrato, Date> contFechaInicioContrato;
    public static volatile SingularAttribute<Contrato, Short> contDiasLaborados;
    public static volatile SingularAttribute<Contrato, String> contPeriodoPago;
    public static volatile SingularAttribute<Contrato, BigDecimal> contSalario;
    public static volatile SingularAttribute<Contrato, String> contHorario;
    public static volatile SingularAttribute<Contrato, String> contTipoplaza;
    public static volatile ListAttribute<Contrato, Detalleplanilla> detalleplanillaList;
    public static volatile SingularAttribute<Contrato, Integer> contIdPk;
    public static volatile SingularAttribute<Contrato, Empleado> empIdFk;
    public static volatile SingularAttribute<Contrato, String> contNombre;
    public static volatile SingularAttribute<Contrato, Boolean> contEstatus;
    public static volatile SingularAttribute<Contrato, String> contObservacion;
    public static volatile SingularAttribute<Contrato, Short> contHorasDia;
    public static volatile SingularAttribute<Contrato, Date> contFechaFinContrato;

}