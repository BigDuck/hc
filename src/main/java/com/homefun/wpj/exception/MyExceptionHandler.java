package com.homefun.wpj.exception;

import com.homefun.wpj.controller.BaseController;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler extends BaseController {
    private Logger logger= LoggerFactory.getLogger(MyExceptionHandler.class);
   @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundError(HttpServletRequest request, ResourceNotFoundException ex) {
       logger.error("页面没找到{}",ex.getMessage());

       return "404";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleUnexpectedServerError(HttpServletRequest request, RuntimeException ex) {
        logger.error("服务器内部发生错误{}",ex.getMessage());
        ex.printStackTrace();
        return "500";
    }
    @ExceptionHandler(CheckException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleUserDIYERROR(CheckException checkException){
        logger.error("用户自定义错误{}",checkException);
        return checkException;
    }

}