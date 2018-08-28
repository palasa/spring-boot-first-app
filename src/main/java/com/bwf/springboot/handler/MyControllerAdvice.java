package com.bwf.springboot.handler;


import com.bwf.springboot.enums.ResultType;
import com.bwf.springboot.utils.JsonResultUtil;
import com.bwf.springboot.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyControllerAdvice {

    private static final String DEFAULT_ERROR_VIEW = "thymeleaf/err";

    private static final Logger logger =
            LoggerFactory.getLogger(MyControllerAdvice.class);


    /**
     * 所有的 RequestMapping 方法执行前， 初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到 model 中 ，全局的 RequestMapping 方法都可以使用该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
    }

    /**
     * 全局异常捕获
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    // @ResponseBody
    public Object errorHandler(
            HttpServletRequest request,
            Exception e) throws Exception {
        e.printStackTrace();

        if (RequestUtil.isAjaxRequest(request)) {
            logger.error("ajax请求发生错误！");
            return JsonResultUtil.error(ResultType.AJAX_ERROR);
            // return null;
        } else {
            logger.error("普通请求发生错误！");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", request.getRequestURL().toString());
            modelAndView.setViewName(DEFAULT_ERROR_VIEW);

            //
            modelAndView.addObject("timestamp", "");
            return modelAndView;
        }

    }


}
