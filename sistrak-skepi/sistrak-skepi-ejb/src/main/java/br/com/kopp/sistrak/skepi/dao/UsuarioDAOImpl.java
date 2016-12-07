package br.com.kopp.sistrak.skepi.dao;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import br.com.kopp.sistrak.skepi.model.Usuario;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class UsuarioDAOImpl extends KoppCrudDAOImpl<Usuario> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }
    
}
