
package co.edu.ims.servicio.res;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Path("/productos")
public class ProductoRest {

  
    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;

    @Inject SingletonEJB singletonEJB; 
    //buscar
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Producto buscar(@PathParam("id") Long pId){
        return em.find(Producto.class, pId);        
    }
   
    //agregar
     @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Producto agregar(Producto entity){
        em.persist(entity);
        em.flush();
        return entity;
        
        
    }
     
    @GET 
    @Produces("application/json")
    public List <Producto> buscarTodo(){
        String jpql = "SELECT p FROM Producto p";
        TypedQuery <Producto> q = em.createQuery(jpql,Producto.class);
        List <Producto> resultado = q.getResultList();
        return resultado;
    }
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response elminar(@PathParam("id") Long pId){
        Producto p = em.find(Producto.class, pId);
        if( p != null){
            em.remove(p);
        }
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return Response.noContent().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Producto actualizar(Producto p){
        em.merge(p);
        return p;
    }
 
    @GET
    @Path("/descripcion/{nombre}")
    @Produces("application/json")       
    public List<Producto> buscarPorNombre(@PathParam("nombre") String nombre){                
        String jpql = "SELECT p FROM Producto p WHERE p.descripcion LIKE :pDescripcion ";        
        TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
        q.setParameter("pDescripcion", "%"+nombre+"%");
        List<Producto> resultado = q.getResultList();        
        return resultado;              
    }
    
}
    

