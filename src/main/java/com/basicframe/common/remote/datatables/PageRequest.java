package com.basicframe.common.remote.datatables;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PageRequest implements Serializable {
    private static final long serialVersionUID = -911527837717383901L;
    private int draw;
    private List<Map<Column, Object>> columns;
    private List<Map<PageRequest.Order, Object>> order;
    private int start;
    private int pageNum;
    private int length;
    private Map<PageRequest.Search, Object> search;
    private Map<String, Object> params;

    public PageRequest() {
    }

    public int getDraw() {
        return this.draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<Map<PageRequest.Column, Object>> getColumns() {
        return this.columns;
    }

    public void setColumns(List<Map<PageRequest.Column, Object>> columns) {
        this.columns = columns;
    }

    public List<Map<PageRequest.Order, Object>> getOrder() {
        return this.order;
    }

    public void setOrder(List<Map<PageRequest.Order, Object>> order) {
        this.order = order;
    }

    public Map<PageRequest.Search, Object> getSearch() {
        return this.search;
    }

    public void setSearch(Map<PageRequest.Search, Object> search) {
        this.search = search;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageNum() {
        return this.getStart() / this.getLength() + 1;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getLength() {
        if(this.length <= 0) {
            this.length = 10;
        }

        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static enum Order {
        column,
        dir;

        private Order() {
        }
    }

    public static enum Search {
        value,
        regex;

        private Search() {
        }
    }

    public static enum Column {
        data,
        name,
        searchable,
        orderable,
        searchValue,
        searchRegex;

        private Column() {
        }
    }
}