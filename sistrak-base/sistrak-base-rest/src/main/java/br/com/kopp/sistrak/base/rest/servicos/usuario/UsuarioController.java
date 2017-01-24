package br.com.kopp.sistrak.base.rest.servicos.usuario;

import br.com.kopp.framework.datatables.RequestData;
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
public class UsuarioController {

    private UsuarioServicoLocal usuarioLocal;
    private MessageBundle message;

    // só funciona com esse construtor
    public UsuarioController() {
    }

    @Inject
    public UsuarioController(UsuarioServicoLocal usuarioLocal, MessageBundle message) {
        this.usuarioLocal = usuarioLocal;
        this.message = message;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("request") RequestData request) {

        FeedBuilder fb = FeedBuilder.create();

        try {
            fb.add(usuarioLocal.montarTabela(request));
        } catch (KoppException ex) {
            fb.add(message.getText(ex));
        }

        return fb.build();
    }

    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        UsuarioDto usuario;

        try {
            usuario = usuarioLocal.get(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(message.getText(ex))
                    .build();
        }
        return FeedBuilder.create()
                .add(usuario)
                .build();
    }

}
