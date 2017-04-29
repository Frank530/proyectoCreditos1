package co.ims.soa.sswcompraventa.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

@Singleton
public class PersistenciaFactura {

    private long id;
    private Map<Long, Factura> listaFactura;

    public PersistenciaFactura() {
        id = 0;
        listaFactura = new HashMap<>();
    }
    
    public Factura crearFactura(Factura fac) {
		fac.setId(++id);
		listaFactura.put(id, fac);
		return fac;
	}

    public Collection<Factura> listarFactura() {
            return listaFactura.values();
    }

    public Factura buscarFactura(Long id) {			
            return listaFactura.get(id);
    }

    public Factura actualizarFactura(Factura inst){		
            if( listaFactura.containsKey(inst.getId()) ){
                listaFactura.put(inst.getId(), inst);
                return inst;
            }
            return null;
    }

    public boolean elminiarFactura(Long id){		
            if( listaFactura.containsKey(id) ){
                listaFactura.remove(id);
                return true;
            }else
                return false;
    }   
}

