package com.bwf.springboot.handler;


import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.enums.ResultType;
import com.bwf.springboot.exception.UserException;
import com.bwf.springboot.utils.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public JsonResult handle(Exception e) {

        if (e instanceof UserException) {
            logger.error("[用户异常]：{}", e.getMessage());
            return JsonResultUtil.error(ResultType.USER_ERROR);

        }

        logger.error("[系统异常]：{}", e.getMessage());
        return JsonResultUtil.error(ResultType.UNKNOWN_ERROR);
    }
}
