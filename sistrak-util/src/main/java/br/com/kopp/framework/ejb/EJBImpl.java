package br.com.kopp.framework.ejb;

import br.com.kopp.framework.mapper.Mapper;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
public abstract class EJBImpl {
    
    @Inject
    private Mapper mapper;
    
    protected Mapper getMapper() {
        return this.mapper;
    }
    
}
