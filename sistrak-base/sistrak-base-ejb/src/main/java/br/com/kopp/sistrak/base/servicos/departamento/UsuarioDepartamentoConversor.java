package br.com.kopp.sistrak.base.servicos.departamento;

import br.com.kopp.sistrak.base.servicos.departamento.DepartamentoDto;
import java.util.function.Function;


/**
 * Fábrica de conversores de Entidade para DTO
 *
 * @author Leandro
 */
final class UsuarioDepartamentoConversor {
    
    public static Function<UsuarioDepartamento, DepartamentoDto> obterConversorUsuarioDepartamento() {

        return (source) -> DepartamentoDto.builder()
                .id(source.getId())
                .descricao(source.getDescricao())
                .origem(source.getIdUsuarioOrigem())
                .build();
    }
}