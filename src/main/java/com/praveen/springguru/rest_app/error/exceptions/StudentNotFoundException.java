package com.praveen.springguru.rest_app.error.exceptions;

/**
 * The StudentNotFoundException class represents an exception that is thrown when a student is not found.
 */
public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

}
