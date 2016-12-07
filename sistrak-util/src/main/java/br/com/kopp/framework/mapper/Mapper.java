/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.framework.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface Mapper {
    
    public <U> U map(final Object source, final Class<U> destinationClass);
    
    public <T, U> ArrayList<U> mapList(final List<T> source, final Class<U> destType);
    
}
