package br.com.kopp.sistrak.skepi.servicos.origem;

import br.com.kopp.sistrak.skepi.comum.exception.SkepyException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface OrigemServicoLocal {

    public List<OrigemUsuarioDto> combo() throws SkepyException;;
    
}
