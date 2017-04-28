package co.ims.soa.sswcompraventa.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 * @author Stiven
 */

@Singleton
public class PersistenciaCategoria {

    private long id;
    private Map<Long, Categoria> listaCategorias;

    public PersistenciaCategoria() {
        id = 0;
        listaCategorias = new HashMap<>();
    }
    
    public Categoria crearCategoria(Categoria cat) {
		cat.setId(++id);
		listaCategorias.put(id, cat);
		return cat;
	}

    public Collection<Categoria> listarCategorias() {
            return listaCategorias.values();
    }

    public Categoria buscarCategoria(Long id) {			
            return listaCategorias.get(id);
    }

    public Categoria actualizarCategoria(Categoria inst){		
            if( listaCategorias.containsKey(inst.getId()) ){
                listaCategorias.put(inst.getId(), inst);
                return inst;
            }
            return null;
    }

    public boolean elminiarCategoria(Long id){		
            if( listaCategorias.containsKey(id) ){
                listaCategorias.remove(id);
                return true;
            }else
                return false;
    }   
}
