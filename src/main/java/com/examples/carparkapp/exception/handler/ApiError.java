package com.examples.carparkapp.exception.handler;

//Abstract Class
public abstract class ApiError {
    private final String message;
    //...

    //Abstract class constructor definition "protected" access modifier
    protected ApiError(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
