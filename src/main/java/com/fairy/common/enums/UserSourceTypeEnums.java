package com.fairy.common.enums;

/**
 * 用户数据来源枚举
 * @author hll
 * @version 1.0
 * @date 2022/6/28 16:23
 */
public enum UserSourceTypeEnums {
    FILE_IMPORT("0", "文件导入"),
    WEB_SUBIMIT("1", "网页新增"),
    ELSE("-1", "其他");

    private String code;
    private String msg;

    UserSourceTypeEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static UserSourceTypeEnums getSourceType(String code){
        for (UserSourceTypeEnums userSourceTypeEnums:UserSourceTypeEnums.values()){
            if(userSourceTypeEnums.code.equals(code)){
                return userSourceTypeEnums;
            }
        }
        return ELSE;
    }

}
