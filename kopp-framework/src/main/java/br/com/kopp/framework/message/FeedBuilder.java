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

    private final Map<String, Object> feeds;

    private final Collection<MessageDTO> messages;

    private FeedBuilder() {
        feeds = new HashMap<>();
        messages = new ArrayList<>();
    }

    public FeedBuilder add(String key, Object obj) {
        feeds.put(key, obj);
        return this;
    }

    public FeedBuilder add(Object obj) {
        return this.add(obj.getClass().getSimpleName(), obj);
    }

    public FeedBuilder add(Integer draw, Integer recordsTotal, int size, List data) {
        return this.add("datatables", new ResponseData<>(draw, recordsTotal, data.size(), data));
    }

    public FeedBuilder add(MessageDTO obj) {
        messages.add(obj);
        return this;
    }

    public Response build() {
        Map<String, Object> build = new HashMap<>();
        build.put(DATA_TYPE, feeds);
        build.put(MESSAGE_TYPE, messages);

        return Response.ok(build).build();
    }

    public static FeedBuilder create() {
        return new FeedBuilder();
    }

}
