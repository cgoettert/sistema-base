package br.com.kopp.sistrak.base.rest.servicos.origem;

import br.com.kopp.framework.controller.KoppController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.sistrak.base.servicos.origem.OrigemServicoLocal;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/origem-usuario")
@RequestScoped
public class OrigemController extends KoppController {

    private OrigemServicoLocal ejb;

    // só funciona com esse construtor
    public OrigemController() {
    }

    @Inject
    public OrigemController(OrigemServicoLocal ejb, MessageBundle message) {
        super(message);
        this.ejb = ejb;
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

        try {
            addData(ejb.combo());
        } catch (KoppException ex) {
            addError(ex);
        }

        return build();
    }

}
