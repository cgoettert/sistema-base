package br.com.kopp.sistrak.skepi.comum.exception;

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

}
