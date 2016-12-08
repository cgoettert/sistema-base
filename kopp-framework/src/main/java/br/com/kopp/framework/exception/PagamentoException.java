package br.com.kopp.framework.exception;

import br.com.kopp.framework.code.PagamentoCode;
import br.com.kopp.framework.code.ErrorCode;

/**
 *
 * @author cgoettert
 */
public class PagamentoException extends KoppException {

    public PagamentoException(PagamentoCode code) {
        super(code);
    }

    public PagamentoException(PagamentoCode code, Object... params) {
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
