package com.sitis.gestionusuariosbackend.exception;

import com.sitis.gestionusuariosbackend.dto.ExceptionResponse;
import com.sitis.gestionusuariosbackend.mapper.ExceptionMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handleApplicationException(ApplicationException ex, WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.mapApplicationException(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<ExceptionResponse> handleDataException(DataException ex, WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.mapDataException(ex.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException ex, WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.mapConstraintViolationException(ex.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
