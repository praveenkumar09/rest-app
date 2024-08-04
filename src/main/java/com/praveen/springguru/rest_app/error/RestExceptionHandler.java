package com.praveen.springguru.rest_app.error;

import com.praveen.springguru.rest_app.error.errorPOJO.StudentErrorResponse;
import com.praveen.springguru.rest_app.error.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The StudentRestExceptionHandler class handles exceptions related to the Student REST API.
 */
@ControllerAdvice
public class RestExceptionHandler {
    /**
     * This method handles the exception when a Student is not found.
     *
     * @param e the StudentNotFoundException to be handled.
     * @return a ResponseEntity containing a StudentErrorResponse object with details of the error.
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFoundException e) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles the exception when a bad request is encountered.
     *
     * @param e the exception to be handled.
     * @return a ResponseEntity containing a StudentErrorResponse object with details of the error.
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleBadRequestException(Exception e) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
