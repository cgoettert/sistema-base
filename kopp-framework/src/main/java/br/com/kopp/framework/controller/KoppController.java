package br.com.kopp.framework.controller;

import br.com.kopp.framework.datatables.ResponseData;
import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.FeedBuilder;
import br.com.kopp.framework.message.KoppFeedBuilder;
import br.com.kopp.framework.message.MessageBundle;
import br.com.kopp.framework.message.MessageType;
import br.com.kopp.framework.message.code.MessageCode;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
public abstract class KoppController {

    private final FeedBuilder feedBuilder = new KoppFeedBuilder();
    private MessageBundle message;

    public KoppController() {
    }
    
    @Inject
    public KoppController(MessageBundle message) {
        this.message = message;
    }

    protected void addData(Object obj) {
        feedBuilder.add(obj);
    }

    protected void addData(String key, Object obj) {
        feedBuilder.add(key, obj);
    }

    protected void addData(ResponseData responseData) {
        feedBuilder.add(responseData);
    }

    protected void addMessage(MessageCode code) {
        feedBuilder.add(message.getText(MessageType.SUCCESS, code));
    }

    protected void addMessage(MessageCode code, Object... params) {
        feedBuilder.add(message.getText(MessageType.SUCCESS, code, params));
    }

    protected void addInfo(MessageCode code) {
        feedBuilder.add(message.getText(MessageType.INFO, code));
    }

    protected void addInfo(MessageCode code, Object... params) {
        feedBuilder.add(message.getText(MessageType.INFO, code, params));
    }

    protected void addWarning(MessageCode code) {
        feedBuilder.add(message.getText(MessageType.WARNING, code));
    }

    protected void addWarning(MessageCode code, Object... params) {
        feedBuilder.add(message.getText(MessageType.WARNING, code, params));
    }

    protected void addError(MessageCode code) {
        feedBuilder.add(message.getText(MessageType.ERROR, code));
    }

    protected void addError(MessageCode code, Object... params) {
        feedBuilder.add(message.getText(MessageType.ERROR, code, params));
    }

    protected void addError(KoppException exception) {
        feedBuilder.add(message.getText(MessageType.ERROR, exception));
    }

    protected Response build() {
        return feedBuilder.build();
    }

}
