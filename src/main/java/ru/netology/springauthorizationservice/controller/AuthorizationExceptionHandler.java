package ru.netology.springauthorizationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springauthorizationservice.service.InvalidCredentials;
import ru.netology.springauthorizationservice.service.UnauthorizedUser;

@RestControllerAdvice
public class AuthorizationExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationExceptionHandler.class);

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidCredentials ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser ex) {

        logger.warn(ex.getMessage());
        return ex.getMessage();
    }
}

