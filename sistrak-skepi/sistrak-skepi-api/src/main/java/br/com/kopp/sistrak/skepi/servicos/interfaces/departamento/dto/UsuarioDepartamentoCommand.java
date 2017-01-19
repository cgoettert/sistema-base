/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto;

import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Data
public class UsuarioDepartamentoCommand {
    
    private String descricao;
    private Integer origem;

}
