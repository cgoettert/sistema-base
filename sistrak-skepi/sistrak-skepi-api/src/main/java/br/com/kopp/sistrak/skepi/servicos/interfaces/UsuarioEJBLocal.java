package br.com.kopp.sistrak.skepi.servicos.interfaces;

import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface UsuarioEJBLocal {

    public UsuarioDTO get(Integer id);
    
    public Integer count();

    List<UsuarioDTO> getAll();
    
}
