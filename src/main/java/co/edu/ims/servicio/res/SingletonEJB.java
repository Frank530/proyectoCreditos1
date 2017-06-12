package co.edu.ims.servicio.res;

import javax.ejb.Singleton;

/**
 * @author Usuario 2
 */
@Singleton
public class SingletonEJB {
    private long codigoOperacion;
    
    public SingletonEJB(){
        codigoOperacion = 0;
    }
    
    public void incrementarCodigo(){
        codigoOperacion++;
    }
    
    public long getCodigoOperacion(){
        return codigoOperacion;
    }
}
