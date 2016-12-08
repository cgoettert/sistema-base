package br.com.kopp.impl.mapper;

import br.com.kopp.framework.mapper.KoppMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class MapperDozer implements KoppMapper {

    @Override
    public <U> U map(final Object source, final Class<U> destinationClass) {
        return new DozerBeanMapper().map(source, destinationClass);
    };

    @Override
    public <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType) {
        final Mapper mapper = new DozerBeanMapper();
        final ArrayList<U> dest = new ArrayList<>();

        for (T element : source) {
            if (element == null) {
                continue;
            }
            dest.add(mapper.map(element, destType));
        }

        // finally remove all null values if any
        List s1 = new ArrayList();
        s1.add(null);
        dest.removeAll(s1);

        return dest;
    }

}
