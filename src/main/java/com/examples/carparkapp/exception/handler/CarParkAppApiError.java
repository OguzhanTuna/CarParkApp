package com.examples.carparkapp.exception.handler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarParkAppApiError extends ApiError{
    private final HttpStatus httpStatus;
    private final LocalDateTime timeStamp;
    private final String debugMessage;
    private final Object rejectedValue;
    private final List<ApiError> errorList;

    public CarParkAppApiError(HttpStatus httpStatus, String message, String debugMessage, Object rejectedValue)
    {
        //super constructor syntax.
        super(message);
        this.httpStatus = httpStatus;
        this.timeStamp = LocalDateTime.now();
        this.debugMessage = debugMessage;
        this.rejectedValue = rejectedValue;
        this.errorList = new ArrayList<>();
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }

    public LocalDateTime getTimeStamp()
    {
        return timeStamp;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public List<ApiError> getErrorList() {
        return errorList;
    }

    public void addApiError(ApiError apiError)
    {
        errorList.add(apiError);
    }
}
