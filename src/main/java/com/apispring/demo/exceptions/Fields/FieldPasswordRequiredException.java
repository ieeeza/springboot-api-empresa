package com.apispring.demo.exceptions.Fields;

public class FieldPasswordRequiredException extends RuntimeException {
    public FieldPasswordRequiredException() {
        super("Password is required");
    }

    public FieldPasswordRequiredException(String message) {
        super(message);
    }
}
