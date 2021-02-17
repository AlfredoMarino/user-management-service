package com.marino.alfredo.usermanagementservice.web.configuration;

import com.marino.alfredo.usermanagementservice.exception.NotFoundException;
import com.marino.alfredo.usermanagementservice.exception.UniqueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { IllegalArgumentException.class, IllegalStateException.class, UniqueException.class })
    protected ResponseEntity<Object> handleBadRequestException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), getContextPath(request));

        return handleExceptionInternal(ex, exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value= { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage(), getContextPath(request));

        return handleExceptionInternal(ex, exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value= { AuthenticationException.class })
    protected ResponseEntity<Object> handleAuthorizationException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.FORBIDDEN, ex.getMessage(), getContextPath(request));

        return handleExceptionInternal(ex, exceptionResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    private String getContextPath(WebRequest request) {
        return request.getDescription(false).substring(4);
    }
}
