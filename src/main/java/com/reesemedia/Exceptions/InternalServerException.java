package com.reesemedia.Exceptions;

public class InternalServerException extends AppUsersException {

    private int status;

    public InternalServerException() {
        super("An invalid request was made!", 500);
    }

    public InternalServerException(String message) {
        super(message, 500);
    }
}
