package com.reesemedia.Exceptions;

public class ResourcePersistenceException extends AppUsersException{

    private int status;

    public ResourcePersistenceException() {
        super("Resource could not be persisted!", 409);
    }

    public ResourcePersistenceException(String message) {
        super(message, 409);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause, 409);
    }
}
