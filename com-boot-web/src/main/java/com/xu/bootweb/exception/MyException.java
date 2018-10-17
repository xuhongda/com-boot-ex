package com.xu.bootweb.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongda on 2018/10/17
 * com.xu.bootweb.exception
 * com-boot-ex
 */
@ControllerAdvice

public class MyException {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @ExceptionHandler(ZeRoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(ZeRoException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        result.put("exception", ex.getStackTrace());
        logger.error(ex);
        return result;
    }
}
