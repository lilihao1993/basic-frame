package com.basicframe.common.remote.ajax;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AjaxResult implements Serializable {
    private static final long serialVersionUID = -3282121504305297818L;
    private String status = "success";
    private String errorCode = "";
    private String msg = null;
    private List<ErrorInfo> errors = new ArrayList();
    private Object data = null;

    private AjaxResult() {
    }

    public static AjaxResult success(String msg) {
        AjaxResult success = new AjaxResult();
        success.setStatus("success");
        success.setMsg(msg);
        return success;
    }

    public static AjaxResult success(String msg, Object data) {
        AjaxResult success = new AjaxResult();
        success.setStatus("success");
        success.setMsg(msg);
        success.setData(data);
        return success;
    }

    public static AjaxResult error(String msg) {
        AjaxResult error = new AjaxResult();
        error.setStatus("fail");
        error.setMsg(msg);
        return error;
    }

    public static AjaxResult error(String errorCode, String msg) {
        AjaxResult error = new AjaxResult();
        error.setStatus("fail");
        error.setErrorCode(errorCode);
        error.setMsg(msg);
        return error;
    }

    public static AjaxResult error(String errorCode, String msg, Object data) {
        AjaxResult error = new AjaxResult();
        error.setStatus("fail");
        error.setErrorCode(errorCode);
        error.setMsg(msg);
        error.setData(data);
        return error;
    }

    public void addErrorInfo(ErrorInfo errorInfo) {
        this.errors.add(errorInfo);
    }

    public void addErrorInfo(List<ObjectError> validatorErrors) {
        for (int i = 0; i < validatorErrors.size(); ++i) {
            ObjectError objectError = (ObjectError) validatorErrors.get(i);
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setField(fieldError.getField());
                errorInfo.setInfo(fieldError.getDefaultMessage());
                this.addErrorInfo(errorInfo);
            }
        }

    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<ErrorInfo> getErrors() {
        return this.errors;
    }

    public void setErrors(List<ErrorInfo> errors) {
        this.errors = errors;
    }
}