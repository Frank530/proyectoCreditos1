package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Stateless
@Path("/categorias")
public class CategoriaRest {

    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
    
    @Inject SingletonEJB singletonEJB; 

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Categoria buscarPorId(@PathParam("id") Long pId) {
        return em.find(Categoria.class, pId);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Categoria agregar(Categoria entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }
    
    @GET 
    @Produces("application/json")
    public List <Categoria> buscarTodos(){
        String jpql = "SELECT c FROM Categoria c";
        TypedQuery <Categoria> q = em.createQuery(jpql,Categoria.class);
        List <Categoria> resultado = q.getResultList();
        return resultado;
    }
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response elminar(@PathParam("id") Long pId){
        Categoria c = em.find(Categoria.class, pId);
        if( c != null){
            em.remove(c);
        }else{
            System.out.println("Dato no encontrado");
        }
        return Response.noContent().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Categoria actualizar(Categoria p){
        em.merge(p);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
    }
 
    @GET
    @Path("/descripcion/{nombre}")
    @Produces("application/json")       
    public List<Categoria> buscarPorNombre(@PathParam("nombre") String nombre){                
        String jpql = "SELECT c FROM Categoria c WHERE c.descripcion LIKE :cDescripcion ";        
        TypedQuery<Categoria> q = em.createQuery(jpql, Categoria.class);
        q.setParameter("cDescripcion", "%"+nombre+"%");
        List<Categoria> resultado = q.getResultList();        
        return resultado;              
    }
    
}