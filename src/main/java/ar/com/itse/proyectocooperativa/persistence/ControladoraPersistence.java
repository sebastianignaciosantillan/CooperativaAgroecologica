package ar.com.itse.proyectocooperativa.persistence;

import ar.com.itse.proyectocooperativa.logica.Producto;
import ar.com.itse.proyectocooperativa.logica.Productor;
import ar.com.itse.proyectocooperativa.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ControladoraPersistence {
  ProductorJpaController productorJpa = new ProductorJpaController();
  ProductoJpaController  productoJpa   = new ProductoJpaController();
  //metodos de productor
  
  //metodos de producto

    public void crearProductor(Productor productor) {
        productorJpa.create(productor);
    }
    
  public void eliminarProductor(int id) {
      try {
          productorJpa.destroy(id);
      } catch (NonexistentEntityException ex) {
          Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void editarProductor(Productor productor) {
      try {
          productorJpa.edit(productor);
      } catch (Exception ex) {
          Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  
  public ArrayList<Productor> traerProductores() {
      List<Productor> lista = productorJpa.findProductorEntities();
      ArrayList<Productor> listaP = new ArrayList<>(lista);
      return listaP;
  }
  
  
    public Productor traerUnProductor(int id) {
       return productorJpa.findProductor(id);
    }
  // ---------------------------------------------------------//
  
    public void crearProducto(Producto producto) {
        productoJpa.create(producto);
    }
    
    public void eliminarProducto(int id) {
      try {
          productoJpa.destroy(id);
      } catch (NonexistentEntityException ex) {
          Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void editarProducto(Producto producto) {
      try {
          productoJpa.edit(producto);
      } catch (Exception ex) {
          Logger.getLogger(ControladoraPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    public ArrayList<Producto> traerProductos() {
      List<Producto> lista = productoJpa.findProductoEntities();
      ArrayList<Producto> listaP = new ArrayList<>(lista);
      return listaP;
    }

    public Producto traerUnProducto(int id) {
        return productoJpa.findProducto(id);
    }

    
 // metodo de query personalizado para producto
public List<Producto> buscarProducto(String textoBusqueda) {
    EntityManager em = productoJpa.getEntityManager();
    Query query = em.createQuery("SELECT p FROM Producto p WHERE " +
                                  "p.nombre LIKE :textoBusqueda OR " +
                                  "p.cantidad LIKE :textoBusqueda OR " +
                                  "p.observaciones LIKE :textoBusqueda OR " +
                                  "p.bultos LIKE :textoBusqueda OR " +
                                  "p.fechaIngreso LIKE :textoBusqueda OR " +
                                  "p.descripcion LIKE :textoBusqueda");

    query.setParameter("textoBusqueda", "%" + textoBusqueda + "%");

    List<Producto> lista = query.getResultList();
    return lista;
}
public List<Productor> buscarProductor(String textoBusqueda) {
    EntityManager em = productorJpa.getEntityManager();
    Query query = em.createQuery("SELECT p FROM Productor p WHERE " +
                                  "p.nombre LIKE :textoBusqueda OR " +
                                  "p.puesto LIKE :textoBusqueda OR " +
                                  "p.telefono LIKE :textoBusqueda OR " +
                                  "p.localidad LIKE :textoBusqueda OR " +
                                  "p.tipo LIKE :textoBusqueda OR " +
                                  "p.fechaIngreso LIKE :textoBusqueda");

    query.setParameter("textoBusqueda", "%" + textoBusqueda + "%");

    List<Productor> lista = query.getResultList();
    return lista;
}




    
    
}
