package br.com.kopp.framework.message.code;

/**
 *
 * @author cgoettert
 */
public enum KoppCode implements MessageCode {

    FORMATO_INVALIDO,
    VALOR_MENOR_QUE_MINIMO,
    VALOR_MAIOR_QUE_MAXIMO,
    VALOR_NULO;

    @Override
    public String getCode() {
        return this.name();
    }
}
