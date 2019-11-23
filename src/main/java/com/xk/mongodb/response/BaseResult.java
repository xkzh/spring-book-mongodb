package com.xk.mongodb.response;


import org.apache.poi.ss.formula.functions.T;

public class BaseResult {

    private int code;
    private String msg;
    private Object data = "";


    public BaseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult() {
    }
    /**
     * 构造函数
     * */
    public BaseResult(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = ResponseCode.error.getCode();
    }

    /**
     * 构造函数
     * */
    public BaseResult(T data) {
        super();
        this.data = data;
    }



    public static BaseResult instance(int code, String msg) {
        return new BaseResult(code, msg);
    }

    public static BaseResult success() {
        return new BaseResult(ResponseCode.success.getCode(), ResponseCode.success.getMsg());
    }

    public static BaseResult success(Object data) {
        return new BaseResult(ResponseCode.success.getCode(), ResponseCode.success.getMsg(), data);
    }

    public static BaseResult error() {
        return new BaseResult(ResponseCode.error.getCode(), ResponseCode.error.getMsg());
    }

    public static BaseResult error(String msg) {
        return new BaseResult(ResponseCode.error.getCode(), msg);
    }

    public static BaseResult error(Throwable e) {
        return new BaseResult(ResponseCode.error.getCode(), e.toString());
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
