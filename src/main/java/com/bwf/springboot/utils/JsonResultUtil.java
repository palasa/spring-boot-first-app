package com.bwf.springboot.utils;

import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.enums.ResultType;

public class JsonResultUtil {

    @SuppressWarnings("unchecked")
    public static JsonResult getResult(ResultType resultType, Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultType.getCode());
        jsonResult.setMsg(resultType.getMessage());
        jsonResult.setData(data);

        return jsonResult;
    }

    public static JsonResult success(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultType.SUCESS.getCode());
        jsonResult.setMsg(ResultType.SUCESS.getMessage());
        //noinspection unchecked
        jsonResult.setData(data);

        return jsonResult;
    }

    public static JsonResult success() {
        return success(null);
    }

    public static JsonResult error(ResultType resultType) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultType.getCode());
        jsonResult.setMsg(resultType.getMessage());
        //noinspection unchecked
        jsonResult.setData(null);

        return jsonResult;
    }
}
