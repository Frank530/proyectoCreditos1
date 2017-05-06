package co.edu.ims.servicio.res;

import javax.ws.rs.*;
import co.ims.soa.sswcompraventa.modelo.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Path("/categorias")
public class CategoriaRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Categoria buscar(@PathParam("id") Integer pId) {
        return em.find(Categoria.class, pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Categoria agregar(Categoria entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }
    
    @GET 
    @Produces("Aplication/json")
    public List <Categoria> buscar(){
        String jpql = "SELECT c FROM categoria c";
        TypedQuery <Categoria> q = em.createQuery(jpql,Categoria.class);
        List <Categoria> resultado = q.getResultList();
        return resultado;
    }
    
}
