/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.sistrak.skepi.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class UsuarioDTO {
    
    private final String nome;
    private final String email;

}
