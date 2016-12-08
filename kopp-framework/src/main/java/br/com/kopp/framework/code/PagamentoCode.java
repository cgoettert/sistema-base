package br.com.kopp.framework.code;

/**
 *
 * @author cgoettert
 */
public enum PagamentoCode implements ErrorCode {
    
    CARTAO_CREDITO_VENCIDO,
    SEM_CREDITO;
    
    @Override
    public String getCode() {
        return this.name();
    }
}
