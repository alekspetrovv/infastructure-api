package com.example.group01.exception;

public class MapNotFoundException extends RuntimeException{
    public MapNotFoundException(String message) {
        super(message);
    }
}
