package br.com.kopp.sistrak.skepi.servicos.interfaces.origem;

import br.com.kopp.sistrak.skepi.exception.SkepyException;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.dto.OrigemUsuarioDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface OrigemUsuarioEJBLocal {

    public List<OrigemUsuarioDTO> combo() throws SkepyException;;
    
}
