package br.com.kopp.sistrak.skepi.rest.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.FeedBuilder;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.OrigemUsuarioEJBLocal;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.dto.OrigemUsuarioDTO;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/origem-usuario")
@RequestScoped
public class OrigemResource {

    private OrigemUsuarioEJBLocal ejb;
    private MessageBundle skepyMessage;

    // só funciona com esse construtor
    public OrigemResource() {
    }

    @Inject
    public OrigemResource(OrigemUsuarioEJBLocal ejb, MessageBundle skepyMessage) {
        this.ejb = ejb;
        this.skepyMessage = skepyMessage;
    }

    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("combo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response combo() {

        List<OrigemUsuarioDTO> list;

        try {
            list = ejb.combo();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }

        FeedBuilder fb = FeedBuilder.create().add(list);

        return fb.build();
    }

}
