package br.com.kopp.sistrak.skepi.servicos.usuario;

import br.com.kopp.framework.message.code.KoppCode;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.comum.exception.SkepyException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioServicoEjb extends KoppEJB implements UsuarioServicoLocal {

    @Inject
    @Mapper
    private UsuarioMapper usuarioMapper;

    @Override
    public Integer count() {
        return (int) usuarioMapper.countByExample(new UsuarioExample());
    }

    @Override
    public UsuarioDto get(Integer id) throws SkepyException {
        int minVal = 0;

        if (id < minVal) {
            throw new SkepyException(KoppCode.VALOR_MENOR_QUE_MINIMO, minVal, id);
        }

        Usuario usuario = usuarioMapper.selectByPrimaryKey(id);

        if (usuario == null) {
            throw new SkepyException(KoppCode.VALOR_NULO);
        }
        
        return getMapper()
                .comFunction(UsuarioConversor.obterConversorUsuarioParaUsuarioDTO())
                .converterObjeto(usuario);
    }

    @Override
    public List<UsuarioDto> getAll() {
        return getMapper()
                .comFunction(UsuarioConversor.obterConversorUsuarioParaUsuarioDTO())
                .converterLista(usuarioMapper.selectByExample(new UsuarioExample()));
    }

}
