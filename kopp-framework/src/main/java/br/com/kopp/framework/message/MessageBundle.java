package br.com.kopp.framework.message;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public interface MessageBundle {

    public MessageDTO getText(KoppException koppException);

    public MessageDTO getText(MessageCode code);

    public MessageDTO getText(MessageCode code, Object... params);

}
