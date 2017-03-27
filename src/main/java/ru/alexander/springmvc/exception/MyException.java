package ru.alexander.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "My Exeption!")
public class MyException extends Exception{

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
    
}
