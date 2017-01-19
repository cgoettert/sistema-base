package br.com.kopp.sistrak.skepi.conversores;

import java.util.function.Function;

import br.com.kopp.sistrak.skepi.servicos.interfaces.usuario.dto.UsuarioDTO;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.Usuario;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioDepartamento;
import br.com.kopp.sistrak.skepi.persistence.mybatis.model.UsuarioOrigem;
import br.com.kopp.sistrak.skepi.servicos.interfaces.departamento.dto.UsuarioDepartamentoDTO;
import br.com.kopp.sistrak.skepi.servicos.interfaces.origem.dto.OrigemUsuarioDTO;

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
    
    public static Function<UsuarioOrigem, OrigemUsuarioDTO> obterConversorUsuarioOrigem() {

        return (source) -> OrigemUsuarioDTO.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .build();
    }
    
    public static Function<UsuarioDepartamento, UsuarioDepartamentoDTO> obterConversorUsuarioDepartamento() {

        return (source) -> UsuarioDepartamentoDTO.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .origem(source.getIdUsuarioOrigem())
                .build();
    }
}
