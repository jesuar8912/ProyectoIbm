package com.ibm.entities;

import com.ibm.entities.Cliente;
import com.ibm.entities.Consumo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-17T13:23:05")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, String> tipo;
    public static volatile SingularAttribute<Tarjeta, String> numero;
    public static volatile SingularAttribute<Tarjeta, Cliente> clienteid;
    public static volatile SingularAttribute<Tarjeta, String> ccv;
    public static volatile SingularAttribute<Tarjeta, Integer> id;
    public static volatile CollectionAttribute<Tarjeta, Consumo> consumoCollection;

}