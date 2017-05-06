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
public class Producto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id 
    private String descripcion;
    private int valor;
    @ManyToOne 
    @JoinColumn(name ="fk_categoria")
    private Categoria idCategoria;
    
    public Producto(){
        
    }

    public Producto(Long id, String descripcion, int valor, Categoria idCategoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }
} 