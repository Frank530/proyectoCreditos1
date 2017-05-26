package co.edu.ims.web;

import co.edu.ims.servicio.res.CategoriaRest;
import co.ims.soa.sswcompraventa.modelo.Categoria;
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
public class CategoriaBean {
    @Inject CategoriaRest categoriaRest;
    
    private List<Categoria> categorias;    
    private Categoria categoria;
    private String descripcion;
    
    public CategoriaBean() {
    }
    
    @PostConstruct
    public void init(){
        categorias = categoriaRest.buscar();
        categoria = new Categoria();
    }
    
    public String guardar(){
        System.out.println("guardar...");
        categoriaRest.agregar(categoria);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria",  "Se ha guardado correctamente") );
        return null;
    }
  
    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        categoriaRest.actualizar(categoria);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria",  "Se ha actualizado correctamente") );
//    }
    
    public void actualizar(RowEditEvent event){
        categoria = (Categoria) event.getObject();
        categoria.setDescripcion(descripcion);
        categoriaRest.actualizar(categoria);
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha actualizado correctamente") );
    }
    
    public void cancelar(RowEditEvent event){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento cancelado!!") );
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaRest getCategoriaRest() {
        return categoriaRest;
    }

    public void setCategoriaRest(CategoriaRest categoriaRest) {
        this.categoriaRest = categoriaRest;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
 
}
