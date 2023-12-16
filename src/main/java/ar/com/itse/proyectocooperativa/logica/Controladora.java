package ar.com.itse.proyectocooperativa.logica;

import ar.com.itse.proyectocooperativa.persistence.ControladoraPersistence;
import java.util.ArrayList;
import java.util.List;


public class Controladora {
    //instancia de controladora de persistencia
    ControladoraPersistence controlPer = new ControladoraPersistence();
    //metodos de Productor
     public void crearProductor(Productor productor){
         controlPer.crearProductor(productor);
     }
    public void eliminarProductor(int id){
        controlPer.eliminarProductor(id);
    }
    public void editarProductor(Productor productor){
        controlPer.editarProductor(productor);
    }
    public ArrayList<Productor> traerProductores(){
        return controlPer.traerProductores();
    } 
    public Productor traerUnProductor(int id){
        return controlPer.traerUnProductor(id);
    }
    
    //metodos de Producto
     public void crearProducto(Producto producto){
         controlPer.crearProducto(producto);
     }
      public void eliminarProducto(int id){
        controlPer.eliminarProducto(id);
    }
     public void editarProducto(Producto producto){
        controlPer.editarProducto(producto);
    } 
    public ArrayList<Producto> traerProductos(){
        return controlPer.traerProductos();
    }  
   public Producto traerUnProducto(int id){
   return controlPer.traerUnProducto(id);
   }
    
   public List<Producto> buscarProducto(String producto){
   return controlPer.buscarProducto(producto);
   }
   
   public List<Productor> buscarProductor(String productor){
   return controlPer.buscarProductor(productor);
   }
   
}
