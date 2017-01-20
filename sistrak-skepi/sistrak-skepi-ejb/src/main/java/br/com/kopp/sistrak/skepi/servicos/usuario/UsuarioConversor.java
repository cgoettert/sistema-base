package br.com.kopp.sistrak.skepi.servicos.usuario;

import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class UsuarioConversor {

    public static Function<Usuario, UsuarioDto> obterConversorUsuarioParaUsuarioDTO() {

        return (source) -> UsuarioDto.builder()
                .nome(source.getNome())
                .email(source.getEmail())
                .build();
    }
    
}
