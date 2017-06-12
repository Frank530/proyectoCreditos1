
package co.edu.ims.web;

import co.edu.ims.servicio.res.ClienteRest;
import co.edu.ims.servicio.res.FacturaRest;
import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Cliente;
import co.ims.soa.sswcompraventa.modelo.Factura;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 * @author Alejandra Parra
 */

@ManagedBean
@SessionScoped
public class FacturaBean {
    
    @Inject FacturaRest facturaRest;
    @Inject ClienteRest clienteRest;
    
    private List<Factura> facturas;    
    private Factura factura;

    public FacturaBean() {
    }
    
    @PostConstruct
    public void init(){
        facturas = facturaRest.buscarTodos();
        factura = new Factura();
    }
    
    public String guardar(){
        Cliente c = clienteRest.buscar(factura.getIdCliente().getId());
        factura.setIdCliente(c);
        System.out.println("cliente: "+c.getNombre());
        facturaRest.agregar(factura);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Factura",  "Se ha guardado correctamente") );
        return null;
    }
    
    public String actualizar(RowEditEvent event){
        factura = (Factura) event.getObject();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha actualizado correctamente ") );
        facturaRest.actualizar(factura);
        init();
        return null;
    }
    
    public  String eliminar(Factura factura){
        facturaRest.elminar(factura.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado Correctamente "));
        init();
        return null;
    }
    
    public void cancelar(RowEditEvent event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento cancelado!!") );
    }
    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        facturaRest.actualizar(factura);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Factura",  "Se ha actualizado correctamente") );
//    }

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
