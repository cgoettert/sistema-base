package br.com.kopp.sistrak.base.rest.servicos.departamento;

import br.com.kopp.framework.datatables.RequestData;

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
import br.com.kopp.sistrak.base.comum.message.SkepyCode;
import br.com.kopp.sistrak.base.servicos.departamento.DepartamentoDto;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import br.com.kopp.sistrak.base.servicos.departamento.DepartamentoServicoLocal;
import javax.ws.rs.QueryParam;

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
    public Response get(@QueryParam("request") RequestData request) {

        FeedBuilder fb = FeedBuilder.create();

        try {
            fb.add(servico.montarTabela(request));
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }

    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {

        FeedBuilder fb = FeedBuilder.create();

        try {
            DepartamentoDto obj = servico.get(id);
            fb.add(obj);
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(DepartamentoCommand command) {

        FeedBuilder fb = FeedBuilder.create();

        DepartamentoDto input = DepartamentoDto.builder()
                .descricao(command.getDescricao())
                .origem(command.getUsuarioOrigem())
                .build();

        try {
            servico.create(input);
            fb.add(message.getText(SkepyCode.MS0002));
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }

    @PUT
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Integer id, DepartamentoCommand command) {

        FeedBuilder fb = FeedBuilder.create();

        DepartamentoDto input = DepartamentoDto.builder()
                .build();

        try {
            servico.update(input);
            fb.add(message.getText(SkepyCode.MS0003));
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }

    @DELETE
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {

        FeedBuilder fb = FeedBuilder.create();

        try {
            servico.delete(id);
            fb.add(message.getText(SkepyCode.MS0004));
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }
}
