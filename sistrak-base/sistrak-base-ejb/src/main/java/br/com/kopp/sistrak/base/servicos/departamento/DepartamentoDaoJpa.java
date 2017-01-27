package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.dao.KoppCrudDAOJpa;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class DepartamentoDaoJpa extends KoppCrudDAOJpa<Departamento> implements DepartamentoDao {

    public DepartamentoDaoJpa() {
        super(Departamento.class);
    }

}
