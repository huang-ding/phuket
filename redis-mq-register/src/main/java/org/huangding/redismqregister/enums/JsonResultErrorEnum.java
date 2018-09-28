package org.huangding.redismqregister.enums;

/**
 * @author huangding
 * @description 错误码
 * @date 2018/9/28 15:24
 */
public enum JsonResultErrorEnum {
    MYSQL_DATA_GRAMMAR("mysql语法错误", "6000");


    private String msg;
    private String code;

    JsonResultErrorEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
