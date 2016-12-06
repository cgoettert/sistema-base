package br.com.kopp.util;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author cgoettert
 */
public class DozerUtil {

    public static <U> U map(final Object source, final Class<U> destinationClass) {
        return new DozerBeanMapper().map(source, destinationClass);
    };

    public static <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType) {
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
