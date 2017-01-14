package br.com.kopp.framework.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cgoettert
 */
public abstract class KoppDAO<T> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

}
