package com.ppoox.api.sys.util;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TuiGridResult {
    private boolean result;
    private String message;
    private Object data;

    public TuiGridResult(){}

    public static TuiGridResult successInstance(){
        return new TuiGridResult().success();
    }

    public TuiGridResult success(){
        result = true;
        return this;
    }

    public TuiGridResult fail(){
        result = false;
        return this;
    }

    public TuiGridResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public TuiGridResult setData(Object data) {
        this.data = data;
        return this;
    }
}
