package br.com.kopp.framework.datatables;

import br.com.kopp.framework.exception.KoppException;
import br.com.kopp.framework.message.code.KoppCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cgoettert
 */
public class RequestData implements Serializable {

    private List<Columns> columns;
    private Integer draw;
    private Integer length;
    private List<Order> order;
    private Search search;
    private Integer start;

    public RequestData() {
    }

    public RequestData(String json) throws KoppException, IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            RequestData requestData = mapper.readValue(json, RequestData.class);

            this.columns = requestData.getColumns();
            this.draw = requestData.getDraw();
            this.length = requestData.getLength();
            this.order = requestData.getOrder();
            this.search = requestData.getSearch();
            this.start = requestData.getStart();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public RequestData(List<Columns> columns, Integer draw, Integer length, List<Order> order, Search search, Integer start) {
        this.columns = columns;
        this.draw = draw;
        this.length = length;
        this.order = order;
        this.search = search;
        this.start = start;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

}
