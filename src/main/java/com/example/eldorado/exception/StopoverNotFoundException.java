package com.example.eldorado.exception;

public class StopoverNotFoundException extends ResourceNotFoundException{
    public StopoverNotFoundException(){
    }
    public StopoverNotFoundException(String message){
        super(message);
    }
    public StopoverNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public StopoverNotFoundException(Throwable cause){
        super(cause);
    }
    public StopoverNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
