package org.huangding.redismqregister.util;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.huangding.redismqregister.enums.JsonResultErrorEnum;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 14:36
 */
@Data
public class JsonResult {

    private String code = "0";

    private String msg;

    private Object data;

    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    public static JsonResult SUCCESS() {
        return (new JsonResult()).setData(Strings.EMPTY);
    }

    public static JsonResult DATA(Object data) {
        return (new JsonResult()).setData(data);
    }

    public static JsonResult N(String code, String msg) {
        return (new JsonResult()).setCode(code).setMsg(msg);
    }

    public static JsonResult error(JsonResultErrorEnum jsonResultErrorEnum){
        return (new JsonResult()).setCode(jsonResultErrorEnum.getCode()).setMsg(jsonResultErrorEnum.getMsg());
    }
}
