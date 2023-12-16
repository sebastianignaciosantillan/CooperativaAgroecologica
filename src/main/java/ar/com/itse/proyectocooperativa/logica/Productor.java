
package ar.com.itse.proyectocooperativa.logica;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Productor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproductor;
    private String nombre;
    private String puesto;
    private String telefono;
    private String localidad;
    private String tipo;
    private String fechaIngreso;

    @OneToMany(mappedBy = "productor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;

   public Productor() {
    }

    public Productor(int idproductor, String nombre, String puesto, String telefono, String localidad, String tipo, String fechaIngreso) {
        this.idproductor = idproductor;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.localidad = localidad;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
    }
   
    public Productor( String nombre, String puesto, String telefono, String localidad, String tipo, String fechaIngreso, List<Producto> productos) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.localidad = localidad;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.productos = productos;
    }
 public Productor( String nombre, String puesto, String telefono, String localidad, String tipo, String fechaIngreso) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.localidad = localidad;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
    }
    
    public int getIdproductor() {
        return idproductor;
    }

    public void setIdproductor(int idproductor) {
        this.idproductor = idproductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

 @Override
    public String toString() {
        return "Productor{" + "idproductor=" + idproductor + ", nombre=" + nombre + ", puesto=" + puesto + ", telefono=" + telefono + ", localidad=" + localidad + ", tipo=" + tipo + ", fechaIngreso=" + fechaIngreso + ", productos=" + productos + '}';
    }
}
