package br.com.kopp.dao;

import br.com.kopp.sistrak.model.Usuario;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }
    
}
