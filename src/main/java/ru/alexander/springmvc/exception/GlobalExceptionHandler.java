package ru.alexander.springmvc.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //Если нет в контроллере, то перехватывается здесь
    @ExceptionHandler(MyException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="My reason!")
    public ModelAndView handleMyException(Exception ex) {
        logger.error("MyException handler");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }

}
