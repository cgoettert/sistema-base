package br.com.kopp.framework.message;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import br.com.kopp.framework.message.code.MessageCode;
import br.com.kopp.framework.exception.KoppException;

/**
 *
 * @author cgoettert
 */
public class KoppMessage implements MessageBundle {

    private static final String IDENT = "kopp";

    private final ResourceBundle bundle;

    public KoppMessage() {
        this.bundle = ResourceBundle.getBundle(IDENT);
    }
    
    @Override
    public MessageDTO getText(KoppException koppException) {
        return getText(koppException.getCode(), koppException.getParams());
    }

    @Override
    public MessageDTO getText(MessageCode code) {
        return getText(code, new Object[0]);
    }

    @Override
    public MessageDTO getText(MessageCode code, Object... params) {
        return getText(this.bundle, code.getType(), code.getCode(), params);
    }

    protected MessageDTO getText(ResourceBundle bundle, String type, String code, Object... params) {
        return new MessageDTO(type, MessageFormat.format(bundle.getString(code), params));
    }

}
