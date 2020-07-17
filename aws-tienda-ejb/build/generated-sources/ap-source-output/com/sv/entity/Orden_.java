package com.sv.entity;

import com.sv.entity.Cliente;
import com.sv.entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-17T12:42:34")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, String> fecha;
    public static volatile SingularAttribute<Orden, Integer> idorden;
    public static volatile SingularAttribute<Orden, Integer> cantidad;
    public static volatile SingularAttribute<Orden, Producto> idproducto;
    public static volatile SingularAttribute<Orden, Cliente> idcliente;

}