package com.bwf.springboot.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString());
    }
}
