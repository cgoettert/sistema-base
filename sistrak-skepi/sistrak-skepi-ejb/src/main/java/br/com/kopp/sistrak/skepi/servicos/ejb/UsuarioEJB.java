package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.framework.message.code.KoppCode;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.persistence.mybatis.dao.UsuarioMapper;
import br.com.kopp.sistrak.skepi.servicos.interfaces.UsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.Usuario;
import br.com.kopp.sistrak.skepi.conversores.FabricaConversoresDto;
import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.exception.SkepyException;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioExample;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioEJB extends KoppEJB implements UsuarioEJBLocal {

    @Inject
    @Mapper
    private UsuarioMapper usuarioMapper;

    @Override
    public Integer count() {
        return (int) usuarioMapper.countByExample(new UsuarioExample());
    }

    @Override
    public UsuarioDTO get(Integer id) throws SkepyException {
        int minVal = 0;

        if (id < minVal) {
            throw new SkepyException(KoppCode.VALOR_MENOR_QUE_MINIMO, minVal, id);
        }

        Usuario usuario = usuarioMapper.selectByPrimaryKey(id);

        if (usuario == null) {
            throw new SkepyException(KoppCode.VALOR_NULO);
        }
        
        return getMapper()
                .comFunction(FabricaConversoresDto.obterConversorUsuarioParaUsuarioDTO())
                .converterObjeto(usuario);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return getMapper()
                .comFunction(FabricaConversoresDto.obterConversorUsuarioParaUsuarioDTO())
                .converterLista(usuarioMapper.selectByExample(new UsuarioExample()));
    }

}
