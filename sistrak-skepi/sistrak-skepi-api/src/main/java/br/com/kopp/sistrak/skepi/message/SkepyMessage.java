package br.com.kopp.sistrak.skepi.message;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.KoppMessage;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.framework.message.MessageDTO;
import br.com.kopp.framework.message.code.MessageCode;
import java.util.MissingResourceException;
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
        super();
        this.bundle = ResourceBundle.getBundle(IDENT);
    }

    @Override
    public MessageDTO getText(MessageCode code, Object... params) {
        try {
            return super.getText(this.bundle, code.getType(), code.getCode(), params);
        } catch (MissingResourceException mre) {
            return super.getText(code, params);
        }
    }

}
