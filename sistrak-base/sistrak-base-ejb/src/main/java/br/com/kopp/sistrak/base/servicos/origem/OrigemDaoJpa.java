package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class OrigemDaoJpa extends KoppCrudDAOImpl<Origem> implements OrigemDao {

    public OrigemDaoJpa() {
        super(Origem.class);
    }

}
