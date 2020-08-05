package com.bitlab.entidades;

import com.bitlab.entidades.Contrato;
import com.bitlab.entidades.Departamento;
import com.bitlab.entidades.Rol;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-05T05:19:19")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> empDireccion;
    public static volatile SingularAttribute<Empleado, Departamento> deptIdFk;
    public static volatile SingularAttribute<Empleado, String> empDocumento;
    public static volatile SingularAttribute<Empleado, Rol> rolIdFk;
    public static volatile SingularAttribute<Empleado, Boolean> empEstado;
    public static volatile SingularAttribute<Empleado, String> empNif;
    public static volatile SingularAttribute<Empleado, String> empTelefono;
    public static volatile SingularAttribute<Empleado, String> empApellidos;
    public static volatile SingularAttribute<Empleado, BigDecimal> empComision;
    public static volatile SingularAttribute<Empleado, Date> empFechaNacimiento;
    public static volatile ListAttribute<Empleado, Contrato> contratoList;
    public static volatile SingularAttribute<Empleado, Integer> empIdPk;
    public static volatile SingularAttribute<Empleado, String> empNombres;
    public static volatile SingularAttribute<Empleado, Character> empGenero;
    public static volatile SingularAttribute<Empleado, String> empCorreo;
    public static volatile SingularAttribute<Empleado, String> empProfesion;

}