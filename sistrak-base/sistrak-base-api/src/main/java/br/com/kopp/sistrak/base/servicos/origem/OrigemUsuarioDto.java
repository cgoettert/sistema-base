package br.com.kopp.sistrak.base.servicos.origem;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class OrigemUsuarioDto {
    
    private final Integer id;
    private final String descricao;
    
}
