package br.com.kopp.sistrak.base.rest.servicos.origem;

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
import br.com.kopp.sistrak.base.servicos.origem.OrigemDto;
import br.com.kopp.sistrak.base.servicos.origem.OrigemServicoLocal;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/origem-usuario")
@RequestScoped
public class OrigemController {

    private OrigemServicoLocal ejb;
    private MessageBundle message;

    // só funciona com esse construtor
    public OrigemController() {
    }

    @Inject
    public OrigemController(OrigemServicoLocal ejb, MessageBundle skepyMessage) {
        this.ejb = ejb;
        this.message = skepyMessage;
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

        List<OrigemDto> list;

        try {
            list = ejb.combo();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }

        FeedBuilder fb = FeedBuilder.create().add(list);

        return fb.build();
    }

}
