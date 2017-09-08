package com.basicframe.common.remote.datatables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResponse<T> implements Serializable {
    private static final long serialVersionUID = -5584061128249495676L;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data = new ArrayList();

    public PageResponse() {
    }

    public PageResponse(int draw, long recordsTotal, List<T> data) {
        this.draw = draw;
        this.recordsFiltered = recordsTotal;
        this.recordsTotal = recordsTotal;
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
