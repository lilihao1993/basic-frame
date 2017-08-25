package com.basicframe.common.remote.ajax;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
    private static final long serialVersionUID = 697017722467075534L;
    private String field;
    private String info;

    public ErrorInfo() {
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
