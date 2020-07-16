package com.reesemedia.Exceptions;

public class AppUsersException extends RuntimeException{

    private int status;

    public AppUsersException(int status){
        super("Authentication Failed!");
        this.status = status;
    }

    public AppUsersException(String message, int status) {
        super(message);
        this.status = status;
    }

    public AppUsersException(String message, Throwable cause, int status){

        super(message, cause);
        this.status = status;

    }

    public int getStatus() {
        return status;
    }
}
