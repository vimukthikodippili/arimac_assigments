package com.example.test.advisor;

import com.example.test.exception.EntryDuplicationException;
import com.example.test.exception.NotFoundException;
import com.example.test.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppWideException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntryDuplicationException.class)
    public ResponseEntity<StandardResponse> handleDuplicateRequestException(EntryDuplicationException  e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(409, e.getMessage(), e),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e),
                HttpStatus.NOT_FOUND);
    }
}
