
package co.edu.ims.servicio.res;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Cliente;
import co.ims.soa.sswcompraventa.modelo.PersistenciaCliente;

@Path("/clientes")
@Produces("application/json")
public class ClienteRest {

    @Inject PersistenciaCliente persistenciaCliente;

    @GET
    @Produces("application/json")
    public Collection<Cliente> listar() {		
            return persistenciaCliente.listarClientes();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Cliente buscar(@PathParam("id") Long pId ) {
        System.out.println("buscando cliente con id: "+pId);
        return persistenciaCliente.buscarCliente(pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")	
    public Cliente agregar(Cliente cat){
            persistenciaCliente.crearCliente(cat);
            return cat;
    }

    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId ) {
    System.out.println("eliminando cliente con id:"+ pId);
        persistenciaCliente.elminiarCliente(pId);
        return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Cliente actualizar(Cliente cat) {
        persistenciaCliente.actualizarCliente(cat);
        return cat;
    }

}
