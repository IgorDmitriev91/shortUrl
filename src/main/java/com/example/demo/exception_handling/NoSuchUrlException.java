package com.example.demo.exception_handling;

public class NoSuchUrlException extends RuntimeException {
    public NoSuchUrlException(String message) {
        super(message);
    }
}
