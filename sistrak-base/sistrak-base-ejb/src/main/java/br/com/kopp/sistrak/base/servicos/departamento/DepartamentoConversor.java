package br.com.kopp.sistrak.base.servicos.departamento;

import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class DepartamentoConversor {
    
    public static Function<Departamento, DepartamentoDto> obterConversorUsuarioDepartamento() {

        return (source) -> DepartamentoDto.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .origem(source.getUsuarioOrigem() == null ? null : source.getUsuarioOrigem().getId())
                .build();
    }
    
    public static Function<Departamento, DepartamentoListagemDto> obterConversorListagem() {

        return (source) -> DepartamentoListagemDto.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .usuarioOrigem(source.getUsuarioOrigem() == null ? "-" : source.getUsuarioOrigem().getDescricao())
                .build();
    }
}
