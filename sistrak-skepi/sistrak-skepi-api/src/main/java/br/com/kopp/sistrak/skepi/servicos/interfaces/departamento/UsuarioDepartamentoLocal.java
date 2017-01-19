package br.com.kopp.sistrak.skepi.servicos.interfaces.departamento;

import br.com.kopp.sistrak.skepi.exception.SkepyException;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto.UsuarioDepartamentoDTO;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface UsuarioDepartamentoLocal {

    public UsuarioDepartamentoDTO get(Integer obj) throws SkepyException;
    
    public List<UsuarioDepartamentoDTO> getAll() throws SkepyException;
    
    public void create(UsuarioDepartamentoDTO dto) throws SkepyException;

    public void update(UsuarioDepartamentoDTO dto) throws SkepyException;

    public void delete(Integer obj) throws SkepyException;
    
    

}
