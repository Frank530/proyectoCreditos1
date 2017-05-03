package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Detalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/detalles")
public class DetalleRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Detalle buscar(@PathParam("id") Integer pId) {
        return em.find(Detalle.class, pId);

    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Detalle agregar(Detalle entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

}
