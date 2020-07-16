package com.reesemedia.Exceptions;

public class BadRequestException extends AppUsersException{
    private int status;

    public BadRequestException() {
        super("An invalid request was made!", 400);
    }

    public BadRequestException(String message) {
        super(message, 400);
    }

}
