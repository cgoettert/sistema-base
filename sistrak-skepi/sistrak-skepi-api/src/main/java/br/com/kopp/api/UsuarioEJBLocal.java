package br.com.kopp.api;

import br.com.kopp.dto.UsuarioDTO;
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
