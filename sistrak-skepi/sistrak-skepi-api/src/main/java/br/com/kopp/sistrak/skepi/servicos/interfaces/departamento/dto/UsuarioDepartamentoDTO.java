package br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class UsuarioDepartamentoDTO {
    
    private final Integer id;
    private final String descricao;
    private final Integer origem;
    
}
