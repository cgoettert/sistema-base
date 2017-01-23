package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import java.util.List;

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
    public List<DepartamentoDto> getAll() throws SkepyException {
        List<Departamento> lista = usuarioDepartamentoDao.findAll();
        
        return getMapper()
                .comFunction(DepartamentoConversor.obterConversorUsuarioDepartamento())
                .converterLista(lista);
    }
    
    @Override
    public DepartamentoDto get(Integer obj) throws SkepyException {
        Departamento entity = usuarioDepartamentoDao.find(obj);
        
        return getMapper()
                .comFunction(DepartamentoConversor.obterConversorUsuarioDepartamento())
                .converterObjeto(entity);
    }
    
    @Override
    @Transactional
    public void create(DepartamentoDto dto) throws SkepyException {
        
        Departamento record = new Departamento();
        record.setId(dto.getOrigem());
        record.setDescricao(dto.getDescricao());
        
        usuarioDepartamentoDao.create(record);
    }
    
    @Override
    public void update(DepartamentoDto dto) throws SkepyException {
        Departamento record = new Departamento();
        record.setId(dto.getId());
        record.setId(dto.getOrigem());
        record.setDescricao(dto.getDescricao());
        
        usuarioDepartamentoDao.edit(record);
    }
    
    @Override
    public void delete(Integer obj) throws SkepyException {
        usuarioDepartamentoDao.remove(new Departamento(obj));
    }

}
