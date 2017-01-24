package br.com.kopp.framework.message;

import br.com.kopp.framework.datatables.ResponseData;
import java.util.ArrayList;
import java.util.Collection;
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
    private static final String DATA_TYPE = "data";
    private static final String STATUS_TYPE = "status";

    private String status;
    private final Map<String, Object> feeds;
    private final Collection<MessageDTO> messages;

    private FeedBuilder() {
        feeds = new HashMap<>();
        messages = new ArrayList<>();
        status = "true";
    }

    public FeedBuilder add(String key, Object obj) {
        feeds.put(key, obj);
        return this;
    }

    public FeedBuilder add(Object obj) {
        return this.add(obj.getClass().getSimpleName(), obj);
    }

    public FeedBuilder add(ResponseData responseData) {
        return this.add("datatables", responseData);
    }

    public FeedBuilder add(MessageDTO obj) {
        if("error".equals(obj.getTipo())) {
            status = "false";
        }
        messages.add(obj);
        return this;
    }

    public Response build() {
        Map<String, Object> build = new HashMap<>();
        build.put(DATA_TYPE, feeds);
        build.put(MESSAGE_TYPE, messages);
        build.put(STATUS_TYPE, status);

        return Response.ok(build).build();
    }

    public static FeedBuilder create() {
        return new FeedBuilder();
    }

}
