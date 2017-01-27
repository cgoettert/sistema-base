package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.framework.dao.KoppCrudDAOJpa;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class OrigemDaoJpa extends KoppCrudDAOJpa<Origem> implements OrigemDao {

    public OrigemDaoJpa() {
        super(Origem.class);
    }

}
