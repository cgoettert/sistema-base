package br.com.kopp.framework.exception;

import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public class KoppException extends Exception {

    private MessageCode code;
    private Object[] params;

    public KoppException() {
    }

    public KoppException(MessageCode code) {
        this.code = code;
    }

    public KoppException(MessageCode code, Object... params) {
        this.code = code;
        this.params = params;
    }

    public MessageCode getCode() {
        return code;
    }

    public Object[] getParams() {
        return params;
    }

}
