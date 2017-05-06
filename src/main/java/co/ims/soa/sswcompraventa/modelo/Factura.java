package co.ims.soa.sswcompraventa.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Silvia
 */

@Entity
public class Factura implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numFactura;
    private String fecha;
    
    @ManyToOne
    @JoinColumn( name = "fk_cliente")
    private Cliente idCliente;
    public Factura(){
        
    }

    public Factura(Long id, String numFactura, String fecha, Cliente idCliente) {
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

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }   
    
}
