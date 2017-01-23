package br.com.kopp.sistrak.base.servicos.usuario;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioDaoHibernate extends KoppCrudDAOImpl<Usuario> implements UsuarioDao {

    public UsuarioDaoHibernate() {
        super(Usuario.class);
    }

}
