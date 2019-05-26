package com.example.restapi.restapi.controller.advice;

import com.example.restapi.restapi.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ProductAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto processNullPointerException(NullPointerException npe) {
        MessageDto message = new MessageDto();
        message.setMessage("Error found in request, try again later");
        message.setType("ERROR");
        return message;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto entityNotFoundException(EntityNotFoundException enf){
        MessageDto message = new MessageDto();
        message.setType("BAD REQUEST");
        message.setMessage("Your request sucks!");
        return message;
    }
}
