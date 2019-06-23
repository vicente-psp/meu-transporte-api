package com.fatesg.meutransporteapi.controllers.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fatesg.meutransporteapi.exceptions.NotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handlerNotFoundException(NotFoundException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentialsException(BadCredentialsException ex) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });

        String defaultMessage = "Atributos inválidos.";

        ApiErrorList error = new ApiErrorList(HttpStatus.BAD_REQUEST.value(), defaultMessage, new Date(), errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}