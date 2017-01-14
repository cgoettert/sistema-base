package br.com.kopp.sistrak.skepi.conversores;

import java.util.function.Function;

import br.com.kopp.sistrak.skepi.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.Usuario;

/**
 * Fábrica de conversores de Entidade para DTO
 * 
 * @author Leandro
 */
public final class FabricaConversoresDto {
    
    public static Function<Usuario, UsuarioDTO> obterConversorUsuarioParaUsuarioDTO() {
        
        return (source) -> UsuarioDTO.builder()
                .nome(source.getNome())
                .email(source.getEmail())
                .build();
    }
}
