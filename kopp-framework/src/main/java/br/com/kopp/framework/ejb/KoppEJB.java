package br.com.kopp.framework.ejb;

import javax.inject.Inject;
import br.com.kopp.framework.mapper.KoppMapper;

/**
 *
 * @author cgoettert
 */
public abstract class KoppEJB {
    
    @Inject
    private KoppMapper mapper;
    
    protected KoppMapper getMapper() {
        return this.mapper;
    }
    
}
