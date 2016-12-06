package br.com.kopp.api;

import br.com.kopp.dto.UsuarioDTO;
import javax.ejb.Remote;

/**
 *
 * @author cgoettert
 */
@Remote
public interface UsuarioEJBRemote {

    public UsuarioDTO get(Integer id);
    
    public Integer count();
    
}
