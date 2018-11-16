package com.free.code.constant;

public enum ResultSuccess {
    OPERATION_SUCCESS("00000010","操作成功"),
    OPERATION_FAILED("00000000","操作失败"),
    OPERATION_ERROR("00000000","操作异常"),

    PARAMS_IS_NULL("00010001","参数为空"),
    PARAMS_NOT_COMPLETE("00010002","参数不全"),
    PARAMS_TYPE_ERROR("0001003","参数类型错误"),
    PARAMS_IS_INVALID("00010004","参数无效"),

    // 用户错误
    USER_NOT_EXIST("00020001","用户不存在"),
    USER_NOT_LOGGED_IN("00020002","用户未登陆"),
    USER_ACCOUNT_ERROR("00020003","用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN("00020004","用户账户已被禁用"),
    USER_HAS_EXIST("00020005","用户已存在"),

    // 业务错误
    BUSINESS_ERROR("00030001","系统业务出现问题"),

    // 系统错误
    SYSTEM_INNER_ERROR("00040001","系统内部错误"),

    // 数据错误
    DATA_NOT_FOUND("00050001","数据未找到"),
    DATA_IS_WRONG("00050002","数据有误"),
    DATA_ALREADY_EXISTED("00050003","数据已存在"),

    // 接口错误
    INTERFACE_INNER_INVOKE_ERROR("00060001","系统内部接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR("00060002","系统外部接口调用异常"),
    INTERFACE_FORBIDDEN("00060003","接口禁止访问"),
    INTERFACE_ADDRESS_INVALID("00060004","接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT("00060005","接口请求超时"),
    INTERFACE_EXCEED_LOAD("00060006","接口负载过高"),
    INTERFACE_SUFFIX_INVALID("00060007","接口后缀无效"),

    // 权限错误
    PERMISSION_NO_ACCESS("00070001","没有访问权限")
    ;

    private String code;
    private String message;
    private ResultSuccess(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
