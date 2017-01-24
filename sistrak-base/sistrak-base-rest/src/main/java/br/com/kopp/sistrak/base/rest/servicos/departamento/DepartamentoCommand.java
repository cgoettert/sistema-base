/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.sistrak.base.rest.servicos.departamento;

import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Data
class DepartamentoCommand {
    
    private String descricao;
    private Integer usuarioOrigem;
    
}
