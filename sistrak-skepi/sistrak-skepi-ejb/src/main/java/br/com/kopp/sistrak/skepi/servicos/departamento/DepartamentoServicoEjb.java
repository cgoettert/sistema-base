package br.com.kopp.sistrak.skepi.servicos.departamento;

import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.comum.exception.SkepyException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import org.mybatis.cdi.Transactional;

/**
 *
 * @author cgoettert
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN) 
public class DepartamentoServicoEjb extends KoppEJB implements DepartamentoServicoLocal {

    @Inject
    @Mapper
    private UsuarioDepartamentoMapper mapper;

    @Override
    public List<DepartamentoDto> getAll() throws SkepyException {
        List<UsuarioDepartamento> lista = mapper.selectByExample(new UsuarioDepartamentoExample());

        return getMapper()
                .comFunction(UsuarioDepartamentoConversor.obterConversorUsuarioDepartamento())
                .converterLista(lista);
    }

    @Override
    public DepartamentoDto get(Integer obj) throws SkepyException {
        UsuarioDepartamento entity = mapper.selectByPrimaryKey(obj);

        return getMapper()
                .comFunction(UsuarioDepartamentoConversor.obterConversorUsuarioDepartamento())
                .converterObjeto(entity);
    }

    @Override
    @Transactional
    public void create(DepartamentoDto dto) throws SkepyException {
        
        UsuarioDepartamento record = new UsuarioDepartamento();
        record.setIdUsuarioOrigem(dto.getOrigem());
        record.setDescricao(dto.getDescricao());
        
        mapper.insert(record);
    }

    @Override
    public void update(DepartamentoDto dto) throws SkepyException {
        UsuarioDepartamento record = new UsuarioDepartamento();
        record.setId(dto.getId());
        record.setIdUsuarioOrigem(dto.getOrigem());
        record.setDescricao(dto.getDescricao());
        
        mapper.updateByPrimaryKey(record);
    }

    @Override
    public void delete(Integer obj) throws SkepyException {
        mapper.deleteByPrimaryKey(obj);
    }

}
