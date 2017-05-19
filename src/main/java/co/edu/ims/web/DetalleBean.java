package co.edu.ims.web;

import co.edu.ims.servicio.res.DetalleRest;
import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Detalle;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 * @author Silvia
 */
@ManagedBean
@SessionScoped
public class DetalleBean {
    @Inject DetalleRest detalleRest;
    
    private List<Detalle> detalles;    
    private Detalle detalle;

    public DetalleBean() {
    }
    
    @PostConstruct
    public void init(){
        detalles = detalleRest.buscarTodos();
        detalle = new Detalle();
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
