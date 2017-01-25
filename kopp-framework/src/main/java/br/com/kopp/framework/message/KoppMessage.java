package br.com.kopp.framework.message;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import br.com.kopp.framework.message.code.MessageCode;
import br.com.kopp.framework.exception.KoppException;
import java.util.MissingResourceException;

/**
 *
 * @author cgoettert
 */
public abstract class KoppMessage implements MessageBundle {

    private static final String IDENT = "messages";

    private final ResourceBundle bundle;

    public KoppMessage() {
        this.bundle = ResourceBundle.getBundle(IDENT);
    }

    protected MessageDTO getText(ResourceBundle bundle, MessageType type, MessageCode code, Object... params) {
        try {
            return new MessageDTO(type.toString(), MessageFormat.format(bundle.getString(code.getCode()), params));
        } catch (MissingResourceException mre) {
            try {
                return new MessageDTO(type.toString(), MessageFormat.format(this.bundle.getString(code.getCode()), params));
            } catch (MissingResourceException mree) {
                return new MessageDTO(type.toString(), code.getCode());
            }
        }
    }

    @Override
    public abstract MessageDTO getText(MessageType messageType, KoppException koppException);

    @Override
    public abstract MessageDTO getText(MessageType type, MessageCode code);

    @Override
    public abstract MessageDTO getText(MessageType type, MessageCode code, Object... params);

}
