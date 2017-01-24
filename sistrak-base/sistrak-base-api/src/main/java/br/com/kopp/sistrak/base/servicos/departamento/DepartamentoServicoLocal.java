package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.framework.datatables.ResponseData;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;

/**
 *
 * @author cgoettert
 */
public interface DepartamentoServicoLocal {

    public ResponseData montarTabela(RequestData requestData) throws SkepyException;

    public DepartamentoDto get(Integer obj) throws SkepyException;

    public void create(DepartamentoDto dto) throws SkepyException;

    public void update(DepartamentoDto dto) throws SkepyException;

    public void delete(Integer obj) throws SkepyException;

}
