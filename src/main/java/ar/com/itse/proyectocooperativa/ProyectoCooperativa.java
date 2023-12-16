
package ar.com.itse.proyectocooperativa;

import ar.com.itse.proyectocooperativa.gui.Principal;
import ar.com.itse.proyectocooperativa.logica.Controladora;
import ar.com.itse.proyectocooperativa.logica.Producto;
import ar.com.itse.proyectocooperativa.logica.Productor;
import java.util.List;
import java.util.ArrayList;

public class ProyectoCooperativa {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        // Creamos un nuevo Productor
//    Productor productor2 = new Productor();
//    productor2.setNombre("Nombre del Productor2");
//    productor2.setPuesto("Puesto del Productor2");
//    productor2.setTelefono("123-456-78900");
//    productor2.setLocalidad("Localidad del Productor2");
//    productor2.setTipo("Tipo del Productor2");
//    productor2.setFechaIngreso("2023-10-30"); 
//   control.crearProductor(productor2);

//List<Producto> productos = new ArrayList<>(); // es irrelevante. Ver nota debajo
//
//    Producto producto1 = new Producto();
//    producto1.setDescripcion("Producto 1");
//    producto1.setCantidad(10);
//    producto1.setBultos(2);
//    producto1.setFechaIngreso("2023-10-28");
//    producto1.setObservaciones("Observaciones para Producto 1");
////Aqui debo usar un metodo que busque un productor y lo retorne a un objeto productor que se va a añadir a este producto. Nota es mejor que pida el dni no el id
//
//    Productor productor = control.traerUnProductor(1);
//    producto1.setProductor(productor); // Establece la relación con el productor
//    productos.add(producto1);  //es irrelevante pues a medida que se agraguene productos luego se trae toda esa lista
//    control.crearProducto(producto1);
        
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.setResizable(false);
//ArrayList<Producto> arreglo =  control.traerProductos();
//
//
//for(Producto aux: arreglo){
//    System.out.println("->" + aux);
//}

    }
    
}