package co.edu.ims.servicio.res;

import javax.ws.rs.*;
import co.ims.soa.sswcompraventa.modelo.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Path("/productos")
public class ProductoRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Producto buscar(@PathParam("id") Integer pId) {
        return em.find(Producto.class, pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Producto agregar(Producto entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

}
