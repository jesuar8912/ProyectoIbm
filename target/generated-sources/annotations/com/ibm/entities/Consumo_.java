package com.ibm.entities;

import com.ibm.entities.Tarjeta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-17T13:23:05")
@StaticMetamodel(Consumo.class)
public class Consumo_ { 

    public static volatile SingularAttribute<Consumo, String> descripcion;
    public static volatile SingularAttribute<Consumo, Date> fecha;
    public static volatile SingularAttribute<Consumo, String> monto;
    public static volatile SingularAttribute<Consumo, Tarjeta> tarjetaid;
    public static volatile SingularAttribute<Consumo, Integer> id;

}