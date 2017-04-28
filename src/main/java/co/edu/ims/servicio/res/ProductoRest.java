
package co.edu.ims.servicio.res;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Producto;
import co.ims.soa.sswcompraventa.modelo.PersistenciaProducto;

@Path("/productos")
@Produces("application/json")
public class ProductoRest {

    @Inject PersistenciaProducto persistenciaProducto;

    @GET
    @Produces("application/json")
    public Collection<Producto> listar() {		
            return persistenciaProducto.listarProductos();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Producto buscar(@PathParam("id") Long pId ) {
        System.out.println("buscando producto con id: "+pId);
        return persistenciaProducto.buscarProducto(pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")	
    public Producto agregar(Producto cat){
            persistenciaProducto.crearProducto(cat);
            return cat;
    }

    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId ) {
    System.out.println("eliminando producto con id:"+ pId);
        persistenciaProducto.elminiarProducto(pId);
        return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Producto actualizar(Producto cat) {
        persistenciaProducto.actualizarProducto(cat);
        return cat;
    }

}
