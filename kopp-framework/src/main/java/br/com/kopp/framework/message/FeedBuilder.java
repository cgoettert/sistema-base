package br.com.kopp.framework.message;

import br.com.kopp.framework.datatables.ResponseData;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
public interface FeedBuilder {

    public void add(String key, Object obj);

    public void add(Object obj);

    public void add(ResponseData responseData);

    public void add(MessageDTO obj);

    public Response build();

}
