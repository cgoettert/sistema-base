package br.com.kopp.sistrak.skepi.exception;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public class SkepyException extends KoppException {

    public SkepyException(MessageCode code) {
        super(code);
    }

    public SkepyException(MessageCode code, Object... params) {
        super(code, params);
    }

    @Override
    public MessageCode getCode() {
        return super.getCode();
    }

    @Override
    public Object[] getParams() {
        return super.getParams();
    }

}
