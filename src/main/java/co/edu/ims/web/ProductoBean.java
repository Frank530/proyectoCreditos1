
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
import org.primefaces.event.RowEditEvent;

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
        Categoria c = categoriaRest.buscarPorId(producto.getCategoria().getId());
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
    
    
    
   public String actualizar(RowEditEvent event){
        Categoria categoria; 
        producto = (Producto) event.getObject();
        categoria = categoriaRest.buscarPorId(producto.getCategoria().getId());
        producto.setCategoria(categoria);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha actualizado correctamente "));
        productoRest.actualizar(producto);
        init();
        return null;
    }
   
//    public void actualizarCategoria(ValueChangeEvent e){        
//        Categoria categoria;
//        categoria = categoriaRest.buscar(Long.parseLong(e.getNewValue().toString()));
//        System.out.println("categoria "+categoria.getDescripcion());
//        producto.setCategoria(categoria);
//    }
    
    public String eliminar(Producto producto){
        productoRest.elminar(producto.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
        init();
        return null;
    }
    public void cancelar(RowEditEvent event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento cancelado!!") );
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


