package com.bitlab.entidades;

import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-31T16:51:29")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> rolIdPk;
    public static volatile SingularAttribute<Rol, String> rolNombrerol;
    public static volatile SingularAttribute<Rol, String> rolDescripcion;
    public static volatile SingularAttribute<Rol, Boolean> rolEstatus;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile ListAttribute<Rol, Empleado> empleadoList;

}