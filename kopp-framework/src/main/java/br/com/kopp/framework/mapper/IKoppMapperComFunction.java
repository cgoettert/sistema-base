package br.com.kopp.framework.mapper;

import java.util.List;

/**
 * Interface que define os métodos para mapear objetos de um tipo
 * <code>&lt;T&gt;</code> para objetos do tipo <code>&lt;U&gt;</code>.
 *
 * @param <T> Tipo do objeto de entrada.
 * @param <U> Tipo do objeto de saída (convertido).
 * 
 * @author Leandro Neumann
 */
public interface IKoppMapperComFunction<T, U> {

    U converterObjeto(final T source);
    
    List<U> converterLista(final List<T> source);
    
}
