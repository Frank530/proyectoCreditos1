/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ims.soa.sswcompraventa.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Silvia
 */
@Singleton
public class PersistenciaDetalle {
    
    private long id;
    private Map<Long, Detalle> listaDetalle;
    
    public PersistenciaDetalle() {
        id = 0;
        listaDetalle = new HashMap<>();
    }
    
    public Detalle crearDetalle(Detalle cat) {
        cat.setId(++id);
        listaDetalle.put(id, cat);
        return cat;
	}

    public Collection<Detalle> listarDetalle() {
            return listaDetalle.values();
    }

    public Detalle buscarDetalle(long id) {			
            return listaDetalle.get(id);
    }

    public Detalle actualizarDetalle(Detalle det){		
            if( listaDetalle.containsKey(det.getId()) ){
                listaDetalle.put(det.getId(), det);
                return det;
            }
            return null;
    }

    public boolean elminiarDetalle(long id){		
            if( listaDetalle.containsKey(id) ){
                listaDetalle.remove(id);
                return true;
            }else
                return false;
    }
    
}
