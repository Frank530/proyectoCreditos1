package co.ims.soa.sswcompraventa.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 *
 * @author Silvia
 */
@Entity
public class Producto implements Serializable {

    @Id 
    private Long id;//id 
    private String descripcion;
    private int valor;
    @OneToMany 
    @JoinColumn(name ="fk_categoria")
    private List <Categoria> idCategoria;
    
    public Producto(){
        
    }

    public Producto(Long id, String descripcion, int valor, List<Categoria> idCategoria) {
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

    public List<Categoria> getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(List<Categoria> idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}
