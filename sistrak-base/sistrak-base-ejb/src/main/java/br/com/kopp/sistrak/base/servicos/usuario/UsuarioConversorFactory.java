package br.com.kopp.sistrak.base.servicos.usuario;

import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class UsuarioConversorFactory {

    public static Function<Usuario, UsuarioDto> criarConversorUsuarioDto() {

        return (source) -> UsuarioDto.builder()
                .nome(source.getNome())
                .email(source.getEmail())
                .build();
    }
    
}
