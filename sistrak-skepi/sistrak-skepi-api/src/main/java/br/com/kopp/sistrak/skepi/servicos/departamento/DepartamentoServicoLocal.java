package br.com.kopp.sistrak.skepi.servicos.departamento;

import br.com.kopp.sistrak.skepi.comum.exception.SkepyException;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface DepartamentoServicoLocal {

    public DepartamentoDto get(Integer obj) throws SkepyException;
    
    public List<DepartamentoDto> getAll() throws SkepyException;
    
    public void create(DepartamentoDto dto) throws SkepyException;

    public void update(DepartamentoDto dto) throws SkepyException;

    public void delete(Integer obj) throws SkepyException;
    
    

}
