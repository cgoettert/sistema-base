package br.com.kopp.framework.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.RequestScoped;

public class KoppMapper implements IKoppMapper {

    @Override
    public <T, U> IKoppMapperComFunction<T, U> comFunction(Function<T, U> conversor) {
        return new KoppMapperComFunction<>(conversor);
    }

    public class KoppMapperComFunction<T, U> implements IKoppMapperComFunction<T, U> {
        
        private Function<T, U> conversor;
        
        private KoppMapperComFunction(Function<T, U> conversor) {
            this.conversor = conversor;
        }
        
        @Override
        public U converterObjeto(T source) {
            return conversor.apply(source);
        }

        @Override
        public List<U> converterLista(List<T> source) {
            if (source == null) {
                return null;
            }
            
            List<U> lista = new ArrayList<>();
            for (T item : source) {
                lista.add(converterObjeto(item));
            }
            return lista;
        }
        
    }
}
