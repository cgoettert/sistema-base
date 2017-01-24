package br.com.kopp.sistrak.base.servicos.departamento;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cgoettert
 */
@Builder
@Data
public class DepartamentoListagemDto {
    
    private final Integer id;
    private final String descricao;
    private final String usuarioOrigem;
    
}
