package br.com.kopp.framework.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cgoettert
 */
public abstract class DAOImpl<T> {

    @PersistenceContext
    private EntityManager em;

    private final Class<T> entityClass;

    public DAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    protected Class<T> getEntityClass() {
        return this.entityClass;
    }

}
