package com.bwf.springboot.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ViewExceptionHandler {

    private static final String ERROR_VIEW = "error";

    private static final Logger logger =
            LoggerFactory.getLogger(ViewExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Object handle(
            HttpServletRequest request,
            HttpServletResponse response,
            Exception e) throws Exception {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName(ERROR_VIEW);
        return modelAndView;
    }
}
