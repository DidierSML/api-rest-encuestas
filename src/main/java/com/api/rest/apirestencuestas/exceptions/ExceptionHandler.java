package com.api.rest.apirestencuestas.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    //Método en respuesta Elemento no encontrado - (Using NotFoundCustomExceptionResponse)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundCustomException.class)
    @ResponseBody
    public NotFoundCustomExceptionResponse handleElementNotFoundException (NotFoundCustomException exception){

        return new NotFoundCustomExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), new Date());
    }

    //Método para darle manejo a los errores por incumplimiento de Validaciones - Hereda de (ResponseEntityExceptionHandler)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error). getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
