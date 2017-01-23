package br.com.kopp.sistrak.base.servicos.origem;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class OrigemDto {
    
    private final Integer id;
    private final String descricao;
    
}
