package ar.com.itse.proyectocooperativa.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ar.com.itse.proyectocooperativa.logica.Producto;
import ar.com.itse.proyectocooperativa.logica.Productor;
import ar.com.itse.proyectocooperativa.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ProductorJpaController implements Serializable {

    public ProductorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    //controlador que vale
    public ProductorJpaController() {
        emf = Persistence.createEntityManagerFactory("dbcooperativa");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productor productor) {
        if (productor.getProductos() == null) {
            productor.setProductos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductos = new ArrayList<Producto>();
            for (Producto productosProductoToAttach : productor.getProductos()) {
                productosProductoToAttach = em.getReference(productosProductoToAttach.getClass(), productosProductoToAttach.getIdproducto());
                attachedProductos.add(productosProductoToAttach);
            }
            productor.setProductos(attachedProductos);
            em.persist(productor);
            for (Producto productosProducto : productor.getProductos()) {
                Productor oldProductorOfProductosProducto = productosProducto.getProductor();
                productosProducto.setProductor(productor);
                productosProducto = em.merge(productosProducto);
                if (oldProductorOfProductosProducto != null) {
                    oldProductorOfProductosProducto.getProductos().remove(productosProducto);
                    oldProductorOfProductosProducto = em.merge(oldProductorOfProductosProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productor productor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productor persistentProductor = em.find(Productor.class, productor.getIdproductor());
            List<Producto> productosOld = persistentProductor.getProductos();
            List<Producto> productosNew = productor.getProductos();
            List<Producto> attachedProductosNew = new ArrayList<Producto>();
            for (Producto productosNewProductoToAttach : productosNew) {
                productosNewProductoToAttach = em.getReference(productosNewProductoToAttach.getClass(), productosNewProductoToAttach.getIdproducto());
                attachedProductosNew.add(productosNewProductoToAttach);
            }
            productosNew = attachedProductosNew;
            productor.setProductos(productosNew);
            productor = em.merge(productor);
            for (Producto productosOldProducto : productosOld) {
                if (!productosNew.contains(productosOldProducto)) {
                    productosOldProducto.setProductor(null);
                    productosOldProducto = em.merge(productosOldProducto);
                }
            }
            for (Producto productosNewProducto : productosNew) {
                if (!productosOld.contains(productosNewProducto)) {
                    Productor oldProductorOfProductosNewProducto = productosNewProducto.getProductor();
                    productosNewProducto.setProductor(productor);
                    productosNewProducto = em.merge(productosNewProducto);
                    if (oldProductorOfProductosNewProducto != null && !oldProductorOfProductosNewProducto.equals(productor)) {
                        oldProductorOfProductosNewProducto.getProductos().remove(productosNewProducto);
                        oldProductorOfProductosNewProducto = em.merge(oldProductorOfProductosNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = productor.getIdproductor();
                if (findProductor(id) == null) {
                    throw new NonexistentEntityException("The productor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productor productor;
            try {
                productor = em.getReference(Productor.class, id);
                productor.getIdproductor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productor with id " + id + " no longer exists.", enfe);
            }
            List<Producto> productos = productor.getProductos();
            for (Producto productosProducto : productos) {
                productosProducto.setProductor(null);
                productosProducto = em.merge(productosProducto);
            }
            em.remove(productor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productor> findProductorEntities() {
        return findProductorEntities(true, -1, -1);
    }

    public List<Productor> findProductorEntities(int maxResults, int firstResult) {
        return findProductorEntities(false, maxResults, firstResult);
    }

    private List<Productor> findProductorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Productor findProductor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productor> rt = cq.from(Productor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
