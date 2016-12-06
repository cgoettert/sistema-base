/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.ejb;

import br.com.kopp.sistrak.model.Usuario;
import javax.ejb.Local;

/**
 *
 * @author cgoettert
 */
@Local
public interface UsuarioEJBLocal {

    public Usuario get(Integer id);
    
    public Integer count();
    
}
