package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.framework.message.code.KoppCode;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.servicos.interfaces.UsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.dao.UsuarioDAO;
import br.com.kopp.sistrak.skepi.model.Usuario;
import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.exception.SkepyException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioEJB extends KoppEJB implements UsuarioEJBLocal {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Integer count() {
        return usuarioDAO.count();
    }

    @Override
    public UsuarioDTO get(Integer id) throws SkepyException {
        int minVal = 0;

        if (id < minVal) {
            throw new SkepyException(KoppCode.VALOR_MENOR_QUE_MINIMO, minVal, id);
        }

        Usuario usuario = usuarioDAO.find(id);

        if (usuario == null) {
            throw new SkepyException(KoppCode.VALOR_NULO);
        }

        return getMapper().map(usuario, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return getMapper().mapList(usuarioDAO.findAll(), UsuarioDTO.class);
    }

}
