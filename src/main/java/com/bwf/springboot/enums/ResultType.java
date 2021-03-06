package com.bwf.springboot.enums;

public enum ResultType {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "处理成功"),
    MODEL_ERROR(500, "数据模型验证失败"),
    USER_ERROR(501, "用户模块发生错误"),
    AJAX_ERROR(502, "ajax请求发生异常");


    private final Integer code;
    private final String message;

    ResultType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
