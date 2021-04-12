package com.example.group01.exception;

public class ZoneNotFoundException extends RuntimeException{
    public ZoneNotFoundException(String message) {
        super(message);
    }
}
