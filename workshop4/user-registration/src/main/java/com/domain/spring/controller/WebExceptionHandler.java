package com.domain.spring.controller;


import com.domain.spring.exception.ErrorInfo;
import com.domain.spring.exception.UserRegistrationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wszybisty
 */
@ControllerAdvice
public class WebExceptionHandler {
    
    
    @ExceptionHandler(UserRegistrationException.class)
    @ResponseBody
    ErrorInfo handle(HttpServletRequest req, HttpServletResponse resp, UserRegistrationException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        switch (ex.getFailReason()) {
            case USER_ALREADY_EXISTS:
                status = HttpStatus.BAD_REQUEST;
        }
        resp.setStatus(status.value());
        return new ErrorInfo(req.getRequestURL(), ex.getFailReason().name());
    }
}
