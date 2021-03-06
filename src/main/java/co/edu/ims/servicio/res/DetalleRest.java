package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Detalle;
import co.ims.soa.sswcompraventa.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/detalles")
public class DetalleRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
    
    @Inject SingletonEJB singletonEJB;
    @Inject ProductoRest productoRest;

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
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Detalle actualizar(Detalle p){
        em.merge(p);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
    }
    
   
    
    @GET 
    @Produces("application/json")
    public List <Detalle> buscarTodos(){
        String jpql = "SELECT d FROM Detalle d";
        TypedQuery <Detalle> q = em.createQuery(jpql,Detalle.class);
        List <Detalle> resultado = q.getResultList();
        return resultado;
    }

}
