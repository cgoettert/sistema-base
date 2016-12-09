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

    public FeedBuilder() {
        this.feeds = new HashMap<>();
        this.feeds.put(MESSAGE_TYPE, new ArrayList<>());
    }

    public FeedBuilder add(Object obj) {
        feeds.put(obj.getClass().getSimpleName(), obj);
        return this;
    }

    public FeedBuilder add(MessageDTO obj) {
        List list = (ArrayList<Object[]>) feeds.get(MESSAGE_TYPE);
        list.add(obj);
        return this;
    }

    public Response build() {
        return Response.ok(feeds).build();
    }
    
    public static FeedBuilder create() {
        return new FeedBuilder();
    }

}
