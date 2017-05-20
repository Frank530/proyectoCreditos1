
package co.edu.ims.web;

import co.edu.ims.servicio.res.CategoriaRest;
import co.edu.ims.servicio.res.ProductoRest;
import co.ims.soa.sswcompraventa.modelo.Categoria;
import co.ims.soa.sswcompraventa.modelo.Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * @author Usuario 2
 */
@ManagedBean
@SessionScoped
public class ProductoBean {
    @Inject ProductoRest productoRest;
    @Inject CategoriaRest categoriaRest;
    
    private List<Producto> productos;    
    private Producto producto;

    public ProductoBean() {
    }
    
    @PostConstruct
    public void init(){
        productos = productoRest.buscarTodo();
        producto = new Producto();
    }
    
    public String guardar(){
        System.out.println("guardar...");
        Categoria c = categoriaRest.buscar(producto.getCategoria().getId());
        if(c != null){
             producto.setCategoria(c);
            productoRest.agregar(producto);        
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto",  "Se ha guardado correctamente") );
            return null;
        }
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advertencia",  "Categoria no encontrada") );
       return null;
    }
    
    public void actualizar(){
        System.out.println("Actualizar...");
        productoRest.actualizar(producto);
        init();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto",  "Se ha actualizado correctamente") );
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

        
}


