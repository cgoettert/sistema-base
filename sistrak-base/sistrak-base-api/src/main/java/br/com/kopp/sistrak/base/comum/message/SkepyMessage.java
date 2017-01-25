package br.com.kopp.sistrak.base.comum.message;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.KoppMessage;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.framework.message.MessageDTO;
import br.com.kopp.framework.message.MessageType;
import br.com.kopp.framework.message.code.MessageCode;
import java.util.ResourceBundle;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cgoettert
 */
@RequestScoped
public class SkepyMessage extends KoppMessage implements MessageBundle {

    private static final String IDENT = "skepi";

    private final ResourceBundle bundle;

    public SkepyMessage() {
        this.bundle = ResourceBundle.getBundle(IDENT);
    }

    @Override
    public MessageDTO getText(MessageType type, KoppException koppException) {
        return getText(bundle, type, koppException.getCode(), koppException.getParams());
    }

    @Override
    public MessageDTO getText(MessageType type, MessageCode code) {
        return getText(bundle, type, code, new Object[0]);
    }

    @Override
    public MessageDTO getText(MessageType type, MessageCode code, Object... params) {
        return getText(bundle, type, code, params);
    }

}
