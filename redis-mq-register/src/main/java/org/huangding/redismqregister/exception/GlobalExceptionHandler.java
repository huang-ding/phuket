package org.huangding.redismqregister.exception;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.huangding.redismqregister.enums.JsonResultErrorEnum;
import org.huangding.redismqregister.util.JsonResult;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangding
 * @description 异常处理
 * @date 2018/9/28 14:09
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 数据库关键字重复
     */
    private static String duplicateEntry = "Duplicate entry";

    @ExceptionHandler(value = DuplicateKeyException.class)
    public JsonResult duplicateKeyException(Exception exception) {
        String localizedMessage = exception.getLocalizedMessage();
        if (!Strings.isNullOrEmpty(localizedMessage)
            && localizedMessage.indexOf(duplicateEntry) != -1) {
            return JsonResult.N(JsonResultErrorEnum.MYSQL_DATA_GRAMMAR.getCode(),
                localizedMessage.split("###")[1].split(":")[2]);
        }
        return JsonResult.error(JsonResultErrorEnum.MYSQL_DATA_GRAMMAR);

    }

    /**
     * 所有异常报错
     */
    @ExceptionHandler(value = Exception.class)
    public String allExceptionHandler(Exception exception) {
        return JSON.toJSONString(exception.getLocalizedMessage());

    }

}
