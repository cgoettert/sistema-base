package br.com.kopp.framework.message;

/**
 *
 * @author cgoettert
 */
public enum MessageType {
    
    SUCCESS,
    ERROR,
    WARNING,
    INFO;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
    
}
