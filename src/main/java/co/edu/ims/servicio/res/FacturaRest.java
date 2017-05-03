package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Factura;
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
@Path("/facturas")
public class FacturaRest {
    
    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Factura buscar(@PathParam("id") Integer pId){
        return em.find(Factura.class, pId);    
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Factura agregar(Factura entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
}
