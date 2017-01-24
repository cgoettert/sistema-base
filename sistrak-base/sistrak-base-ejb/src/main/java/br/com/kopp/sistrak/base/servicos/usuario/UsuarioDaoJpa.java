package br.com.kopp.sistrak.base.servicos.usuario;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioDaoJpa extends KoppCrudDAOImpl<Usuario> implements UsuarioDao {

    public UsuarioDaoJpa() {
        super(Usuario.class);
    }

}
