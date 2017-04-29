
package co.edu.ims.servicio.res;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Path("/categorias")
public class CategoriaRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
        
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Categoria buscar(@PathParam("id") Integer pId){
        return em.find(Categoria.class, pId);        
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Categoria agregar(Categoria entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
 
    //Eliminar - Actualizar
}
