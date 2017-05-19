
package co.edu.ims.web;

import co.edu.ims.servicio.res.FacturaRest;
import co.ims.soa.sswcompraventa.modelo.Factura;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * @author Alejandra Parra
 */

@ManagedBean
@SessionScoped
public class FacturaBean {
    
    @Inject FacturaRest facturaRest;
    
    private List<Factura> facturas;    
    private Factura factura;

    public FacturaBean() {
    }
    
    @PostConstruct
    public void init(){
        facturas = facturaRest.buscar();
        factura = new Factura();
    }
    
    public void guardar(){
        System.out.println("guardar");
        facturaRest.agregar(factura);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Factura",  "Se ha guardado correctamente") );
    }
    
    public void actualizar(){
        System.out.println("Actualizar...");
        facturaRest.actualizar(factura);
        init();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Factura",  "Se ha actualizado correctamente") );
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
}
