package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class OrigemDaoHibernate extends KoppCrudDAOImpl<Origem> implements OrigemDao {

    public OrigemDaoHibernate() {
        super(Origem.class);
    }

}
