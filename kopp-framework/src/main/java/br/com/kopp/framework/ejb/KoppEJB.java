package br.com.kopp.framework.ejb;

import javax.inject.Inject;

import br.com.kopp.framework.mapper.IKoppMapper;

/**
 *
 * @author cgoettert
 */
public abstract class KoppEJB {
    
    @Inject
    private IKoppMapper mapper;
    
    protected IKoppMapper getMapper() {
        return this.mapper;
    }
    
}
