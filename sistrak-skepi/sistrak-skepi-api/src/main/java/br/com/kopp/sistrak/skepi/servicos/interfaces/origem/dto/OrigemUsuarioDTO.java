package br.com.kopp.sistrak.skepi.servicos.interfaces.origem.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class OrigemUsuarioDTO {
    
    private final Integer id;
    private final String descricao;
    
}
