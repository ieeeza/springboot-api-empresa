package com.apispring.demo.exceptions.Fields;

public class FieldEmailRequiredException extends RuntimeException {
    public FieldEmailRequiredException() {
        super("Email is required");
    }

    public FieldEmailRequiredException(String message) {
         super(message);
     }
}
