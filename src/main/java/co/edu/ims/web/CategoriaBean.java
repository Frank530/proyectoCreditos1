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

/**
 * @author Usuario 2
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {
    @Inject CategoriaRest categoriaRest;
    
    private List<Categoria> categorias;    
    private Categoria categoria;

    public CategoriaBean() {
    }
    
    @PostConstruct
    public void init(){
        categorias = categoriaRest.buscar();
        categoria = new Categoria();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        categoriaRest.agregar(categoria);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria",  "Se ha guardado correctamente") );
    }
    
    public void actualizar(){
        System.out.println("Actualizar...");
        categoriaRest.actualizar(categoria);
        init();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria",  "Se ha actualizado correctamente") );
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
    
}
