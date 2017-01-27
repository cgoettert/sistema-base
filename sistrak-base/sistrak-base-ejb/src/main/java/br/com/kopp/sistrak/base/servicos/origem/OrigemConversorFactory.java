package br.com.kopp.sistrak.base.servicos.origem;

import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class OrigemConversorFactory {
    
    public static Function<Origem, OrigemDto> criarConversorOrigemDto() {

        return (source) -> OrigemDto.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .build();
    }

}
