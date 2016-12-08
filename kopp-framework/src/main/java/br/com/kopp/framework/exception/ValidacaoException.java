package br.com.kopp.framework.exception;

import br.com.kopp.framework.code.ValidacaoCode;
import br.com.kopp.framework.code.ErrorCode;

/**
 *
 * @author cgoettert
 */
public class ValidacaoException extends KoppException {

    public ValidacaoException(ValidacaoCode code) {
        super(code);
    }
    
    public ValidacaoException(ValidacaoCode code, Object... params) {
        super(code, params);
    }

    @Override
    public ErrorCode getCode() {
        return super.getCode();
    }
    
    @Override
    public Object[] getParams() {
        return super.getParams();
    }

}
