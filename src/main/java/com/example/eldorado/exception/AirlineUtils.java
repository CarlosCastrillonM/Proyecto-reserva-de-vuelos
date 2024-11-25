package com.example.eldorado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AirlineUtils {
    private AirlineUtils() {

    }

    public static ResponseEntity<String> getResponseEntity (String message, HttpStatus httpstatus) {
        return new ResponseEntity<String>("Message: " + message, httpstatus);
    }
}
