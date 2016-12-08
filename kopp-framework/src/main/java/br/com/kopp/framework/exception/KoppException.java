package br.com.kopp.framework.exception;

import br.com.kopp.framework.code.ErrorCode;

/**
 *
 * @author cgoettert
 */
public class KoppException extends Exception {

    private ErrorCode code;
    private Object[] params;

    public KoppException() {
    }

    public KoppException(ErrorCode code) {
        this.code = code;
    }

    public KoppException(ErrorCode code, Object... params) {
        this.code = code;
        this.params = params;
    }

    public ErrorCode getCode() {
        return code;
    }

    public Object[] getParams() {
        return params;
    }

}
