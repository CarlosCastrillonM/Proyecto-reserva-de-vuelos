package com.example.eldorado.exception;

public class RoleNotFoundException extends ResourceNotFoundException{
    public RoleNotFoundException(){
    }
    public RoleNotFoundException(String message){
        super(message);
    }
    public RoleNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public RoleNotFoundException(Throwable cause){
        super(cause);
    }
    public RoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
