/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.sistrak.skepi.dao;

import br.com.kopp.sistrak.skepi.model.Usuario;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public interface UsuarioDAO {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
