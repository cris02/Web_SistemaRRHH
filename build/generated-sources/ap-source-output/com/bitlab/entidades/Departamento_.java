package com.bitlab.entidades;

import com.bitlab.entidades.Empleado;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-05T23:12:28")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> deptNombre;
    public static volatile SingularAttribute<Departamento, Integer> deptIdPk;
    public static volatile SingularAttribute<Departamento, Boolean> deptEstado;
    public static volatile SingularAttribute<Departamento, Short> deptVacantesRequeridas;
    public static volatile SingularAttribute<Departamento, String> deptDescripcion;
    public static volatile ListAttribute<Departamento, Empleado> empleadoList;
    public static volatile SingularAttribute<Departamento, BigDecimal> deptPresupuesto;
    public static volatile SingularAttribute<Departamento, Short> deptVacanteDisponible;

}