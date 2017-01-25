package br.com.kopp.framework.message;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.code.MessageCode;

/**
 *
 * @author cgoettert
 */
public interface MessageBundle {

    public MessageDTO getText(MessageType messageType, KoppException koppException);

    public MessageDTO getText(MessageType messageType, MessageCode code);

    public MessageDTO getText(MessageType messageType, MessageCode code, Object... params);

}
