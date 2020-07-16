package com.reesemedia.Exceptions;

public class AuthorizationException extends AppUsersException {

    private int status;

    public AuthorizationException() {
        super("Requester lacks the proper authorities to perform that action!", 403);
    }

    public AuthorizationException(String message) {
        super(message, 403);
    }
}
