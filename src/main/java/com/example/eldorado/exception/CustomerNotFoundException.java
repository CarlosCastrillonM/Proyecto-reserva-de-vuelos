package com.example.eldorado.exception;

public class CustomerNotFoundException extends ResourceNotFoundException{
    public CustomerNotFoundException() {
    }
    public CustomerNotFoundException(String message) {
        super(message);
    }
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
    public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
