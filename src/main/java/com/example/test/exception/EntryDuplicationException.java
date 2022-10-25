package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntryDuplicationException extends RuntimeException{
    public EntryDuplicationException(String message){
        super(message);

    }
}
