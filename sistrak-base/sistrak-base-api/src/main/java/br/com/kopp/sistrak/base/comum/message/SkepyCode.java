package br.com.kopp.sistrak.base.comum.message;

import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public enum SkepyCode implements MessageCode {

    MS0001("success"),
    MS0002("success"),
    MS0003("success"),
    MS0004("success");

    private final String type;

    private SkepyCode(String type) {
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
