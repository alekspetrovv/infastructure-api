package com.example.group01.exception;

public class PointsNotFoundException extends RuntimeException{
    public PointsNotFoundException(String message) {
        super(message);
    }
}
