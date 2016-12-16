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
    
    protected MessageDTO getText(ResourceBundle bundle, MessageCode code, Object... params) {
        try {
            return new MessageDTO(code.getType(), MessageFormat.format(bundle.getString(code.getCode()), params));
        } catch (MissingResourceException mre) {
            return new MessageDTO(code.getType(), MessageFormat.format(this.bundle.getString(code.getCode()), params));
        }
    }

    @Override
    public abstract MessageDTO getText(KoppException koppException);

    @Override
    public abstract MessageDTO getText(MessageCode code);

    @Override
    public abstract MessageDTO getText(MessageCode code, Object... params);

}
