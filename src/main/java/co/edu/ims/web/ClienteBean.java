package co.edu.ims.web;

import co.edu.ims.servicio.res.ClienteRest;
import co.ims.soa.sswcompraventa.modelo.Cliente;
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
public class ClienteBean {
    @Inject ClienteRest clienteRest;
    
    private List<Cliente> clientes;    
    private Cliente cliente;

    public ClienteBean() {
    }
    
    @PostConstruct
    public void init(){
        clientes = clienteRest.buscarT();
        cliente = new Cliente();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        clienteRest.agregar(cliente);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente",  "Se ha guardado correctamente") );
    }
    
    public void actualizar(){
        System.out.println("Actualizar...");
        clienteRest.actualizar(cliente);
        init();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente",  "Se ha actualizado correctamente") );
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
