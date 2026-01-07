package com.apispring.demo.exceptions.User;

public class UserDoNotExistException extends RuntimeException {
    public UserDoNotExistException() {
        super("There is no such user with this credentials.");
    }

    public UserDoNotExistException(String message) {
        super(message);
    }
}
