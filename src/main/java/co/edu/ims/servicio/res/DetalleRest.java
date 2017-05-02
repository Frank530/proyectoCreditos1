/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Detalle;

import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Silvia
 */
@Path("/detalles")
@Produces("application/json")
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
    public Detalle agregar(Detalle entity){
        em.persist(entity);
        em.flush();
        return entity;
    }

  

//    
    
}
