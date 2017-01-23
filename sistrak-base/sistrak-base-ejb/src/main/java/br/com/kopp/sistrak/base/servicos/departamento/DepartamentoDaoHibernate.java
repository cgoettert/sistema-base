package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class DepartamentoDaoHibernate extends KoppCrudDAOImpl<Departamento> implements DepartamentoDao {

    public DepartamentoDaoHibernate() {
        super(Departamento.class);
    }

}
