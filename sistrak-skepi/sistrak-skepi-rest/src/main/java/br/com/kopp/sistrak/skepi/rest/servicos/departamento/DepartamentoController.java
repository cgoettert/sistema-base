package br.com.kopp.sistrak.skepi.rest.servicos.departamento;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.FeedBuilder;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.sistrak.skepi.servicos.departamento.DepartamentoDto;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import br.com.kopp.sistrak.skepi.servicos.departamento.DepartamentoServicoLocal;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/departamento-usuario")
@RequestScoped
public class DepartamentoController {

    private DepartamentoServicoLocal servico;
    private MessageBundle message;

    // só funciona com esse construtor
    public DepartamentoController() {
    }

    @Inject
    public DepartamentoController(DepartamentoServicoLocal ejb, MessageBundle skepyMessage) {
        this.servico = ejb;
        this.message = skepyMessage;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<DepartamentoDto> list;

        try {
            list = servico.getAll();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }

        FeedBuilder fb = FeedBuilder.create()
                .add(list);

        return fb.build();
    }

    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        DepartamentoDto obj;

        try {
            obj = servico.get(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }
        return FeedBuilder.create()
                .add(obj)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(DepartamentoCommand command) {

        DepartamentoDto input = DepartamentoDto.builder()
                .descricao(command.getDescricao())
                .origem(command.getOrigem())
                .build();

        try {
            servico.create(input);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }

    @PUT
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, DepartamentoCommand command) {

        DepartamentoDto input = DepartamentoDto.builder()
                .id(id)
                .descricao(command.getDescricao())
                .origem(command.getOrigem())
                .build();

        try {
            servico.update(input);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }

    @DELETE
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {

        try {
            servico.delete(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }
}
