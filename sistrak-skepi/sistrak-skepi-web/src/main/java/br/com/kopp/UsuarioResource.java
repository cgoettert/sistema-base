/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp;

import br.com.kopp.ejb.UsuarioEJBLocal;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cgoettert
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    @EJB
    UsuarioEJBLocal usuarioEJB;
    
    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
        return Response.ok().build();
    }
    
    /**
     * Retrieves representation of an instance of br.com.kopp.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        return Response.ok(usuarioEJB.count()).build();
    }

}
