package com.reesemedia.Exceptions;

public class AuthenticationException  extends AppUsersException{

    private int status;

    public AuthenticationException() {
        super("Authentication failed!", 401);
    }
    public AuthenticationException(String message) {
        super(message, 401);
    }
}
