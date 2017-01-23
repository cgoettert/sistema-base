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
    private UsuarioOrigemDao usuarioOrigemDao;
    
    @Override
    public List<OrigemUsuarioDto> combo() throws SkepyException {
        List<UsuarioOrigem> lista = usuarioOrigemDao.findAll();
        
        return getMapper()
                .comFunction(UsuarioOrigemConversor.obterConversorUsuarioOrigem())
                .converterLista(lista);
    }

}
