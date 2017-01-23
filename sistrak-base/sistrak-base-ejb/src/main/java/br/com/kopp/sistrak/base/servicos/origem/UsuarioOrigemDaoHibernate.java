package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioOrigemDaoHibernate extends KoppCrudDAOImpl<UsuarioOrigem> implements UsuarioOrigemDao {

    public UsuarioOrigemDaoHibernate() {
        super(UsuarioOrigem.class);
    }

}
