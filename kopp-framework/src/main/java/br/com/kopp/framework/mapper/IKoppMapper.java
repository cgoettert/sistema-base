package br.com.kopp.framework.mapper;

import java.util.function.Function;

/**
 *
 * @author cgoettert
 */
public interface IKoppMapper {

    <T, U> IKoppMapperComFunction<T, U> comFunction(Function<T, U> conversor); 
    
}
