package com.example.eldorado.exception;

public class AirlineNotFoundException extends ResourceNotFoundException {
    public AirlineNotFoundException() {
    }
    public AirlineNotFoundException(String message) {
        super(message);
    }
    public AirlineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AirlineNotFoundException(Throwable cause) {
        super(cause);
    }
    public AirlineNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
