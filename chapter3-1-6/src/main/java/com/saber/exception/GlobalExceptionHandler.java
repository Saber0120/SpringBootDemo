package com.saber.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sheng on 2018/4/19.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_PAGE = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ERROR_PAGE);
        mv.addObject("exception", e);
        mv.addObject("url", request.getRequestURL());
        return mv;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonError(HttpServletRequest request, Exception e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setT("Some Data");
        return errorInfo;
    }
}
