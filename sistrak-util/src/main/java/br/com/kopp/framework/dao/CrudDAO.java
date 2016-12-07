package br.com.kopp.framework.dao;

import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface CrudDAO<T> {

    void create(T obj);

    void edit(T obj);

    void remove(T obj);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
}
