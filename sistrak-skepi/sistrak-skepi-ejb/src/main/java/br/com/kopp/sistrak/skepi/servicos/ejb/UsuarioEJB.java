package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.framework.code.PagamentoCode;
import br.com.kopp.framework.code.ValidacaoCode;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.exception.ValidacaoException;
import br.com.kopp.sistrak.skepi.servicos.interfaces.UsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.dao.UsuarioDAO;
import br.com.kopp.sistrak.skepi.model.Usuario;
import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
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
    public UsuarioDTO get(Integer id) throws KoppException {
        int minVal = 0;
        
        if (id < minVal) {
            throw new ValidacaoException(ValidacaoCode.VALOR_MENOR_QUE_MINIMO, minVal, id);
        }

        Usuario usuario = usuarioDAO.find(id);
        return getMapper().map(usuario, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return getMapper().mapList(usuarioDAO.findAll(), UsuarioDTO.class);
    }

}
