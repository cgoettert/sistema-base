package br.com.kopp.ejb;

import br.com.kopp.api.UsuarioEJBLocal;
import br.com.kopp.api.UsuarioEJBRemote;
import br.com.kopp.dao.UsuarioDAO;
import br.com.kopp.model.Usuario;
import br.com.kopp.dto.UsuarioDTO;
import br.com.kopp.util.DozerUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal, UsuarioEJBRemote {

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
