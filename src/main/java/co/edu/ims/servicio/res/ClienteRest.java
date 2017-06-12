
package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Cliente;
import javax.ws.rs.*;

import co.ims.soa.sswcompraventa.modelo.Cliente;
import co.ims.soa.sswcompraventa.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

@Stateless
@Path("/clientes")

public class ClienteRest {
    
    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
        
    @Inject SingletonEJB singletonEJB; 

    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Cliente buscar(@PathParam("id") Long pId){
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
 
    @GET 
    @Produces("application/json")
    public List <Cliente> buscarT(){
        String jpql = "SELECT c FROM Cliente c";
        TypedQuery <Cliente> q = em.createQuery(jpql,Cliente.class);
        List <Cliente> resultado = q.getResultList();
        return resultado;
    }
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response elminar(@PathParam("id") Long pId){
        Cliente p = em.find(Cliente.class, pId);
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
    public Cliente actualizar(Cliente p){
        em.merge(p);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
    }
 
    @GET
    @Path("/descripcion/{nombre}")
    @Produces("application/json")       
    public List<Cliente> buscarPorNombre(@PathParam("nombre") String nombre){                
        String jpql = "SELECT c FROM Cliente c WHERE c.descripcion LIKE :cDescripcion ";        
        TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
        q.setParameter("cDescripcion", "%"+nombre+"%");
        List<Cliente> resultado = q.getResultList();        
        return resultado;              
    }
    
}