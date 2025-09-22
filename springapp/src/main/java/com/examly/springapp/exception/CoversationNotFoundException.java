package com.examly.springapp.exception;

public class CoversationNotFoundException extends RuntimeException {
    public CoversationNotFoundException() {
        super();
    }

    public CoversationNotFoundException(String message) {
        super(message);
    }
}
