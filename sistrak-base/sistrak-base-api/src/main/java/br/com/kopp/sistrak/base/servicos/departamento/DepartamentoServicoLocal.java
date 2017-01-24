package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface DepartamentoServicoLocal {

    public List<DepartamentoListagemDto> getRange(RequestData requestData) throws SkepyException;

    public Integer count() throws SkepyException;

    public DepartamentoDto get(Integer obj) throws SkepyException;

    public void create(DepartamentoDto dto) throws SkepyException;

    public void update(DepartamentoDto dto) throws SkepyException;

    public void delete(Integer obj) throws SkepyException;

}
