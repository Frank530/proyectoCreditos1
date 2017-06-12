package co.ims.soa.sswcompraventa.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Silvia
 */
@Entity
public class Detalle implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cantidad;
    @ManyToOne
    @JoinColumn(name ="fk_factura")
    private Factura idFactura;
    @ManyToOne
    @JoinColumn(name = "fk_producto")
    private Producto idProducto;
    
    public Detalle(){
        idProducto = new Producto();
        idFactura = new Factura();
        
    }

    public Detalle(Long id, String cantidad, Factura idFactura, Producto idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    
}
