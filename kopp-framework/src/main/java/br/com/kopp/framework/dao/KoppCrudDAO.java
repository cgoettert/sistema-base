package br.com.kopp.framework.dao;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.framework.datatables.ResponseData;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface KoppCrudDAO<T> {

    void create(T obj);

    void edit(T obj);

    void remove(T obj);

    T find(Object id);

    List<T> findAll();

    ResponseData mountTable(RequestData requestData);

}
