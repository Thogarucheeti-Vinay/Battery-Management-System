package com.nunam.bms.pojo;

public class APIResponse {

    private Boolean result;
    private Integer statusCode;
    private String statusCodeDescription;
    private String message;
    private Object response;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCodeDescription() {
        return statusCodeDescription;
    }

    public void setStatusCodeDescription(String statusCodeDescription) {
        this.statusCodeDescription = statusCodeDescription;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public APIResponse() {
    }

    public APIResponse(Boolean result, Integer statusCode, String statusCodeDescription, String message, Object response) {
        this.result = result;
        this.statusCode = statusCode;
        this.statusCodeDescription = statusCodeDescription;
        this.message = message;
        this.response = response;
    }
}
