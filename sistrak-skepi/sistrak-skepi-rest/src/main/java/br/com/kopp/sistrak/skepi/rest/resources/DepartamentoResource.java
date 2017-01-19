package br.com.kopp.sistrak.skepi.rest.resources;

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
import br.com.kopp.framework.message.code.KoppCode;
import br.com.kopp.sistrak.skepi.message.SkepyCode;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.UsuarioDepartamentoLocal;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto.UsuarioDepartamentoCommand;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto.UsuarioDepartamentoDTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/departamento-usuario")
@RequestScoped
public class DepartamentoResource {

    private UsuarioDepartamentoLocal ejb;
    private MessageBundle skepyMessage;

    // só funciona com esse construtor
    public DepartamentoResource() {
    }

    @Inject
    public DepartamentoResource(UsuarioDepartamentoLocal ejb, MessageBundle skepyMessage) {
        this.ejb = ejb;
        this.skepyMessage = skepyMessage;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<UsuarioDepartamentoDTO> list;

        try {
            list = ejb.getAll();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
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
        UsuarioDepartamentoDTO obj;

        try {
            obj = ejb.get(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }
        return FeedBuilder.create()
                .add(obj)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UsuarioDepartamentoCommand command) {

        UsuarioDepartamentoDTO input = UsuarioDepartamentoDTO.builder()
                .descricao(command.getDescricao())
                .origem(command.getOrigem())
                .build();

        try {
            ejb.create(input);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UsuarioDepartamentoDTO input) {

        try {
            ejb.update(input);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }

    @DELETE
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {

        try {
            ejb.delete(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }

        return FeedBuilder.create().build();
    }
}
