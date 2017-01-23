package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.framework.dao.KoppCrudDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioDepartamentoDaoHibernate extends KoppCrudDAOImpl<UsuarioDepartamento> implements UsuarioDepartamentoDao {

    public UsuarioDepartamentoDaoHibernate() {
        super(UsuarioDepartamento.class);
    }

}
