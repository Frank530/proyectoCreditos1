package co.edu.ims.servicio.res;

import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("/facturas")
public class FacturaRest {
    
    @PersistenceContext(unitName = "compraventaPU")
    protected EntityManager em;
    
    @Inject SingletonEJB singletonEJB;
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Factura buscar(@PathParam("id") Integer pId){
        return em.find(Factura.class, pId);    
    }
    
    @GET    
    @Produces("application/json")
    public List<Factura> buscar(){
        System.out.println("init...");
        String jpql = "SELECT fac FROM Factura fac";
        TypedQuery <Factura> f = em.createQuery(jpql, Factura.class);
        List<Factura> resultado = f.getResultList();
        return resultado;    
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Factura agregar(Factura entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
    
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response elminar(@PathParam("id") Integer pId){
        Factura f = em.find(Factura.class, pId);
        if( f != null){
            em.remove(f);
        }
        
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return Response.noContent().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Factura actualizar(Factura f){
        em.merge(f);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return f;
    }
 
    @GET
    @Path("/descripcion/{nombre}")
    @Produces("application/json")       
    public List<Factura> buscarPorNumero(@PathParam("numero") String numero){                
        String jpql = "SELECT f FROM Factura f WHERE f.numFactura LIKE :fnumFactura ";        
        TypedQuery<Factura> q = em.createQuery(jpql, Factura.class);
        q.setParameter("fnumFactura", "%"+numero+"%");
        List<Factura> resultado = q.getResultList();        
        return resultado;            
    }
    
}
