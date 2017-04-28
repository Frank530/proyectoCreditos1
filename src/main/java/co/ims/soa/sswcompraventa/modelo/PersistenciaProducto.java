package co.ims.soa.sswcompraventa.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 * @author Stiven
 */

@Singleton
public class PersistenciaProducto {

    private long id;
    private Map<Long, Producto> listaProductos;

    public PersistenciaProducto() {
        id = 0;
        listaProductos = new HashMap<>();
    }
    
    public Producto crearProducto(Producto cat) {
		cat.setId(++id);
		listaProductos.put(id, cat);
		return cat;
    }

    public Collection<Producto> listarProductos() {
            return listaProductos.values();
    }

    public Producto buscarProducto(Long id) {			
            return listaProductos.get(id);
    }

    public Producto actualizarProducto(Producto inst){		
            if( listaProductos.containsKey(inst.getId()) ){
                listaProductos.put(inst.getId(), inst);
                return inst;
            }
            return null;
    }

    public boolean elminiarProducto(Long id){		
            if( listaProductos.containsKey(id) ){
                listaProductos.remove(id);
                return true;
            }else
                return false;
    }   
}
