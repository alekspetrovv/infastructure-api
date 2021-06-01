package com.example.group01.exception;

public class ReaderNotFoundException extends RuntimeException{
    public ReaderNotFoundException(String message) {
        super(message);
    }
}
