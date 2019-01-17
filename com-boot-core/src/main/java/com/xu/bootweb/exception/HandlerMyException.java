package com.xu.bootweb.exception;

import lombok.extern.slf4j.Slf4j;
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
 * <p>
 *     自定义异常处理器
 * </p>
 * @author xuhongda on 2018/10/17
 * com.xu.bootweb.exception
 * com-boot-ex
 */
@ControllerAdvice
@Slf4j
public class HandlerMyException {

    private final Log logger = LogFactory.getLog(this.getClass());

    /**
     * <p>
     * {ExceptionHandler(ZeRoException.class) 指明处理哪个异常}
     * </p>
     *
     * @param ex 处理异常类型
     * @return Map
     */
    @ExceptionHandler(ZeRoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(ZeRoException ex) {
        Map<String, Object> result = new HashMap<>(3);
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        result.put("com/xu/bootweb/exception", ex.getStackTrace());
        logger.error(ex);
        return result;
    }
}
