package com.fairy.common.response;

import com.fairy.common.enums.ResultEnums;
import lombok.Data;

/**
 * 通用结果返回
 * @author hll
 * @version 1.0
 * @date  2022/1/25 13:39
 */
@Data
public class CommonResponse<T> {
    private boolean success;
    private String code;
    private String msg;
    private T data;


    public static CommonResponse success() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResultEnums.SUCCESS.getResultCode());
        commonResponse.setMsg(ResultEnums.SUCCESS.getResultMsg());
        commonResponse.setSuccess(true);
        return commonResponse;
    }

    public static CommonResponse fail() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResultEnums.SYSTEM_ERROR.getResultCode());
        commonResponse.setMsg(ResultEnums.SYSTEM_ERROR.getResultMsg());
        commonResponse.setSuccess(false);
        return commonResponse;
    }


    public static <T> CommonResponse<T> fail(String message) {
        CommonResponse commonResponse = fail();
        commonResponse.setMsg(message);
        return commonResponse;
    }

    public static <T> CommonResponse<T>fail(String msg,T data) {
        CommonResponse commonResponse = fail();
        commonResponse.setMsg(msg);
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse<T> fail(ResultEnums errorCode, T data) {
        CommonResponse commonResponse = fail();
        commonResponse.setMsg(errorCode.getResultMsg());
        commonResponse.setCode(errorCode.getResultCode());
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse<T> fail(ResultEnums errorCode) {
        CommonResponse commonResponse = fail();
        commonResponse.setMsg(errorCode.getResultMsg());
        commonResponse.setCode(errorCode.getResultCode());
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(T data) {
        CommonResponse commonResponse = success();
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        CommonResponse commonResponse = success();
        commonResponse.setData(data);
        commonResponse.setMsg(message);
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(String message) {
        CommonResponse commonResponse = success();
        commonResponse.setMsg(message);
        return commonResponse;
    }



}
