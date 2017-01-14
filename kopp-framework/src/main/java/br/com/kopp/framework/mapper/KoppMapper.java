package br.com.kopp.framework.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author cgoettert
 */
public interface KoppMapper {
    
    public <T, U> U map(final T source, final Class<U> destinationClass, Function<T, U> fun);
    
    public <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType, Function<T, U> fun);
    
}
