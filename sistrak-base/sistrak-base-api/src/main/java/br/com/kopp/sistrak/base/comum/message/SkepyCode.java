package br.com.kopp.sistrak.base.comum.message;

import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public enum SkepyCode implements MessageCode {

    MS0001,
    MS0002,
    MS0003,
    MS0004;

    @Override
    public String getCode() {
        return this.name();
    }

}
