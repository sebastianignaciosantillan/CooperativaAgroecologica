package ar.com.itse.proyectocooperativa.logica;

import ar.com.itse.proyectocooperativa.logica.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-12T18:49:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Productor.class)
public class Productor_ { 

    public static volatile SingularAttribute<Productor, String> puesto;
    public static volatile SingularAttribute<Productor, String> fechaIngreso;
    public static volatile SingularAttribute<Productor, String> tipo;
    public static volatile SingularAttribute<Productor, String> localidad;
    public static volatile SingularAttribute<Productor, Integer> idproductor;
    public static volatile SingularAttribute<Productor, String> telefono;
    public static volatile SingularAttribute<Productor, String> nombre;
    public static volatile ListAttribute<Productor, Producto> productos;

}