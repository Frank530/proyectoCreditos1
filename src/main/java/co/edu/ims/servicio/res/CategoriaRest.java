
package co.edu.ims.servicio.res;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.PersistenciaCategoria;

@Path("/categorias")
@Produces("application/json")
public class CategoriaRest {

    @Inject PersistenciaCategoria persistenciaCategoria;

    @GET
    @Produces("application/json")
    public Collection<Categoria> listar() {		
            return persistenciaCategoria.listarCategorias();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Categoria buscar(@PathParam("id") Long pId ) {
        System.out.println("buscando institucion con id: "+pId);
        return persistenciaCategoria.buscarCategoria(pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")	
    public Categoria agregar(Categoria cat){
            persistenciaCategoria.crearCategoria(cat);
            return cat;
    }

    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId ) {
    System.out.println("eliminando institucion con id:"+ pId);
        persistenciaCategoria.elminiarCategoria(pId);
        return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Categoria actualizar(Categoria cat) {
        persistenciaCategoria.actualizarCategoria(cat);
        return cat;
    }

}
