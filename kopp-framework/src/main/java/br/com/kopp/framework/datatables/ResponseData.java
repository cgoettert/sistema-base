package br.com.kopp.framework.datatables;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cgoettert
 * @param <T>
 */
public class ResponseData implements Serializable {

    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List data;
    private String error;

    public ResponseData() {
    }

    public ResponseData(String error) {
        this.error = error;
    }

    public ResponseData(Integer draw, Long recordsTotal, Long recordsFiltered, List data) {
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

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
