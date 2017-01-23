package br.com.kopp.sistrak.base.servicos.origem;

import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class UsuarioOrigemConversor {
    
    public static Function<UsuarioOrigem, OrigemUsuarioDto> obterConversorUsuarioOrigem() {

        return (source) -> OrigemUsuarioDto.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .build();
    }

}
