package com.github.caliburn;

/**
 * Created by chentong on 2017/9/21.
 */

public class JsResponse<T>  {

    private String error = null;
    private T data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}