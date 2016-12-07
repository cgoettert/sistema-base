package br.com.kopp.sistrak.skepi.servicos.interfaces;

import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
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
