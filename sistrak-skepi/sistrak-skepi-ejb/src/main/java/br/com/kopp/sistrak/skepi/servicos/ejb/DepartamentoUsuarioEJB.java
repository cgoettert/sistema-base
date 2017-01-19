package br.com.kopp.sistrak.skepi.servicos.ejb;

import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.skepi.conversores.FabricaConversoresDto;
import br.com.kopp.sistrak.skepi.exception.SkepyException;
import br.com.kopp.sistrak.skepi.persistence.mybatis.dao.UsuarioDepartamentoMapper;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioDepartamento;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioDepartamentoExample;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.UsuarioDepartamentoLocal;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto.UsuarioDepartamentoDTO;
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
public class DepartamentoUsuarioEJB extends KoppEJB implements UsuarioDepartamentoLocal {

    @Inject
    @Mapper
    private UsuarioDepartamentoMapper mapper;

    @Override
    public List<UsuarioDepartamentoDTO> getAll() throws SkepyException {
        List<UsuarioDepartamento> lista = mapper.selectByExample(new UsuarioDepartamentoExample());

        return getMapper()
                .comFunction(FabricaConversoresDto.obterConversorUsuarioDepartamento())
                .converterLista(lista);
    }

    @Override
    public UsuarioDepartamentoDTO get(Integer obj) throws SkepyException {
        UsuarioDepartamento entity = mapper.selectByPrimaryKey(obj);

        return getMapper()
                .comFunction(FabricaConversoresDto.obterConversorUsuarioDepartamento())
                .converterObjeto(entity);
    }

    @Override
    @Transactional
    public void create(UsuarioDepartamentoDTO dto) throws SkepyException {
        
        UsuarioDepartamento record = new UsuarioDepartamento();
        record.setIdUsuarioOrigem(dto.getOrigem());
        record.setDescricao(dto.getDescricao());
        
        mapper.insert(record);
    }

    @Override
    public void update(UsuarioDepartamentoDTO dto) throws SkepyException {
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
