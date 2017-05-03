
package co.edu.ims.servicio.res;

import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Path("/clientes")

public class ClienteRest {
    
    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
        
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Cliente buscar(@PathParam("id") Integer pId){
        return em.find(Cliente.class, pId);        
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Cliente agregar(Cliente entity){
        em.persist(entity);
        em.flush();
        return entity;     
        
        
    }
 
}