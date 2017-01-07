package br.com.kopp.sistrak.skepi.rest;

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
import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.message.SkepyCode;
import br.com.kopp.sistrak.skepi.servicos.interfaces.UsuarioEJBLocal;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    private UsuarioEJBLocal usuarioLocal;
    private MessageBundle skepyMessage;

    // só funciona com esse construtor
    public UsuarioResource(){}
    
    @Inject
    public UsuarioResource(UsuarioEJBLocal usuarioLocal, MessageBundle skepyMessage) {
    	this.usuarioLocal = usuarioLocal;
    	this.skepyMessage = skepyMessage;
    }
    
    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<UsuarioDTO> usuarios;

        try {
            usuarios = usuarioLocal.getAll();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }

        FeedBuilder fb = FeedBuilder.create()
                .add(skepyMessage.getText(SkepyCode.MENSAGEM1))
                .add(skepyMessage.getText(KoppCode.FORMATO_INVALIDO))
                .add("usuarios", usuarios);

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
        UsuarioDTO usuario;

        try {
            usuario = usuarioLocal.get(id);
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }
        return FeedBuilder.create()
                .add(usuario)
                .build();
    }

    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {

        Integer count;

        try {
            count = usuarioLocal.count();
        } catch (KoppException ex) {
            return FeedBuilder.create()
                    .add(skepyMessage.getText(ex))
                    .build();
        }
        return FeedBuilder.create()
                .add(count)
                .build();
    }
}
