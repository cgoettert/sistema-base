package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.framework.datatables.ResponseData;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import br.com.kopp.sistrak.base.servicos.origem.Origem;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author cgoettert
 */
@Stateless
public class DepartamentoServicoEjb extends KoppEJB implements DepartamentoServicoLocal {

    @Inject
    private DepartamentoDao usuarioDepartamentoDao;

    @Override
    public ResponseData montarTabela(RequestData requestData) throws SkepyException {

        ResponseData responseData = usuarioDepartamentoDao.mountTable(requestData);

        responseData.setData(getMapper()
                .comFunction(DepartamentoConversorFactory.obterConversorDepartamentoListagemDto())
                .converterLista(responseData.getData()));

        return responseData;
    }

    @Override
    public DepartamentoDto get(Integer obj) throws SkepyException {
        Departamento entity = usuarioDepartamentoDao.find(obj);

        return getMapper()
                .comFunction(DepartamentoConversorFactory.criarConversorDepartamentoDto())
                .converterObjeto(entity);
    }

    @Override
    @Transactional
    public void create(DepartamentoDto dto) throws SkepyException {

        Departamento record = new Departamento();

        record.setDescricao(dto.getDescricao());
        record.setUsuarioOrigem(new Origem(dto.getOrigem()));

        usuarioDepartamentoDao.create(record);
    }

    @Override
    public void update(DepartamentoDto dto) throws SkepyException {
        Departamento record = new Departamento();
        record.setId(dto.getId());
        record.setDescricao(dto.getDescricao());
        record.setUsuarioOrigem(new Origem(dto.getOrigem()));

        usuarioDepartamentoDao.edit(record);
    }

    @Override
    public void delete(Integer obj) throws SkepyException {
        usuarioDepartamentoDao.remove(new Departamento(obj));
    }

}
