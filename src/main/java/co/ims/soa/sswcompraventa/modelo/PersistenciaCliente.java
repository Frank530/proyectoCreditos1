package co.ims.soa.sswcompraventa.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 * @author Stiven
 */

@Singleton
public class PersistenciaCliente {

    private long id;
    private Map<Long, Cliente> listaClientes;

    public PersistenciaCliente() {
        id = 0;
        listaClientes = new HashMap<>();
    }
    
    public Cliente crearCliente(Cliente cat) {
		cat.setId(++id);
		listaClientes.put(id, cat);
		return cat;
	}

    public Collection<Cliente> listarClientes() {
            return listaClientes.values();
    }

    public Cliente buscarCliente(Long id) {			
            return listaClientes.get(id);
    }

    public Cliente actualizarCliente(Cliente inst){		
            if( listaClientes.containsKey(inst.getId()) ){
                listaClientes.put(inst.getId(), inst);
                return inst;
            }
            return null;
    }

    public boolean elminiarCliente(Long id){		
            if( listaClientes.containsKey(id) ){
                listaClientes.remove(id);
                return true;
            }else
                return false;
    }   
}
