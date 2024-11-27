package com.example.eldorado.exception;

public class AirportNotFoundException extends ResourceNotFoundException {
    public AirportNotFoundException() {
    }
    public AirportNotFoundException(String message) {
        super(message);
    }
    public AirportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AirportNotFoundException(Throwable cause) {
        super(cause);
    }
    public AirportNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
