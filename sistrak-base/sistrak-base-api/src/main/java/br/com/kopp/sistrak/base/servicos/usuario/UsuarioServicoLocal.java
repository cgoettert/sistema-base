package br.com.kopp.sistrak.base.servicos.usuario;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface UsuarioServicoLocal {

    public UsuarioDto get(Integer id) throws SkepyException;
    
    public Integer count() throws SkepyException;

    public List<UsuarioDto> getRange(RequestData requestData) throws SkepyException;
    
}
