package ru.alexander.springmvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.alexander.springmvc.exception.MyException;
import ru.alexander.springmvc.model.User;

@Controller
public class ErrorController {
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/get-error", method = RequestMethod.GET)
    public String getError() throws IOException, MyException {
        this.generateError();
        return "main";
    }
    
    private void generateError() throws IOException, MyException{
//         throw new IOException("I generate new IOException!");
         throw new MyException("I generate new MyException!");
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="My reason!")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
        logger.error("IOException handler");
    }

}
