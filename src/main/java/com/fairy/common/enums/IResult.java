package com.fairy.common.enums;

/**
 * @author 鹿少年
 * @version 1.0
 * @project fourth-class
 * @createTime 2022/3/17 15:30
 */
public interface IResult {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
