/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Detalle;
import co.ims.soa.sswcompraventa.modelo.PersistenciaDetalle;
import java.util.Collection;
import javax.inject.Inject;
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
       @Inject PersistenciaDetalle persistenciaDetalle;

    @GET
    @Produces("application/json")
    public Collection<Detalle> listar() {		
        return persistenciaDetalle.listarDetalle();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Detalle buscar(@PathParam("id") Long pId ) {
        System.out.println("buscando el  detalle por id: "+pId);
        return persistenciaDetalle.buscarDetalle(pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")	
    public Detalle agregar(Detalle cat){
        persistenciaDetalle.crearDetalle(cat);
        return cat;
    }

    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId ) {
    System.out.println("eliminando Detalle por id:"+ pId);
        persistenciaDetalle.elminiarDetalle(pId);
        return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Detalle actualizar(Detalle cat) {
        persistenciaDetalle.actualizarDetalle(cat);
        return cat;
    }
    
}
