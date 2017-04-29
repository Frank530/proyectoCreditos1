package co.ims.soa.sswcompraventa.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Silvia
 */

@Entity
public class Factura implements Serializable {
    
    @Id  
    private Long id;
    private String numFactura;
    private String fecha;
    
    @OneToMany
    @JoinColumn( name = "fk_cliente")
    private List <Cliente> idCliente;
    public Factura(){
        
    }

    public Factura(Long id, String numFactura, String fecha, List<Cliente> idCliente) {
        this.id = id;
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Cliente> getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(List<Cliente> idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
