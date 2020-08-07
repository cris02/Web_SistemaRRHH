package com.bitlab.entidades;

import com.bitlab.entidades.Detalleplanilla;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-06T22:04:40")
@StaticMetamodel(Planilla.class)
public class Planilla_ { 

    public static volatile SingularAttribute<Planilla, Date> plaFechaInicio;
    public static volatile SingularAttribute<Planilla, String> plaObservacion;
    public static volatile SingularAttribute<Planilla, Integer> plaIdPk;
    public static volatile SingularAttribute<Planilla, Date> plaFechaFin;
    public static volatile ListAttribute<Planilla, Detalleplanilla> detalleplanillaList;
    public static volatile SingularAttribute<Planilla, String> plaNombre;
    public static volatile SingularAttribute<Planilla, String> plaResponsable;

}