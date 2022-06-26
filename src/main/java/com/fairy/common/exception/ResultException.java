package com.fairy.common.exception;


import com.fairy.common.enums.ResultEnums;

/**
 * 自定义异常
 *
 * @author hll
 * @version 1.0
 * @date  2022/3/17 15:09
 */
public class ResultException extends RuntimeException {

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static ResultException create(ResultEnums enums) {
        ResultException resultException = new ResultException();
        resultException.setMsg(enums.getResultMsg());
        resultException.setCode(enums.getResultCode());
        return resultException;
    }

    public static ResultException create(String code, String msg) {
        ResultException resultException = new ResultException();
        resultException.setMsg(msg);
        resultException.setCode(code);
        return resultException;
    }

    public static ResultException create(String msg) {
        ResultException resultException = new ResultException();
        resultException.setMsg(msg);
        resultException.setCode(ResultEnums.FAILED.getResultCode());
        return resultException;
    }

}


