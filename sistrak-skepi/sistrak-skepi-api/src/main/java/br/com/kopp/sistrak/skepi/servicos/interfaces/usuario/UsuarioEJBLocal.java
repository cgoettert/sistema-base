package br.com.kopp.sistrak.skepi.servicos.interfaces.usuario;

import br.com.kopp.sistrak.skepi.servicos.interfaces.usuario.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.exception.SkepyException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface UsuarioEJBLocal {

    public UsuarioDTO get(Integer id) throws SkepyException;
    
    public Integer count() throws SkepyException;;

    public List<UsuarioDTO> getAll() throws SkepyException;;
    
}
