package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class OrigemServicoEjb extends KoppEJB implements OrigemServicoLocal {

    @Inject
    private OrigemDao usuarioOrigemDao;
    
    @Override
    public List<OrigemDto> combo() throws SkepyException {
        List<Origem> lista = usuarioOrigemDao.findAll();
        
        return getMapper()
                .comFunction(OrigemConversorFactory.criarConversorOrigemDto())
                .converterLista(lista);
    }

}
