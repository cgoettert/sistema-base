package br.com.kopp.sistrak.base.servicos.usuario;

import br.com.kopp.framework.dao.KoppCrudDAOJpa;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioDaoJpa extends KoppCrudDAOJpa<Usuario> implements UsuarioDao {

    public UsuarioDaoJpa() {
        super(Usuario.class);
    }

}
