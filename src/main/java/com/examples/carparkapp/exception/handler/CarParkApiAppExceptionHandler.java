package com.examples.carparkapp.exception.handler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Sadece gösterim amaçlı koyulmuştur. Buradan ilgili @Controller class' ına ilişkin olarak
//exceptionlara ilişkin olarak hangi ErrorDTO ları göndereceğimizi bildirebiliriz.
//@ControllerAdvice
//Exceptions thrown in Web Service are wrapped with Spring Exceptions.
//Thanks to @ControllerAdvice, we can intervene and send the ErrorDTO we want.
public class CarParkApiAppExceptionHandler extends ResponseEntityExceptionHandler {
    //...


    /*@Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        var apiError = new CarParkAppApiError(HttpStatus.BAD_REQUEST, "Bozuk JSON formatı",
                ex.getMessage(), ex.getValue());

        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }*/
}
