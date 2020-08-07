package com.bitlab.entidades;

import com.bitlab.entidades.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-07T00:21:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuNombre;
    public static volatile SingularAttribute<Usuario, String> usuCorreo;
    public static volatile SingularAttribute<Usuario, Boolean> usuEstatus;
    public static volatile SingularAttribute<Usuario, Integer> usuIdPk;
    public static volatile SingularAttribute<Usuario, Rol> rolIdFk;
    public static volatile SingularAttribute<Usuario, Date> usuFechaCreacion;
    public static volatile SingularAttribute<Usuario, String> usuContrasena;
    public static volatile SingularAttribute<Usuario, Date> usuFechaConexion;

}