package br.com.kopp.sistrak.base.rest.servicos.usuario;

import br.com.kopp.framework.controller.KoppController;
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
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.sistrak.base.servicos.usuario.UsuarioDto;
import br.com.kopp.sistrak.base.servicos.usuario.UsuarioServicoLocal;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("basico/administracao/usuario")
@RequestScoped
public class UsuarioController extends KoppController {

    private UsuarioServicoLocal usuarioLocal;

    // só funciona com esse construtor
    public UsuarioController() {
    }

    @Inject
    public UsuarioController(UsuarioServicoLocal usuarioLocal, MessageBundle message) {
        super(message);
        this.usuarioLocal = usuarioLocal;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("request") RequestData request) {

        try {
            addData(usuarioLocal.montarTabela(request));
        } catch (KoppException ex) {
            addError(ex);
        }

        return build();
    }

    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {

        try {
            UsuarioDto usuario = usuarioLocal.get(id);
            addData(usuario);
        } catch (KoppException ex) {
            addError(ex);
        }

        return build();
    }

}
