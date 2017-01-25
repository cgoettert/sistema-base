package br.com.kopp.sistrak.base.rest.servicos.departamento;

import br.com.kopp.framework.message.KoppMessage;
import java.util.Map;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import br.com.kopp.sistrak.base.comum.exception.SkepyException;
import br.com.kopp.sistrak.base.servicos.departamento.DepartamentoDto;
import br.com.kopp.sistrak.base.servicos.departamento.DepartamentoServicoLocal;

public class DepartamentoControllerTest extends JerseyTest {

    @Mock
    private DepartamentoServicoLocal departamentoLocal;
    
     @Mock
    private KoppMessage skepyMessage;

    @Override
    protected Application configure() {
        MockitoAnnotations.initMocks(this);

        return new ResourceConfig()
                .register(new DepartamentoController(departamentoLocal, skepyMessage));
    }

    @Test
    public void listTest() throws SkepyException {
        
    }

    @Test
    public void getId1Test() throws SkepyException {
       
    }

    private <T> T getFromResponse(Response response, String key) {
        @SuppressWarnings("rawtypes")
        Map map = response.readEntity(Map.class);
        @SuppressWarnings("unchecked")
        T obj = (T) map.get(key);

        return obj;
    }

    private DepartamentoDto gerarDto() {
        return DepartamentoDto.builder()
                .descricao("Financeiro")
                .origem(2)
                .build();
    }

}
