package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.conversores.FabricaConversoresDto;
import br.com.kopp.sistrak.skepi.exception.SkepyException;
import br.com.kopp.sistrak.skepi.persistence.mybatis.dao.UsuarioOrigemMapper;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioOrigem;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioOrigemExample;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.OrigemUsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.dto.OrigemUsuarioDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;

/**
 *
 * @author cgoettert
 */
@Stateless
public class OrigemUsuarioEJB extends KoppEJB implements OrigemUsuarioEJBLocal {

    @Inject
    @Mapper
    private UsuarioOrigemMapper mapper;
    
    @Override
    public List<OrigemUsuarioDTO> combo() throws SkepyException {
        List<UsuarioOrigem> lista = mapper.selectByExample(new UsuarioOrigemExample());
        
        return getMapper()
                .comFunction(FabricaConversoresDto.obterConversorUsuarioOrigem())
                .converterLista(lista);
    }

}
