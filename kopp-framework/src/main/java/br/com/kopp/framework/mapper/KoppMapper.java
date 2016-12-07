package br.com.kopp.framework.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface KoppMapper {
    
    public <U> U map(final Object source, final Class<U> destinationClass);
    
    public <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType);
    
}
