package br.com.kopp.framework.datatables;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cgoettert
 * @param <T>
 */
public class ResponseData<T> implements Serializable {

    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List data;

    public ResponseData() {
    }

    public ResponseData(Integer draw, Integer recordsTotal, Integer recordsFiltered, List data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
