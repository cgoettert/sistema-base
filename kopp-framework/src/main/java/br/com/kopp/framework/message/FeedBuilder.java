package br.com.kopp.framework.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
public class FeedBuilder {

    private static final String MESSAGE_TYPE = "message";

    private final Map<String, Object> feeds;
    
    private List<MessageDTO> messages;

    private FeedBuilder() {
        this.feeds = new HashMap<>();
        messages = new ArrayList<MessageDTO>();
    }

    public FeedBuilder add(Object obj) {
        return this.add(obj.getClass().getSimpleName(), obj);
    }

    /**
     * @author lerneumann
     */
    public FeedBuilder add(String key, Object obj) {
        feeds.put(key, obj);
        return this;
    }

    public FeedBuilder add(MessageDTO obj) {
		messages.add(obj);
        return this;
    }

    public Response build() {
    	if (messages.size() > 0) {
    		this.feeds.put(MESSAGE_TYPE, messages);
    	}
        return Response.ok(feeds).build();
    }
    
    public static FeedBuilder create() {
        return new FeedBuilder();
    }

}
