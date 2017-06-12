package co.edu.ims.web;

import co.edu.ims.servicio.res.CategoriaRest;
import co.edu.ims.servicio.res.DetalleRest;
import co.edu.ims.servicio.res.FacturaRest;
import co.edu.ims.servicio.res.ProductoRest;
import co.ims.soa.sswcompraventa.modelo.Detalle;
import co.ims.soa.sswcompraventa.modelo.Factura;
import co.ims.soa.sswcompraventa.modelo.Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 * @author Silvia
 */
@ManagedBean
@SessionScoped
public class DetalleBean {
    @Inject DetalleRest detalleRest;
    @Inject ProductoRest productoRest;
    @Inject CategoriaRest categoriaRest;
    @Inject FacturaRest facturaRest;
   
    
    private List<Detalle> detalles;    
    private Detalle detalle;
    private Factura facturas;
    private Producto productos;

    public DetalleBean() {
    }
    
    @PostConstruct
    public void init(){
        detalles = detalleRest.buscarTodos();
        detalle = new Detalle();
    }
    
     public String guardar(){
        System.out.println("guardar...");
        Factura f = facturaRest.buscar(detalle.getIdFactura().getId());
        Producto p = productoRest.buscar(detalle.getIdProducto().getId());
        detalle.setIdFactura(f);
        detalle.setIdProducto(p);
        detalleRest.agregar(detalle);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle",  "Se ha guardado correctamente") );
        return null;
    }
    
    
     public String actualizar(RowEditEvent event){
        Factura factura; 
        Producto producto; 
        
        detalle = (Detalle) event.getObject();
        factura = facturaRest.buscar(detalle.getIdFactura().getId());
        detalle.setIdFactura(factura);
        producto = productoRest.buscar(detalle.getIdProducto().getId());
        detalle.setIdProducto(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha actualizado correctamente "));
        detalleRest.actualizar(detalle);
        init();
        return null;
    }
    
       public String eliminar(Detalle detalle){
        detalleRest.elminar(detalle.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
        init();
        return null;
    }
     
    
    public void cancelar(RowEditEvent event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento cancelado!!") );
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    
   
    
}
