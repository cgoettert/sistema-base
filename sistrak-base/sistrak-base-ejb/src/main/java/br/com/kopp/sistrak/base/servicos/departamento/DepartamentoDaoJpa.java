package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class DepartamentoDaoJpa extends KoppCrudDAOImpl<Departamento> implements DepartamentoDao {

    public DepartamentoDaoJpa() {
        super(Departamento.class);
    }

}
