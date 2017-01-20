package br.com.kopp.sistrak.skepi.servicos.departamento;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class DepartamentoDto {
    
    private final Integer id;
    private final String descricao;
    private final Integer origem;
    
}
