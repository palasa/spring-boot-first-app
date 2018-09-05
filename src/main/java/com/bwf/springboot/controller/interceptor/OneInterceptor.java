package com.bwf.springboot.controller.interceptor;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.enums.ResultType;
import com.bwf.springboot.utils.JsonResultUtil;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class OneInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("被 OneInterceptor 拦截 ，放行 ");
        return true;
    }

    // 请求处理之后， 渲染视图之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    // 视图渲染完成之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    public void returnErrorResponse (
            HttpServletResponse response ,
            JsonResult jsonResult
    ) throws IOException {
        OutputStream out = null ;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            out = response.getOutputStream();
            out.write(
                    JSONUtils.toJSONString(
                            JsonResultUtil.getResult(ResultType.UNKNOWN_ERROR, jsonResult)
                    ).getBytes("utf-8")
            );
            out.flush();
        } finally {
            if ( out != null ) {
                out.close();
            }
        }
    }
}
