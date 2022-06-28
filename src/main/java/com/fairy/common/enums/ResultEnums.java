package com.fairy.common.enums;

/**
 * 相应结果枚举类
 * @author hll
 * @version 1.0
 * @date  2022/3/17 15:09
 */
public enum ResultEnums   {

    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    VALIDATE_FAILED("400", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限"),
    PARAMETER("402", "请求参数异常"),
    FLOW_RULE_ERR("500", "触发流控"),
    HOT_PARAM_FLOW_RULE_ERR("500", "参数流控了"),
    AUTH_RULE_ERR("500", "权限校验不通过"),
    SYS_RULE_ERR("500", "系统负载不满足"),
    DEGRADE_RULE_ERR("500", "降级规则触发"),
    SQL_EXCEPTION("500", "SQL执行异常"),
    RUNTIMEERROR("500", "运行时异常"),
    UNFINDPATH("404", "路径查找不到"),
    ACCESSFAIL("500", "获取失败"),
    HTTPREQUESTFAIL("500", "http接口请求失败"),
    SYSTEM_BUSY("000003", "系统繁忙,请稍候再试"),
    NOT_LOGIN("-1","没有登陆"),
    LOGIN_SUCCESS("000005","登陆成功"),
    LOGOUT_SUCCESS("000006","退出成功"),
    REFRESH_TOKEN_EXPIRE("000007","刷新令牌过期"),
    GET_TOKEN_KEY_ERROR("000008","认证服务器获取Token异常"),
    GEN_PUBLIC_KEY_ERROR("000009","生成公钥异常"),
    SYSTEM_ERROR("000002", "系统异常"),
    GATEWAY_CONNECT_TIME_OUT("000504", "网关超时"),
    GATEWAY_ERROR("000501", "网关异常"),
    BAD_GATEWAY("000502","错误网关"),
    GATEWAY_NOT_FOUND_SERVICE("0000001", "服务未找到"),
    AUTHORIZATION_HEADER_IS_EMPTY("500","请求头中的token为空"),
    MANY_REQUEST_ERROR("500","后端服务触发流控"),
    BACK_DEGRADE_ERROR("500","后端服务触发降级"),
    ;

    /** 编号 */
    private String code;
    /**信息*/
    private String message;

    ResultEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getResultCode() {
        return code;
    }

    public String getResultMsg() {
        return message;
    }
}


