package com.fairy.common.exception;


import com.fairy.common.enums.ResultEnums;

/**
 * 自定义异常
 *
 * @author hll
 * @version 1.0
 * @date 2022/3/17 15:09
 */
public class CommonException extends RuntimeException {

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

    public static CommonException create(Throwable e) {
        CommonException commonException = new CommonException();
        commonException.setCode(ResultEnums.FAILED.getResultCode());
        commonException.setMsg(e.getMessage());
        return commonException;
    }

    public static CommonException create(ResultEnums enums) {
        CommonException commonException = new CommonException();
        commonException.setMsg(enums.getResultMsg());
        commonException.setCode(enums.getResultCode());
        return commonException;
    }

    public static CommonException create(String code, String msg) {
        CommonException commonException = new CommonException();
        commonException.setMsg(msg);
        commonException.setCode(code);
        return commonException;
    }

    public static CommonException create(String msg) {
        CommonException commonException = new CommonException();
        commonException.setMsg(msg);
        commonException.setCode(ResultEnums.FAILED.getResultCode());
        return commonException;
    }

}


