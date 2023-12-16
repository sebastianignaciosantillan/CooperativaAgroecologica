
package ar.com.itse.proyectocooperativa.logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int bultos;
    private String fechaIngreso;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "productor_id")
    private Productor productor;

    
     public Producto() {
    }

    public Producto(int idproducto, String nombre, String descripcion, int cantidad, int bultos, String fechaIngreso, String observaciones, Productor productor) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.bultos = bultos;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.productor = productor;
    }
    
    public Producto(String nombre, String descripcion, int cantidad, int bultos, String fechaIngreso, String observaciones, Productor productor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.bultos = bultos;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.productor = productor;
    }
    //este constructor no se trae asociado el productor. Pretende solo mostrar todos los productos
    public Producto(String nombre, String descripcion, int cantidad, int bultos, String fechaIngreso, String observaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.bultos = bultos;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
     
    }
    
    
    
   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getBultos() {
        return bultos;
    }

    public void setBultos(int bultos) {
        this.bultos = bultos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    
    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", bultos=" + bultos + ", fechaIngreso=" + fechaIngreso + ", observaciones=" + observaciones + ", productor=" + productor + '}';
    }

}
