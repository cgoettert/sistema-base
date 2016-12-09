package br.com.kopp.framework.message.code;

/**
 *
 * @author cgoettert
 */
public enum KoppCode implements MessageCode {

    FORMATO_INVALIDO("error"),
    VALOR_MENOR_QUE_MINIMO("error"),
    VALOR_MAIOR_QUE_MAXIMO("error"),
    VALOR_NULO("error");

    private final String type;

    private KoppCode(String type) {
        this.type = type;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getType() {
        return this.type;
    }
}
