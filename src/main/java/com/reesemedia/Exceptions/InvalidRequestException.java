package com.reesemedia.Exceptions;

public class InvalidRequestException extends AppUsersException{

    private int status;

    public InvalidRequestException() {
        super("Invalid request made!", 400);
    }

    public InvalidRequestException(String message) {
        super(message, 400);
    }
}
