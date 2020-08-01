package com.bitlab.entidades;

import com.bitlab.entidades.Contrato;
import com.bitlab.entidades.Planilla;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-01T10:53:30")
@StaticMetamodel(Detalleplanilla.class)
public class Detalleplanilla_ { 

    public static volatile SingularAttribute<Detalleplanilla, Integer> dplaIdPk;
    public static volatile SingularAttribute<Detalleplanilla, BigDecimal> dplaTotPagar;
    public static volatile SingularAttribute<Detalleplanilla, BigDecimal> dplaAfp;
    public static volatile SingularAttribute<Detalleplanilla, BigDecimal> dplaImpRenta;
    public static volatile SingularAttribute<Detalleplanilla, Short> dplaDiasLaborados;
    public static volatile SingularAttribute<Detalleplanilla, Contrato> contIdPk;
    public static volatile SingularAttribute<Detalleplanilla, Planilla> plaIdFk;
    public static volatile SingularAttribute<Detalleplanilla, BigDecimal> dplaIsss;

}