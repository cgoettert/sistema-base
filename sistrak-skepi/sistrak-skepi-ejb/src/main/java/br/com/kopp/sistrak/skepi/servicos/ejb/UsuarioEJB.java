package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.sistrak.skepi.servicos.interfaces.UsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.dao.UsuarioDAO;
import br.com.kopp.sistrak.skepi.model.Usuario;
import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import br.com.kopp.util.ejb.DozerUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Integer count() {
        return usuarioDAO.count();
    }

    @Override
    public UsuarioDTO get(Integer id) {
        Usuario usuario = usuarioDAO.find(id);
        return DozerUtil.map(usuario, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return DozerUtil.mapList(usuarioDAO.findAll(), UsuarioDTO.class);
    }
    
}
