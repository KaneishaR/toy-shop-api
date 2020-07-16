package com.reesemedia.Exceptions;

public class ResourceNotFoundException extends AppUsersException{

    private int status;

    public ResourceNotFoundException() {
        super("No resource found with provided search criteria!", 404);
    }

    public ResourceNotFoundException(String message) {
        super(message, 404);
    }
}
