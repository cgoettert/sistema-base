package br.com.kopp.framework.dao;

import br.com.kopp.framework.datatables.RequestData;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public abstract class KoppCrudDAOImpl<T> extends KoppDAO<T> implements KoppCrudDAO<T> {

    private final Class<T> entityClass;
    
    public KoppCrudDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected Class<T> getEntityClass() {
        return this.entityClass;
    }

    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T find(Object id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<T> findRange(RequestData requestData) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(requestData.getLength());
        q.setFirstResult(requestData.getStart());
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(getEntityClass());
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
