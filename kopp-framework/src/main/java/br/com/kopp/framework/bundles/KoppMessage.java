package br.com.kopp.framework.bundles;

import br.com.kopp.framework.code.ErrorCode;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 *
 * @author cgoettert
 */
public class KoppMessage {

    public static String getText(ErrorCode code, Object... params) {
        ResourceBundle bundle = ResourceBundle.getBundle("erros");
        return MessageFormat.format(bundle.getString(code.getCode()), params);
    }

    public static String getText(String message) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        return bundle.getString(message);
    }
}
