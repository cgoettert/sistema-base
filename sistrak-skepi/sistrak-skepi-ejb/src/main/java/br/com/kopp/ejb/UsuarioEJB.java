/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.ejb;

import br.com.kopp.dao.UsuarioDAO;
import br.com.kopp.sistrak.model.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Override
    public Integer count() {
        return usuarioDAO.count();
    }

    @Override
    public Usuario get(Integer id) {
        return usuarioDAO.find(id);
    }
    
}
