package br.com.kopp.impl.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.RequestScoped;

import br.com.kopp.framework.mapper.FunctionMapper;
import br.com.kopp.framework.mapper.KoppMapper;

/**
 *
 * @author cgoettert
 */
@RequestScoped
@FunctionMapper
public class MapperFunction implements KoppMapper {

    @Override
    public <T,U> U map(final T source, final Class<U> destinationClass, Function<T, U> fun) {
        return fun.apply(source);
    }

    @Override
    public <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType, Function<T, U> fun) {
        final ArrayList<U> dest = new ArrayList<>();

        for (T element : source) {
            if (element == null) {
                continue;
            }
            dest.add(fun.apply(element));
        }

        // finally remove all null values if any
        List<T> s1 = new ArrayList<T>();
        s1.add(null);
        dest.removeAll(s1);

        return dest;
    }
}
