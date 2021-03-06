package br.com.kopp.framework.dao;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.framework.datatables.ResponseData;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public abstract class KoppCrudDAOJpa<T> extends KoppDAO<T> implements KoppCrudDAO<T> {

    private final Class<T> entityClass;

    public KoppCrudDAOJpa(Class<T> entityClass) {
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
    public ResponseData mountTable(RequestData requestData) {
        try {

            Long recordsTotal = this.count();
            Long recordsFiltered = this.countRange(requestData);
            List<T> listaBanco = this.findRange(requestData);
            return new ResponseData(requestData.getDraw(), recordsTotal, recordsFiltered, listaBanco);

        } catch (Exception ex) {
            return new ResponseData(ex.getLocalizedMessage());
        }
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        return getEntityManager().createQuery(cq).getResultList();
    }

    private List<T> findRange(RequestData requestData) {
        // TODO add filters e orderBy
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(requestData.getLength());
        q.setFirstResult(requestData.getStart());
        return q.getResultList();
    }

    private Long countRange(RequestData requestData) {
        // TODO add filters e orderBy
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(getEntityClass());
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return (Long) q.getSingleResult();
    }

    private Long count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(getEntityClass());
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return (Long) q.getSingleResult();
    }

}
